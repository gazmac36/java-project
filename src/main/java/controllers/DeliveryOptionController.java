package controllers;

import db.DBHelper;
import models.DeliveryOption;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

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
        //create
        //edit
        //update
        //destroy(could be archive)
        //show
    }
}
