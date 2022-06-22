package com.bridge.Relationship.Repository;

import com.bridge.Relationship.Data.QRelationshipEntity;
import com.bridge.Relationship.Data.RelationshipEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bridge.Relationship.Data.QRelationshipEntity.relationshipEntity;

@Repository
public class RelationshipRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public RelationshipRepositorySupport(JPAQueryFactory queryFactory) {
        super(RelationshipEntity.class);
        this.queryFactory = queryFactory;
    }

    public List<RelationshipEntity> findAllByUserName(String userName){
        return queryFactory
                .selectFrom(relationshipEntity)
                .where(relationshipEntity.userName.eq(userName))
                .fetch();
    }
}
