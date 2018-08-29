package controllers;

import db.DBHelper;
import models.Advert;
import models.Comment;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.post;

public class CommentController {

    public CommentController() {
        setupEndpoints();
    }

    private void setupEndpoints() {
        //create
        post("/adverts/:advertId/post-comment", (req, res) -> {
            Integer advertId = Integer.parseInt(req.params(":advertId"));
            String body = req.queryParams("body");
            Advert advert = DBHelper.find(advertId, Advert.class);
            Comment comment = new Comment(advert, body);
            DBHelper.save(comment);
            res.redirect("/adverts/" + req.params(":advertId"));
            return null;
        });
        //destroy
        post("/adverts/:advertId/:id/delete", (req, res) -> {
            Integer id = Integer.parseInt(req.params(":id"));
            Comment comment = DBHelper.find(id, Comment.class);
            DBHelper.delete(comment);
            res.redirect("/adverts/" + req.params(":advertId"));
            return null;
        });

    }
}
