package com.bridge.Relationship.Data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class Relationship {
    private String userName;
    private String friendName;
    private int status;
}
