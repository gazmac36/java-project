package controllers;

import db.DBAdvert;
import db.DBCategory;
import db.DBHelper;
import db.Seeds;
import models.Advert;
import models.Category;
import models.Comment;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {
    public static void main(String[] args) {

        Seeds.seedData();

        staticFileLocation("/public");

        AdvertController advertController = new AdvertController();
        CategoryController categoryController = new CategoryController();
        DeliveryOptionController deliveryOptionController = new DeliveryOptionController();
        UserController userController = new UserController();
        CommentController commentController = new CommentController();

//        get("/", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            List<Category> categories = DBHelper.getAll(Category.class);
//            model.put("categories", categories);
//            model.put("template","templates/adverts/index.vtl");
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, new VelocityTemplateEngine());

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBHelper.getAllById(Advert.class);
            List<Advert> searchResult = DBAdvert.searchForAdvert(req.queryParams("query"));
            model.put("results", searchResult);
            model.put("adverts", adverts);
            model.put("template", "templates/adverts/index.vtl");
            List<Category> categories = DBCategory.getAllNotArchivedByCategoryName(Category.class);
            model.put("categories", categories);
            model.put("template","templates/main.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }

}
