package org.kainos.ea.daos;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.kainos.ea.cli.Application;

public class ApplicationDAO {
    private final SessionFactory sessionFactory;

    public ApplicationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Application application) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(application);
            transaction.commit();
        }
    }

    public Application read(UUID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Application.class, id);
        }
    }

    public void update(Application application) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(application);
            transaction.commit();
        }
    }

    public void delete(UUID id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Application application = session.get(Application.class, id);
            session.delete(application);
            transaction.commit();
        }
    }
}

