package com.bridge.Relationship.Controller;

import com.bridge.Relationship.Data.Relationship;
import com.bridge.Relationship.Service.RelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@ResponseBody
@RestController("/relationship")
public class RelationshipController {

    private final RelationshipService relationshipService;

    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping("/addFriend")
    public String addFriend(@RequestBody Relationship relationship){
        return relationshipService.addFriend(relationship);
    }

    public String getFriends(@RequestBody Relationship relationship){

        List<String> fList = relationshipService.getFriends(relationship.getUserName());
        return "";
    }
}
