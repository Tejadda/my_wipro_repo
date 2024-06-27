package com.hibernate.Wipro_HibernateProject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
public class PolicyDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void savePolicy(Policy policy) {
        Session session = sessionFactory.getCurrentSession();
        session.save(policy);
    }

    public Policy getPolicy(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Policy.class, id);
    }

    public List<Policy> getAllPolicies() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Policy", Policy.class).getResultList();
    }

    public void updatePolicy(Policy policy) {
        Session session = sessionFactory.getCurrentSession();
        session.update(policy);
    }

    public void deletePolicy(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Policy policy = session.get(Policy.class, id);
        session.delete(policy);
    }
}