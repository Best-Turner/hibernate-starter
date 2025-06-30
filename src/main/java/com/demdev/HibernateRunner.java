package com.demdev;

import com.demdev.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.configure();


        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            User user = User.builder()
                    .username("petr@mail.ru")
                    .firstname("Petr")
                    .lastname("Petrov")
                    .birthDay(LocalDate.of(2010, 5, 21))
                    .age(15)
                    .build();

            session.save(user);
            session.getTransaction().commit();
        }
    }
}
