package com.nighthawk.spring_portfolio.mvc.spacebook;

import java.util.HashMap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Spacebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String spacebook;

    private int score;

    // starting scores
    public static HashMap<String, Integer> init() {
        HashMap<String, Integer> spacebookHash = new HashMap<>();
        {
            spacebookHash.put("Player1", 1000);
            spacebookHash.put("Player2", 800);
            spacebookHash.put("Player3", 1200);
            spacebookHash.put("Player4", 4000);
            spacebookHash.put("Player5", 670);
            spacebookHash.put("Player6", 320);
            spacebookHash.put("Player7", 570);
            spacebookHash.put("Player8", 129);
            spacebookHash.put("Player9", 250);
            spacebookHash.put("Player10", 875);
        }
        return spacebookHash;
    }
}
