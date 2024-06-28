package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public class ClaimStatusUpdateRepository {

    @Autowired
    private R2dbcEntityTemplate template;

    public Mono<Long> updateClaimStatus(Long claimId, ClaimStatusUpdate update) {
        String sql = "UPDATE claim_status_update_table SET claim_status = :claimStatus WHERE claim_id = :claimId";
        
        return template.getDatabaseClient()
                .sql(sql)
                .bind("claimStatus", update.getStatus())
                .bind("claimId", claimId)
                .fetch()
                .rowsUpdated();
    }
}