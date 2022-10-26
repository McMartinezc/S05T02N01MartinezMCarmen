package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
@Getter
@Setter

public class TiradaDTO implements Serializable {

    private int idGame;
    private int dau1;
    private int dau2;
    private boolean guanya;


}
