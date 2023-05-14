import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;
import model.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setName("User is inserted by hibernate");
        usersEntity.setUserId(127123);

        try (Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(usersEntity);
            transaction.commit();
        }

        try (Session session = getSession()) {
            System.out.println(session.get(UsersEntity.class, usersEntity.getUserId()).getName());
        }
    }
}