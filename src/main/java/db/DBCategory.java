package db;

import models.Advert;
import models.Category;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCategory {

    private static Session session;

    public static List<Advert> advertsByCategory(Category category) {
        List<Advert> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq("category", category));
            results = cr.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Category findCategoryByName(String title) {
        Category result = null;

        try {
            Criteria cr = session.createCriteria(Category.class);
            cr.add(Restrictions.eq("category.title", title));
            result = (Category) cr.uniqueResult();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {

            session.close();

        }
        return result;
    }
}
