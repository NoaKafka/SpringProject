package com.bridge.Relationship.Service;

import com.bridge.Relationship.Data.Relationship;
import com.bridge.Relationship.Data.RelationshipEntity;

import java.util.List;
import java.util.Optional;

public interface RelationshipService {

    String addFriend(Relationship relationship);

    List<String> getFriends(String userName);

    Optional<RelationshipEntity> breakRelationship(Relationship relationship);
}
