package com.hibernate.Wipro_HibernateProject;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
public class ClaimDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveClaim(Claim claim) {
        Session session = sessionFactory.getCurrentSession();
        session.save(claim);
    }

    public Claim getClaim(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Claim.class, id);
    }

    public List<Claim> getAllClaims() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Claim", Claim.class).getResultList();
    }

    public void updateClaim(Claim claim) {
        Session session = sessionFactory.getCurrentSession();
        session.update(claim);
    }

    public void deleteClaim(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Claim claim = session.get(Claim.class, id);
        session.delete(claim);
    }
}