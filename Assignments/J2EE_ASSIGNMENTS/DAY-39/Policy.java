package com.hibernate.Wipro_HibernateProject;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "policy_holder_name")
    private String policyHolderName;

    @Column(name = "policy_start_date")
    private Date policyStartDate;

    @Column(name = "policy_end_date")
    private Date policyEndDate;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Claim> claims;

    // Getters and setters
}