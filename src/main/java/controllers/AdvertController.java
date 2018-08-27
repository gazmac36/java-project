package controllers;

import db.DBAdvert;
import db.DBHelper;
import models.Advert;
import models.Category;
import models.DeliveryOption;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateNameHelper;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class AdvertController {

    public AdvertController() {
        setupEndpoints();
    }

    private void setupEndpoints() {
        //index
        get("/adverts", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBHelper.getAll(Advert.class);
            model.put("adverts", adverts);
            model.put("template", "templates/adverts/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        //new
        get("/adverts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categories = DBHelper.getAll(Category.class);
            List<DeliveryOption> deliveryOptions = DBHelper.getAll(DeliveryOption.class);
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
            res.redirect("/adverts/"+advert.getId());
            return null;
        });


//        //show
//        post("/adverts/:id")
//        //edit
//        //update
//        //destroy(could be archive)

        //show
//        post("/adverts/:id", (req, res)->{
//            Map<String, Object> model = new HashMap<>();
//            int id = Integer.parseInt(req.queryParams("id"));
//            Advert advert = DBHelper.find(id, Advert.class);
//
//
//        });

        //edit
        get("/adverts/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Integer id = Integer.parseInt(req.params(":id"));
            List<Category> categories = DBHelper.getAll(Category.class);
            List<DeliveryOption> deliveryOptions = DBHelper.getAll(DeliveryOption.class);
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
        post("/adverts/:id", (req, res) ->{
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
            res.redirect("/adverts/"+advert.getId());
            return null;
        });
        //destroy(could be archive)
        post("/adverts/:id/delete", (req, res) ->{
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
            Advert advert = DBHelper.find(id, Advert.class);

            Set<DeliveryOption> deliveryOptions = DBAdvert.findDeliveryOptionsByAdvert(advert);

            model.put("deliveryOptions", deliveryOptions);
            model.put("advert", advert);
            model.put("template", "templates/adverts/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



    }

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

