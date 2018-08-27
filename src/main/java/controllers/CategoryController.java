package controllers;

import db.DBHelper;
import models.Category;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class CategoryController {

    private void setupEndpoints() {

        get("/category/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category category = DBHelper.find(intId, Category.class);

            Map<String, Object> model = new HashMap<>();
            model.put("category", category);
            model.put("template", "templates/categories/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/categories", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categories = DBHelper.getAll(Category.class);
            model.put("template", "templates/categories/index.vtl");
            model.put("categories", categories);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/categories/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/categories/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/categories/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category category = DBHelper.find(intId, Category.class);
            Map<String, Object> model = new HashMap<>();
            model.put("category", category);
            model.put("template", "templates/categories/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/categories/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/categories/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/categories", (req, res) -> {
            String categoryName = req.queryParams("name");
            Category category = new Category(categoryName);
            DBHelper.save(category);
            res.redirect("/categories");
            return null;
        }, new VelocityTemplateEngine());

        post ("/categories/:id/delete", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category categoryToDelete = DBHelper.find(intId, Category.class);
            DBHelper.delete(categoryToDelete);
            res.redirect("/categories");
            return null;
        }, new VelocityTemplateEngine());

        post ("/categories/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category category = DBHelper.find(intId, Category.class);
            String categoryName = req.queryParams("name");
            category.setCategoryName(categoryName);
            DBHelper.save(category);
            res.redirect("/categories");
            return null;

        }, new VelocityTemplateEngine());

    }
    
}
