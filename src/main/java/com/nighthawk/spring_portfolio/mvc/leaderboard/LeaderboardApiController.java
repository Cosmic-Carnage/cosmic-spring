package com.nighthawk.spring_portfolio.mvc.leaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/leaderboard")  // all requests in file begin with this URI
public class LeaderboardApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private LeaderboardJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Leaderboard>> getLeaderboard() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    /* Update Like
     * @PutMapping annotation is used for mapping HTTP PUT requests onto specific handler methods.
     * @PathVariable annotation extracts the templated part {id}, from the URI
     */
    @PostMapping("/like/{id}")
    public ResponseEntity<Leaderboard> setLike(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<Leaderboard> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Leaderboard leaderboard = optional.get();  // value from findByID
            leaderboard.setLike(leaderboard.getLike()+1); // increment value
            repository.save(leaderboard);  // save entity
            return new ResponseEntity<>(leaderboard, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }

    /* Update Jeer
     */
    @PostMapping("/jeer/{id}")
    public ResponseEntity<Leaderboard> setJeer(@PathVariable long id) {
        Optional<Leaderboard> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Leaderboard leaderboard = optional.get();
            leaderboard.setDislike(leaderboard.getDislike()+1);
            repository.save(leaderboard);
            return new ResponseEntity<>(leaderboard, HttpStatus.OK);
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Leaderboard> deleteLeaderboard(@PathVariable long id) {
        Optional<Leaderboard> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Leaderboard leaderboard = optional.get();  // value from findByID
            repository.deleteById(id);  // value from findByID
            return new ResponseEntity<>(leaderboard, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
    }
}