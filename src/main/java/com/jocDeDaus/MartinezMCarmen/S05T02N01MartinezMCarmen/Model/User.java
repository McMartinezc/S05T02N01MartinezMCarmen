package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

//Amb lombok creem setters i getters
@Getter
@Setter

@Entity
@Table(name="jugador")
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int idJugador;
  @Column(name="nom_jugador")
  private String nomJugador;
  private String email;
  private String password;
  @Column(name="data_registre")
  private LocalDate data_registre;

  private List<Tirada> mevesPartides;

  //Constructor
  public User() {
    this.nomJugador="Anònim";
  }

  public User(String nomJugador, String email, String password) {
    this.nomJugador = nomJugador;
    this.email = email;
    this.password = password;
  }

  //Metode que guarda la tirada
  public void addTirada(Tirada tirada) {
    if (mevesPartides == null) {
      mevesPartides = new ArrayList<Tirada>();
    }
    mevesPartides.add(tirada);
    tirada.setUser(this);
  }








}
