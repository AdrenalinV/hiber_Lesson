package ru.geekbrains.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDProducts {
    private static SessionFactory factory;

    public static void init(){
        PrepareDataApp.forcePrepareData();
        factory= new Configuration()
                .configure("conf/hib.cfg.xml")
                .buildSessionFactory();

    }

    public static void shutdown(){
        factory.close();
    }

    public static void createExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product dragonStatue = new Product("Lemonade", 0.20);
            System.out.println(dragonStatue);
            session.saveOrUpdate(dragonStatue);
            System.out.println(dragonStatue);
            session.getTransaction().commit();
            System.out.println(dragonStatue);
        }
    }

    public static void readAndPrintExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            System.out.println(product);
            session.getTransaction().commit();
            System.out.println(product);
        }
    }

    public static void updateExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            System.out.println(product);
            session.evict(product);
            product.setCost(10000);
            System.out.println(product);
            session.update(product);
            session.getTransaction().commit();
            System.out.println(product);

        }
    }

    public static void deleteExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        try {
            init();
            createExample();
            readAndPrintExample();
            updateExample();
            deleteExample();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

}
