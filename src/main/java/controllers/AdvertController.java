package controllers;

import db.DBHelper;
import models.Advert;
import models.Category;
import models.DeliveryOption;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static spark.Spark.get;
import static spark.Spark.post;

public class AdvertController {

    public AdvertController() {
        setupEndPoints();
    }

    public void setupEndPoints() {
        //index
        get("/adverts", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBHelper.getAll(Advert.class);
            model.put("template", "templates/advert/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        //new
        get("/adverts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categories = DBHelper.getAll(Category.class);
            model.put("categories", categories);
            model.put("template", "templates/advert/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        //create
        post("/adverts", (req, res) -> {
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            double askingPrice = Double.parseDouble(req.queryParams("askingPrice"));
            int catId = Integer.parseInt(req.queryParams("category"));
            Category category = DBHelper.find(catId, Category.class);
            Set<String> deliveryOptions = req.queryParams();
//            Advert advert = new Advert(title, description, askingPrice, category, deliveryOptions);
//            DBHelper.save(advert);
//            res.redirect("/adverts");
            return null;
        });
        //show
        //edit
        //update
        //destroy(could be archive)
    }
}
