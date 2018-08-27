package controllers;

import db.DBHelper;
import models.DeliveryOption;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class DeliveryOptionController {

    public DeliveryOptionController() {
        setupEndpoints();
    }

    private void setupEndpoints() {

        //index
        get("/delivery-options", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<DeliveryOption> deliveryOptions = DBHelper.getAll(DeliveryOption.class);
            model.put("deliveryOptions", deliveryOptions);
            model.put("template", "templates/deliveryOptions/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        //new
        get("/delivery-options/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/deliveryOptions/new.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        //create
        post("/delivery-options", (req, res) -> {
            String title = req.queryParams("title");
            double price = Double.parseDouble(req.queryParams("price"));
            DeliveryOption deliveryOption = new DeliveryOption(title, price);
            DBHelper.save(deliveryOption);
            res.redirect("/delivery-options/"+deliveryOption.getId());
            return null;
        });
        //edit
        get("/delivery-options/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Integer id = Integer.parseInt(req.params("id"));
            DeliveryOption deliveryOption = DBHelper.find(id, DeliveryOption.class);
            model.put("deliveryOption", deliveryOption);
            model.put("template", "templates/deliveryOptions/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        //update
        post("/delivery-options/:id", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            DeliveryOption deliveryOption = DBHelper.find(id, DeliveryOption.class);
            String title = req.queryParams("title");
            double price = Double.parseDouble(req.queryParams("price"));
            deliveryOption.setTitle(title);
            deliveryOption.setPrice(price);
            DBHelper.save(deliveryOption);
            res.redirect("/delivery-options/"+deliveryOption.getId());
            return null;
        });
        //destroy(could be archive)
        post("/delivery-options/:id/delete", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            DeliveryOption deliveryOption = DBHelper.find(id, DeliveryOption.class);
            DBHelper.delete(deliveryOption);
            res.redirect("/delivery-options");
            return null;
        });
        //show
        get("/delivery-options/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Integer id = Integer.parseInt(req.params(":id"));
            DeliveryOption deliveryOption = DBHelper.find(id, DeliveryOption.class);
            model.put("deliveryOption", deliveryOption);
            model.put("template", "templates/deliveryOptions/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
