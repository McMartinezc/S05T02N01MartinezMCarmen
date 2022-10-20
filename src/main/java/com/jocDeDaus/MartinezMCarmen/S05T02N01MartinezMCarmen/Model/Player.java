package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
  @Column(name="data_registre")
  private LocalDate data_registre;

  private List<Game> mevesPartides;

  //Constructor
  public Player() {
    this.nomJugador="Anònim";
  }

  public Player(int idJugador, String nomJugador, LocalDate data_registre) {
    this.idJugador = idJugador;
    this.nomJugador = nomJugador;
    this.data_registre = data_registre;
  }

  //Jugador pot visualitzar totes les tirades

  //Percentatge d'èxit de totes les tirades

  //Eliminar tot el llistat de tirades

  //Percentatge total de tots els jugadors


}
