import Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
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

        Query studentQuery = session.createQuery("from Student where name = :name");
        Query courseQuery = session.createQuery("from Course where name = :name");
        Transaction transaction = session.beginTransaction();
        List<Purchase> purchaseList = session.createQuery("From Purchase", Purchase.class).list();
        purchaseList.forEach(p -> {

            studentQuery.setParameter("name", p.getId().getStudentName());
            courseQuery.setParameter("name", p.getId().getCourseName());

            Student student = (Student) studentQuery.getSingleResult();
            int studentId = student.getId();

            Course course = (Course) courseQuery.getSingleResult();
            int courseId = course.getId();

            LinkedPurchase lp = new LinkedPurchase(new LinkedPurchaseID(studentId, courseId));
            System.out.println(lp);
            session.save(lp);
        });

        transaction.commit();
        sessionFactory.close();
    }
}
