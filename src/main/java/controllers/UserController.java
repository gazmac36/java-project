package controllers;

import db.DBHelper;
import db.DBUser;
import models.Advert;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class UserController {

    public UserController() {
        setupEndpoints();
    }

    private void setupEndpoints() {


        get("/users/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            User user = DBHelper.find(intId, User.class);

            Map<String, Object> model = new HashMap<>();
            model.put("user", user);
            model.put("template", "templates/users/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/users", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<User> users = DBUser.getAllByFirstName(User.class);
            model.put("template", "templates/users/index.vtl");
            model.put("users", users);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/users/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/users/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/users/:id", (req, res) -> {
            Integer intId = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(intId, User.class);
            Set<Advert> favourites = DBUser.findUserFavouriteAds(user);
            Map<String, Object> model = new HashMap<>();
            model.put("favourites", favourites);
            model.put("user", user);
            model.put("template", "templates/users/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/users/:id/archive", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(id, User.class);
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/users/confirmArchive.vtl");
            model.put("user", user);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/users/:id/archive", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(id, User.class);
            user.setArchived(true);
            DBHelper.save(user);
            res.redirect("/users");
            return null;
        });

        get("/users/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            User user = DBHelper.find(intId, User.class);
            model.put("template", "templates/users/confirmDelete.vtl");
            model.put("user", user);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/users/:id/delete", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            User userToDelete = DBHelper.find(intId, User.class);
            DBHelper.delete(userToDelete);
            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());

        post("/users", (req, res) -> {
            String firstName = req.queryParams("firstName");
            String lastName = req.queryParams("lastName");
            String addressLine1 = req.queryParams("addressLine1");
            String addressLine2 = req.queryParams("addressLine2");
            String addressCity = req.queryParams("addressCity");
            String addressCounty = req.queryParams("addressCounty");
            String addressPostcode = req.queryParams("addressPostcode");
            String username = req.queryParams("username");
            String contactPhone = req.queryParams("contactPhone");
            String contactEmail = req.queryParams("contactEmail");

            User user = new User(firstName, lastName, addressLine1, addressLine2, addressCity, addressCounty, addressPostcode, username, contactPhone, contactEmail);
            DBHelper.save(user);
            res.redirect("/users");
            return null;
        }, new VelocityTemplateEngine());


        post("/users/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            User user = DBHelper.find(intId, User.class);

            String firstName = req.queryParams("firstName");
            String lastName = req.queryParams("lastName");
            String addressLine1 = req.queryParams("addressLine1");
            String addressLine2 = req.queryParams("addressLine2");
            String addressCity = req.queryParams("addressCity");
            String addressCounty = req.queryParams("addressCounty");
            String addressPostcode = req.queryParams("addressPostcode");
            String username = req.queryParams("username");
            String contactPhone = req.queryParams("contactPhone");
            String contactEmail = req.queryParams("contactEmail");

            user.setFirstName(firstName);
            user.setAddressLine1(addressLine1);
            user.setAddressLine2(addressLine2);
            user.setAddressCity(addressCity);
            user.setAddressCounty(addressCounty);
            user.setAddressPostcode(addressPostcode);
            user.setUsername(username);
            user.setContactPhone(contactPhone);
            user.setContactEmail(contactEmail);

            DBHelper.save(user);
            res.redirect("/users");
            return null;

        }, new VelocityTemplateEngine());

        post("/users/:id/unarchive", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            User user = DBHelper.find(id, User.class);
            user.setArchived(false);
            DBHelper.save(user);
            res.redirect("/users");
            return null;
        });



    }

}
