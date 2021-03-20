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

        Course course = session.get(Course.class, 1);

        Student student = session.get(Student.class, 1);

        System.out.println(course.getName() + "\t Студентов на курсе: " + course.getStudentsCount());
        System.out.println(student.getName()  + ", " + student.getAge()+ " лет. Дата регистрации: " + student.getRegistrationDate());
        sessionFactory.close();
    }
}
