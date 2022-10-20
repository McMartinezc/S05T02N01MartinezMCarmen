package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

//Getters i setters amb lombok
@Getter
@Setter

public class PlayerDTO implements Serializable {

    private int idJugador;
    private String nomJugador;
    private LocalDate data_registre;

}
