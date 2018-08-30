package controllers;

import db.DBCategory;
import db.DBHelper;
import models.Advert;
import models.Category;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class CategoryController {

    public CategoryController() {
        setupEndpoints();
    }

    private void setupEndpoints() {


        get("categories/:id/adverts", (req,res) -> {
            Integer intId = Integer.parseInt(req.params("id"));
            Category category = DBHelper.find(intId, Category.class);
            List<Advert> adverts = DBCategory.findAdvertsByCategory(category);

            Map<String, Object> model = new HashMap<>();
            model.put("adverts", adverts);
            model.put("template", "templates/categories/advertFilter.vtl");
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        get("/categories/:id/edit", (req, res) -> {
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
            List<Category> categories = DBCategory.getAllByCategoryName(Category.class);
            model.put("template", "templates/categories/index.vtl");
            model.put("categories", categories);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/categories/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/categories/new.vtl");
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

        get ("/categories/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category category = DBHelper.find(intId, Category.class);
            model.put("template", "templates/categories/confirmDelete.vtl");
            model.put("category", category);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //archive & destroy
        //get method for archive is also get method for destroy
        get("/categories/:id/archive", (req, res)->{
            Integer id = Integer.parseInt(req.params(":id"));
            Category category= DBHelper.find(id, Category.class);
            Map<String, Object> model = new HashMap<>();
            if (DBCategory.findAdvertsByCategory(category).size() == 0){
                model.put("template", "templates/categories/confirmDelete.vtl");
                model.put("category", category);
            } else {
                model.put("template", "templates/categories/confirmArchive.vtl");
                model.put("category", category);
            }
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/categories/:id/archive", (req, res) ->{
            Integer id = Integer.parseInt(req.params(":id"));
            Category category= DBHelper.find(id, Category.class);
            category.setArchived(true);
            DBHelper.save(category);
            res.redirect("/categories");
            return null;
        });

        post ("/categories/:id/delete", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category categoryToDelete = DBHelper.find(intId, Category.class);
            DBHelper.delete(categoryToDelete);
            res.redirect("/categories");
            return null;
        }, new VelocityTemplateEngine());

        post ("/categories", (req, res) -> {
            String categoryName = req.queryParams("categoryName");
            Category category = new Category(categoryName);
            DBHelper.save(category);
            res.redirect("/categories");
            return null;
        }, new VelocityTemplateEngine());



        post ("/categories/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Category category = DBHelper.find(intId, Category.class);
            String categoryName = req.queryParams("categoryName");
            category.setCategoryName(categoryName);
            DBHelper.save(category);
            res.redirect("/categories");
            return null;

        }, new VelocityTemplateEngine());

        post("/categories/:id/unarchive", (req, res) ->{
            Integer id = Integer.parseInt(req.params(":id"));
            Category category= DBHelper.find(id, Category.class);
            category.setArchived(false);
            DBHelper.save(category);
            res.redirect("/categories");
            return null;
        });

    }
    
}
