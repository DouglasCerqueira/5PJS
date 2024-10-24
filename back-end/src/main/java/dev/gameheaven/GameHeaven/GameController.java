package dev.gameheaven.GameHeaven;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jogos")

public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return new ResponseEntity<List<Game>>(gameService.allGames(),HttpStatus.OK);
    }

    @GetMapping("/{gameID}")
    public ResponseEntity<Optional<Game>> getSingleGame(@PathVariable String gameID) {
        return new ResponseEntity<Optional<Game>>(gameService.singleGame(gameID), HttpStatus.OK);
    }
}
