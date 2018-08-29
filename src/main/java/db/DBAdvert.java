package db;


import models.Advert;
import models.DeliveryOption;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBAdvert {
    private static Session session;
    public static void addDeliveryOptionToAdvert(Advert advert, DeliveryOption deliveryOption){
        advert.addDeliveryOption(deliveryOption);
        DBHelper.save(advert);
    }

    public static Set<DeliveryOption> findDeliveryOptionsByAdvert(Advert advert){
        List<DeliveryOption> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(DeliveryOption.class);
            cr.createAlias("adverts", "advert");
            cr.add(Restrictions.eq("advert.id", advert.getId()));
            results = cr.list();

        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        Set<DeliveryOption> deliveryOptions = new HashSet<>();
        for(DeliveryOption item:results){
            deliveryOptions.add(item);
        }
        return deliveryOptions;
    }
    public static List<Advert> searchForAdvert(String query){
        List<Advert> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq("archived", false));
            cr.add(Restrictions.ilike("title", query, MatchMode.ANYWHERE));
            results = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
