package com.bridge.Relationship.Service;

import com.bridge.Relationship.Data.Relationship;

import java.util.List;

public interface RelationshipService {

    public String addFriend(Relationship relationship);

    public List<String> getFriends(String userName);

}
