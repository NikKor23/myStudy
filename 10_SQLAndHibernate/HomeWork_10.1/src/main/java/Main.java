import Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static String config = "hibernate.cfg.xml";

    public static void main(String[] args)
    {
        Logger log = Logger.getLogger("org.hibernate");
            log.setLevel(Level.OFF);
        HibernateBuilder hibernateBuilder = new HibernateBuilder(config);
        SessionFactory sessionFactory = hibernateBuilder.getSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = session.get(Student.class, 1);
        Course course = session.get(Course.class, 1);
        Teacher teacher = session.get(Teacher.class, 10);
        Purchase pl = session.get(Purchase.class, new PLID( "Абакумов Казимир", "PHP-разработчик с 0 до PRO"));
        Subscription sub = session.get(Subscription.class, new SubID(100, 19));

        System.out.println(pl.getSubscriptionDate() + " - " + pl.getPrice() );

        sessionFactory.close();
    }
}
