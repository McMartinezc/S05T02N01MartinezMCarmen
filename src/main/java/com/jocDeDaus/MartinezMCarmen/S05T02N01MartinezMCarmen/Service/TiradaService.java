package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Service;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.Tirada;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.User;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository.TiradaRepository;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiradaService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TiradaRepository tiradaRepository;

    //Metode el jugador tira els daus i es guarda la tirada
    public Tirada jugadorTiraDaus (int idJugador){

        Optional<User> player = userRepository.findById(idJugador);

        //Comprovem que el jugador existeix
        if(player.isPresent()){
            User user1 = player.get();
            Tirada tirada = new Tirada(user1);
            //guardem la jugada
            user1.addTirada(tirada);
            tiradaRepository.save(tirada);
            return tirada;
        }
        return null;
    }

    //Metode que visualitza totes les jugades del jugador
    public List<Tirada> getTiradaByPlayer (int idPlayer){
        return tiradaRepository.findAllById(idPlayer);
    }


    //Metode eliminar la llista de jugades del jugador
    public User deleteTiradesJugador(int idPlayer){
        Optional <User> optionalPlayer = userRepository.findById(idPlayer);

        if(optionalPlayer.isPresent()){
            User user = optionalPlayer.get();
            tiradaRepository.deleteAll(user.getMevesPartides());
            user.getMevesPartides().clear();
            return user;
        }
        return null;
    }


}
