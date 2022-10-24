package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Controller;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.DTO.PlayerDTO;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.Player;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Service.PlayerServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class GameController {

    @Autowired
    private PlayerServiceImplements playerServiceImplements;

    //GetAll players
    @GetMapping("/getAll")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(){
        return ResponseEntity.ok().body(playerServiceImplements.getAllPlayers());
    }

    //Get getOne player by id
    @GetMapping("/getOne/{id}")
    public ResponseEntity<PlayerDTO> getOnePlayer(@PathVariable("idPlayer") int idPlayer) {
        return null;
    }

    //Post crear un jugador
    @PostMapping("/add")
    public ResponseEntity<PlayerDTO> addPlayer(@RequestBody PlayerDTO playerDTO){
        return new ResponseEntity<>(playerServiceImplements.addPlayer(playerDTO), HttpStatus.CREATED);
    }

    //Put modificar jugador
    public ResponseEntity<PlayerDTO> updatePlayer(@RequestBody PlayerDTO playerDTO){
        return new ResponseEntity<>(playerServiceImplements.updatePlayer(playerDTO), HttpStatus.CREATED);
    }


}
