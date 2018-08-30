package db;

import models.Advert;
import models.DeliveryOption;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBUser {

    private static Session session;
    private static Transaction transaction;

    public static Set<Advert> findUserFavouriteAds(User user) {
        List<Advert> results = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.createAlias("favourites", "user");
            cr.add(Restrictions.eq("user.id", user.getId()));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        Set<Advert> favourites = new HashSet<>();
        for (Advert item : results) {
            favourites.add(item);
        }
        return favourites;
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

    public static <T> List<T> getAllNotArchivedByFirstName(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(classType);
        cr.add(Restrictions.eq("archived", false));
        cr.addOrder(Order.asc("firstName"));
        return getList(cr);
    }

    public static <T> List<T> getAllByFirstName(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(classType);
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        cr.addOrder(Order.asc("firstName"));
        return getList(cr);
    }
}
