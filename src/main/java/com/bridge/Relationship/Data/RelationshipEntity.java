package com.bridge.Relationship.Data;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "relationship")
public class RelationshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userName;

    @Column(nullable = false, length = 100)
    private String friendName;

    @Column(nullable = false)
    private int status;
}
