package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Service;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.Game;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.Player;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository.GameRepository;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    //Metode el jugador tira els daus i es guarda la tirada
    public Game jugadorTiraDaus (int idJugador){
        Optional<Player> player = playerRepository.findById(idJugador);

        //Comprovem que el jugador existeix
        if(player.isPresent()){
            Player player1 = player.get();
            Game game = new Game (player1);
            //guardem la jugada
            player1.addTirada(game);
            gameRepository.save(game);
            return game;
        }
        return null;
    }

    //Metode que visualitza totes les jugades del jugador
    public List<Game> getGameByPlayer (int idPlayer){
        return null;
    }
    //Metode eliminar la llista de jugades del jugador
    public Player deleteGameJugador(int idPlayer){
        Optional <Player> optionalPlayer = playerRepository.findById(idPlayer);

        if(optionalPlayer.isPresent()){
            Player player = optionalPlayer.get();
            gameRepository.deleteAll(player.getMevesPartides());
            player.getMevesPartides().clear();
            return player;
        }
        return null;
    }


}
