package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

//Amb lombok creem setters i getters
@Getter
@Setter

@Entity
@Table(name="jugador")
public class Player {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int idJugador;
  @Column(name="nom_jugador")
  private String nomJugador;
  private String email;
  private String password;
  @Column(name="data_registre")
  private LocalDate data_registre;

  private List<Game> mevesPartides;

  //Constructor
  public Player() {
    this.nomJugador="Anònim";
  }

  public Player(String nomJugador, String email, String password) {
    this.nomJugador = nomJugador;
    this.email = email;
    this.password = password;
  }
  //Metode que guarda la tirada
  public void addTirada(Game tirada) {
    if (mevesPartides == null) {
      mevesPartides = new ArrayList<Game>();
    }
    mevesPartides.add(tirada);
    tirada.setPlayer(this);
  }

  //Calcula el percentatge d'exit del jugador
  public double calculaPercentatgeExitPlayer(){
    double percentatgeExit=0;
    if(mevesPartides != null && mevesPartides.size()>0){
      int gameListSize = mevesPartides.size();
      int totalGuanyat = 0;
      for(Game tirada : mevesPartides){
        if(tirada.isGuanya()){
          totalGuanyat++;
        }
      }
      percentatgeExit =(totalGuanyat *100 )/ gameListSize;
    }
    return percentatgeExit;
  }






}
