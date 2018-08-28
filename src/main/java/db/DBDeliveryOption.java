package db;

import models.Advert;
import models.DeliveryOption;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDeliveryOption {

    private static Session session;

    public static List<Advert> findAdvertsByDeliveryOption(DeliveryOption deliveryOption){
        List<Advert> results = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try{
            Criteria cr = session.createCriteria(Advert.class);
            cr.createAlias("deliveryOptions", "delivery_option");
            cr.add(Restrictions.eq("delivery_option.id", deliveryOption.getId()));
            results = cr.list();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }
}
