package com.znznhome.util;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
@Component("hibernateUtil")
public class HibernateUtil {

    private static SessionFactory sessionFactory ;

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
