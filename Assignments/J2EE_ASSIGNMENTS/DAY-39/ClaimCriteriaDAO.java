package com.hibernate.Wipro_HibernateProject;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
public class ClaimCriteriaDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Claim> getClaimsByPolicyNumber(String policyNumber) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Claim> criteriaQuery = criteriaBuilder.createQuery(Claim.class);
        Root<Claim> root = criteriaQuery.from(Claim.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("policy").get("policyNumber"), policyNumber));
        return session.createQuery(criteriaQuery).getResultList();
    }

    public List<Claim> getClaimsByClaimDateRange(Date startDate, Date endDate) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Claim> criteriaQuery = criteriaBuilder.createQuery(Claim.class);
        Root<Claim> root = criteriaQuery.from(Claim.class);
        criteriaQuery.where(criteriaBuilder.between(root.get("claimDate"), startDate, endDate));
        return session.createQuery(criteriaQuery).getResultList();
    }
}