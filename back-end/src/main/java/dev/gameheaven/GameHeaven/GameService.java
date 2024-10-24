package dev.gameheaven.GameHeaven;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> allGames(){
        return gameRepository.findAll();
    }

    public Optional<Game> singleGame(String gameID){
        return gameRepository.findGameByGameID(gameID);
    }
}
