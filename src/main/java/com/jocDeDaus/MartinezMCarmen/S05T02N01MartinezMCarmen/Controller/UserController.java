package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Controller;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.DTO.UserDTO;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class UserController {

    @Autowired
    private UserService userServiceImplements;

    //GetAll players
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllPlayers(){
        return ResponseEntity.ok().body(userServiceImplements.getAllPlayers());
    }

    //Get getOne player by id
    @GetMapping("/getOne/{id}")
    public ResponseEntity<UserDTO> getOnePlayer(@PathVariable("idPlayer") int idPlayer) {
        return null;
    }

    //Post crear un jugador
    @PostMapping("/add")
    public ResponseEntity<UserDTO> addPlayer(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userServiceImplements.addPlayer(userDTO), HttpStatus.CREATED);
    }

    //Put modificar jugador
    public ResponseEntity<UserDTO> updatePlayer(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userServiceImplements.updatePlayer(userDTO), HttpStatus.CREATED);
    }


}
