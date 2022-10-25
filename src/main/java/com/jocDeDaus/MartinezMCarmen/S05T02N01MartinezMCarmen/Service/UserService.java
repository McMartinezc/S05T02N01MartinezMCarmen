package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Service;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.DTO.UserDTO;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Exception.AlreadyExist;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Exception.IdNotFound;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.Tirada;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.User;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository.TiradaRepository;
import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private TiradaRepository tiradaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    //METODES CRUD

    //Mostra tots els jugadors
    public List<UserDTO> getAllPlayers() {
           return userRepository.findAll()
                   .stream()
                   .map(this::convertEntitatADto)//Convertim entitat a dto
                   .collect(Collectors.toList());
    }

    //Mostra un jugador
    public UserDTO getOneById(int idPlayer) {
        Optional<User> player = userRepository.findById(idPlayer);
        //Convertim entitat a dto per retornar al usuari
        UserDTO userDTO = convertEntitatADto(player.get());
        return userDTO;
    }


    //Crear jugador
    public UserDTO addPlayer(UserDTO userDTO) {

        //Convertim dto a entitat
        User user = convertDTOAEntitat(userDTO);
        //Verifiquem condiciones si el nom és null o és buit guardem com anonim
        if(userDTO.getNomJugador()== null || "".equals(userDTO.getNomJugador())){
            user.setNomJugador("Anonim");
        }
        //Verifiquem que nom no existeixi a al base de dades
        if(userRepository.userByNomJugador(userDTO.getNomJugador())){
            throw new AlreadyExist("Aquest nom "+userDTO.getNomJugador() +" ja existeix.");
        }
        userRepository.save(user);
        //Convertirm entitat a dto per enviar al usuari
        return convertEntitatADto(user);
    }

    //Modificar jugador
    public UserDTO updatePlayer(UserDTO userDTO) {
        //Convertim dto a entitat
        User user = convertDTOAEntitat(userDTO);
        //Verifiquem que existeix el nom del jugador
        if(!userRepository.userByNomJugador(userDTO.getNomJugador())){
            throw new AlreadyExist("Aquest usuari no existeix");
        }
        //Si existeix, modifiquem el nom del jugador i ho gardem al repository i convertim a dto per mostrar al usuari
        user.setNomJugador(userDTO.getNomJugador());
        return convertEntitatADto(userRepository.save(user));
    }


    //Calcula el percentatge d'exit del jugador
    public double calculaPercentatgeExitPlayer(User user){

        double percentatgeExit=0;

        if(user.getMevesPartides() != null && user.getMevesPartides().size() > 0){
            int gameListSize = user.getMevesPartides().size();
            int totalGuanyat = 0;
            for(Tirada tirada : user.getMevesPartides()){
                if(tirada.isGuanya()){
                    totalGuanyat++;
                }
            }
            percentatgeExit =(totalGuanyat *100 )/ gameListSize;
        }
        return percentatgeExit;
    }



    //Convertim DTO a entitat utilitzan el ModelMapper
    public User convertDTOAEntitat (UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }

    //Convertim entitat a DTO utilitzan el ModelMapper
    public UserDTO convertEntitatADto (User user){
        return modelMapper.map(user, UserDTO.class);
    }
}
