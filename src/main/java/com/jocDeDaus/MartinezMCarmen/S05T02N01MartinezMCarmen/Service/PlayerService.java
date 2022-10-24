package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Service;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.DTO.PlayerDTO;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.Player;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository.GameRepository;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PlayerService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ModelMapper modelMapper;

    //Mostra tots els jugadors
    public List<PlayerDTO> getAllPlayers() {
        //Ordenem la llista de jugadors per nom. Les mapejem d'entitat a dto per visualitzar-la
        return playerRepository.findAll(Sort.Order.by("nomPlayer").withProperties())
                .stream().map(this::convertEntitatADto).collect(Collectors.toList());
    }
    //Mostra un jugador
    public PlayerDTO getOneById(int idPlayer) {
        Optional<Player> player = playerRepository.findById(idPlayer);
        //Convertim entitat a dto per retornar al usuari
        PlayerDTO playerDTO = convertEntitatADto(player.get());
        return playerDTO;
    }


    public PlayerDTO addPlayer(PlayerDTO playerDTO) {
        if(playerDTO.getNomJugador() == null "".equalsIgnoreCase(playerDTO.getNomJugador())){
            playerDTO.setNomJugador("Anonim");
        }
        if(playerDTO.getNomJugador().equalsIgnoreCase())
        return null;
    }


    //Modificar jugador
    public PlayerDTO updatePlayer(PlayerDTO playerDTO) {

        return null;
    }

    //Convertim DTO a entitat utilitzan el ModelMapper
    public Player convertDTOAEntitat (PlayerDTO playerDTO){
        return modelMapper.map(playerDTO, Player.class);
    }

    //Convertim entitat a DTO utilitzan el ModelMapper
    public PlayerDTO convertEntitatADto (Player player){
        return modelMapper.map(player, PlayerDTO.class);
    }
}
