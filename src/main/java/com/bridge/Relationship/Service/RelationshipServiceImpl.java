package com.bridge.Relationship.Service;

import com.bridge.Relationship.Data.Relationship;
import com.bridge.Relationship.Data.RelationshipEntity;
import com.bridge.Relationship.Repository.RelationshipRepository;
import com.bridge.Relationship.Repository.RelationshipRepositorySupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RelationshipServiceImpl implements RelationshipService {

    private final RelationshipRepository relationshipRepository;
    private final RelationshipRepositorySupport repositorySupport;

    @Autowired
    public RelationshipServiceImpl(RelationshipRepository relationshipRepository, RelationshipRepositorySupport repositorySupport) {
        this.relationshipRepository = relationshipRepository;
        this.repositorySupport = repositorySupport;
    }

    @Override
    @Transactional
    public String addFriend(Relationship relationship) {
        log.info("Service | username = {} friendname = {}", relationship.getUserName(), relationship.getFriendName());
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
        List<RelationshipEntity> result = repositorySupport.findAllByUserName(userName);
        List<String> fList = new ArrayList<>();

        for (RelationshipEntity r : result) {
            if(r.getStatus() == 1){
                fList.add(r.getFriendName());
            }
        }
        return fList;
    }

    /**
     * 조회 후 save 필요
     * @param relationship
     * @return
     */
    @Transactional
    @Modifying(clearAutomatically = true)   //캐시 Clear
    @Override
    public Optional<RelationshipEntity> breakRelationship(Relationship relationship) {
        Optional<RelationshipEntity> result = relationshipRepository.findByUserName(relationship.getUserName());
        result.get().setStatus(0);
        return result;
    }
}
