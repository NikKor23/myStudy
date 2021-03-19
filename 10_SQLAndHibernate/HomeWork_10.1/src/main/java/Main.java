import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args)
    {
        Logger log = Logger.getLogger("org.hibernate");
            log.setLevel(Level.OFF);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 1);

        Student student = session.get(Student.class, 1);

        System.out.println(course.getName() + "\t Студентов на курсе: " + course.getStudentsCount());
        System.out.println(student.getName()  + ", " + student.getAge()+ " лет. Дата регистрации: " + student.getRegistrationDate());
        sessionFactory.close();
    }
}
