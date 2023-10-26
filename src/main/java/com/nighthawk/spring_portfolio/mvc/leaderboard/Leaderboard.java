package com.nighthawk.spring_portfolio.mvc.leaderboard;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String leaderboard;

    private int score;

    // starting scores
    public static HashMap<String, Integer> init() {
        HashMap<String, Integer> leaderboardHash = new HashMap<>();
        {
            leaderboardHash.put("Player1", 1000);
            leaderboardHash.put("Player2", 800);
            leaderboardHash.put("Player3", 1200);
            leaderboardHash.put("Player4", 4000);
            leaderboardHash.put("Player5", 670);
            leaderboardHash.put("Player6", 320);
            leaderboardHash.put("Player7", 570);
            leaderboardHash.put("Player8", 129);
            leaderboardHash.put("Player9", 250);
            leaderboardHash.put("Player10", 875);
        }
        return leaderboardHash;
    }
}
