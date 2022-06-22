package com.bridge.Relationship.Service;

import com.bridge.Relationship.Data.Relationship;
import com.bridge.Relationship.Data.RelationshipEntity;

import java.util.List;

public interface RelationshipService {

    String addFriend(Relationship relationship);

    List<String> getFriends(String userName);

    List<RelationshipEntity> deleteFriend(Relationship relationship);
}
