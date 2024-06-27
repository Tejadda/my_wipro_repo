package com.hibernate.Wipro_HibernateProject;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
public class ClaimHQLDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Claim> getClaimsByPolicyNumber(String policyNumber) {
        Session session = sessionFactory.getCurrentSession();
        Query<Claim> query = session.createQuery("from Claim c where c.policy.policyNumber = :policyNumber", Claim.class);
        query.setParameter("policyNumber", policyNumber);
        return query.getResultList();
    }

    public List<Claim>getClaimsByClaimDateRange(Date startDate, Date endDate) {
        Session session = sessionFactory.getCurrentSession();
        Query<Claim> query = session.createQuery("from Claim c where c.claimDate between :startDate and :endDate", Claim.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }
}