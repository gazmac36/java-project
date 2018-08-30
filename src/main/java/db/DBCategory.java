package db;

import models.Advert;
import models.Category;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Collections;
import java.util.List;

public class DBCategory {

    private static Session session;
    private static Transaction transaction;

    public static List<Advert> findAdvertsByCategory(Category category) {
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
        for (Advert item : results){
            if (item.isArchived()){
                results.remove(item);
            }
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

    public static <T> List<T> getList(Criteria criteria) {
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            ;
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> List<T> getAllNotArchivedByCategoryName(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(classType);
        cr.add(Restrictions.eq("archived", false));
        cr.addOrder(Order.asc("categoryName"));
        return getList(cr);
    }

    public static <T> List<T> getAllByCategoryName(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(classType);
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        cr.addOrder(Order.asc("categoryName"));
        return getList(cr);
    }
}
