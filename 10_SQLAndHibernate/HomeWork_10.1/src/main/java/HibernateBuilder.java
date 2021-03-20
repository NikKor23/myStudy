import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateBuilder {
    private StandardServiceRegistry ssr;
    private Metadata metadata;
    private SessionFactory sessionFactory;

    public HibernateBuilder(String config) {
        ssr = new StandardServiceRegistryBuilder().configure(config).build();
        metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
