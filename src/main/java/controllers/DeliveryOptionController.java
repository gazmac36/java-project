package controllers;

import db.DBDeliveryOption;
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

        //archive & destroy
        //get method for archive is also get method for destroy
        get("/delivery-options/:id/archive", (req, res)->{
            Integer id = Integer.parseInt(req.params(":id"));
            DeliveryOption deliveryOption= DBHelper.find(id, DeliveryOption.class);
            Map<String, Object> model = new HashMap<>();
            if (DBDeliveryOption.findAdvertsByDeliveryOption(deliveryOption).size() == 0){
                model.put("template", "templates/deliveryOptions/confirmDelete.vtl");
                model.put("deliveryOption", deliveryOption);
            } else {
                model.put("template", "templates/deliveryOptions/confirmArchive.vtl");
                model.put("deliveryOption", deliveryOption);
            }
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/delivery-options/:id/archive", (req, res) ->{
            Integer id = Integer.parseInt(req.params(":id"));
            DeliveryOption deliveryOption= DBHelper.find(id, DeliveryOption.class);
            deliveryOption.setArchived(true);
            DBHelper.save(deliveryOption);
            res.redirect("/delivery-options");
            return null;
        });

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
