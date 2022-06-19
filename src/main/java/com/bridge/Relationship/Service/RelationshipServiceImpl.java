package com.bridge.Relationship.Service;

import com.bridge.Relationship.Data.Relationship;
import com.bridge.Relationship.Data.RelationshipEntity;
import com.bridge.Relationship.Repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelationshipServiceImpl implements RelationshipService {

    private final RelationshipRepository relationshipRepository;

    @Autowired
    public RelationshipServiceImpl(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    @Override
    @Transactional
    public String addFriend(Relationship relationship) {

        relationshipRepository.save(RelationshipEntity.builder()
                .userName(relationship.getUserName())
                .friendName(relationship.getFriendName())
                .status(1)
                .build());

        return "success";
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getFriends(String userName) {
        List<RelationshipEntity> result = relationshipRepository.findAllByUserName(userName);
        List<String> fList = new ArrayList<>();

        for (RelationshipEntity r : result) {
            if(r.getStatus() == 1){
                fList.add(r.getFriendName());
            }
        }
        return fList;
    }
}
