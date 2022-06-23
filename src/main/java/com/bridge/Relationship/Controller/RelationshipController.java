package com.bridge.Relationship.Controller;

import com.bridge.Relationship.Data.Relationship;
import com.bridge.Relationship.Service.RelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@ResponseBody
@RestController
@RequestMapping("/relationship")
public class RelationshipController {

    private final RelationshipService relationshipService;

    @Autowired
    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping("/add")
    public String addFriend(@RequestBody Relationship relationship){
        log.info("Controller | username = {} friendname = {}", relationship.getUserName(), relationship.getFriendName());
        return relationshipService.addFriend(relationship);
    }

    @PostMapping("/delete")
    public String deleteFriend(@RequestBody Relationship relationship){
        log.info("Controller | username = {} friendname = {}", relationship.getUserName(), relationship.getFriendName());
        return relationshipService.breakRelationship(relationship).toString();
    }

    @PostMapping("/friendlist")
    public String getFriends(@RequestBody Relationship relationship){

        List<String> fList = relationshipService.getFriends(relationship.getUserName());
        return fList.toString();
    }
}
