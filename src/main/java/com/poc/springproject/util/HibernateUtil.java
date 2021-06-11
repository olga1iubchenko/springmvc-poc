//package com.poc.springproject.util;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.springframework.context.annotation.Bean;
//
//public class HibernateUtil {
//
//    @SuppressWarnings("deprecation")
//    public static Session getHibernateSession() {
//
//        final SessionFactory sf = new Configuration().configure("criteria.cfg.xml").buildSessionFactory();
//        final Session session = sf.openSession();
//        return session;
//    }
//
//}