package com.bridge.Relationship.Repository;

import com.bridge.Relationship.Data.RelationshipEntity;
import com.bridge.User.Data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelationshipRepository extends JpaRepository<RelationshipEntity, Long> {
    List<RelationshipEntity> findAllByUserName(String userName);
}
