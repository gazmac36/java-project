package controllers;

import db.DBAdvert;
import db.DBCategory;
import db.DBHelper;
import db.DBUser;
import models.*;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateNameHelper;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class AdvertController {

    public AdvertController() {
        setupEndpoints();
    }

    private void setupEndpoints() {


        //index
        get("/adverts", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBHelper.getAllById(Advert.class);
            List<Advert> searchResult = DBAdvert.searchForAdvert(req.queryParams("query"));
            model.put("results", searchResult);
            model.put("adverts", adverts);
            model.put("template", "templates/adverts/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        //new
        get("/adverts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categories = DBCategory.getAllNotArchivedByCategoryName(Category.class);
            List<DeliveryOption> deliveryOptions = DBHelper.getAllNotArchivedById(DeliveryOption.class);
            model.put("categories", categories);
            model.put("deliveryOptions", deliveryOptions);
            model.put("template", "templates/adverts/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        //create
        post("/adverts", (req, res) -> {
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            double askingPrice = Double.parseDouble(req.queryParams("askingPrice"));
            int catId = Integer.parseInt(req.queryParams("category"));
            Category category = DBHelper.find(catId, Category.class);
            Set<String> allParams = req.queryParams();
            Set<DeliveryOption> deliveryOptions = assignDeliveryOption(allParams);

            Advert advert = new Advert(title, description, category, askingPrice);
            advert.setDeliveryOptions(deliveryOptions);
            DBHelper.save(advert);
            res.redirect("/adverts/" + advert.getId());
            return null;
        });

        //edit
        get("/adverts/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Integer id = Integer.parseInt(req.params(":id"));
            List<Category> categories = DBCategory.getAllNotArchivedByCategoryName(Category.class);
            List<DeliveryOption> deliveryOptions = DBHelper.getAllNotArchivedById(DeliveryOption.class);
            Advert advert = DBHelper.find(id, Advert.class);

            Set<DeliveryOption> advertDeliveryOptions = DBAdvert.findDeliveryOptionsByAdvert(advert);

            model.put("advertDeliveryOptions", advertDeliveryOptions);
            model.put("deliveryOptions", deliveryOptions);
            model.put("categories", categories);
            model.put("advert", advert);
            model.put("template", "templates/adverts/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        //update
        post("/adverts/:id", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.find(id, Advert.class);
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            double askingPrice = Double.parseDouble(req.queryParams("askingPrice"));
            int catId = Integer.parseInt(req.queryParams("category"));
            Category category = DBHelper.find(catId, Category.class);
            Set<String> allParams = req.queryParams();
            Set<DeliveryOption> deliveryOptions = assignDeliveryOption(allParams);

            advert.setTitle(title);
            advert.setDescription(description);
            advert.setAskingPrice(askingPrice);
            advert.setCategory(category);
            advert.setDeliveryOptions(deliveryOptions);
            DBHelper.save(advert);
            res.redirect("/adverts/" + advert.getId());
            return null;
        });
        //archive
        get("/adverts/:id/archive", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.find(id, Advert.class);
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/adverts/confirmArchive.vtl");
            model.put("advert", advert);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/adverts/:id/archive", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.find(id, Advert.class);
            advert.setArchived(true);
            DBHelper.save(advert);
            res.redirect("/adverts");
            return null;
        });
        //destroy
        get("/adverts/:id/delete", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.find(id, Advert.class);
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/adverts/confirmDelete.vtl");
            model.put("advert", advert);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/adverts/:id/delete", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.find(id, Advert.class);
            DBHelper.delete(advert);

            res.redirect("/adverts");
            return null;
        });

        //show
        get("/adverts/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Integer id = Integer.parseInt(req.params(":id"));
            List<User> users = DBUser.getAllNotArchivedByFirstName(User.class);
            Advert advert = DBHelper.find(id, Advert.class);
            List<Comment> comments = DBAdvert.findCommentsByAdvert(advert);
            Set<DeliveryOption> deliveryOptions = DBAdvert.findDeliveryOptionsByAdvert(advert);
            model.put("users",users);
            model.put("comments", comments);
            model.put("deliveryOptions", deliveryOptions);
            model.put("advert", advert);
            model.put("template", "templates/adverts/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/adverts/:id/unarchive", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.find(id, Advert.class);
            advert.setArchived(false);
            DBHelper.save(advert);
            res.redirect("/adverts");
            return null;
        });

        //add as a favorite
        post("/adverts/:id/add-favourite", (req, res) -> {
            Integer userId = Integer.parseInt(req.queryParams("user"));
            Integer id = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.find(id, Advert.class);
            User user = DBHelper.find(userId, User.class);
            Set<Advert> favourites = DBUser.findUserFavouriteAds(user);
            favourites.add(advert);
            user.setFavourites(favourites);
            DBHelper.save(user);
            res.redirect("/adverts/" + req.params(":id"));
            return null;
        });

    }


    //private methods
    private List<Integer> getOptionsFromAllParams(Set<String> params) {
        List<Integer> ids = new ArrayList<>();
        for (String param : params) {
            if (param.contains("_option")) {
                String[] slicedParam = param.split("_");
                ids.add(Integer.parseInt(slicedParam[0]));
            }
        }
        return ids;
    }

    private Set<DeliveryOption> findOptionsOnDatabase(List<Integer> ids) {
        Set<DeliveryOption> deliveryOptions = new HashSet<>();
        for (int id : ids) {
            DeliveryOption deliveryOption = DBHelper.find(id, DeliveryOption.class);
            deliveryOptions.add(deliveryOption);
        }
        return deliveryOptions;
    }

    private Set<DeliveryOption> assignDeliveryOption(Set<String> params) {
        List<Integer> ids = getOptionsFromAllParams(params);
        return findOptionsOnDatabase(ids);
    }


}