package com.bridge.Relationship.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "relationship")
public class RelationshipEntity {
    @Id
    private String userName;

    @Column(nullable = false, length = 100)
    private String friendName;

    @Column(nullable = false)
    private int status;
}
