package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//https://attacomsian.com/blog/spring-data-jpa-many-to-many-mapping

//Getters i setters amb lombok
@Setter
@Getter

@Entity
@Table(name="tirades")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGame;

    @Column(name="Valor_dau1")
    private int dau1;
    @Column(name="Valor_dau2")
    private int dau2;
    @Column(name="Guanyada")
    private boolean guanya;

    @ManyToOne
    @JoinColumn(name = "player_id_jugador")
    private Player player;

    //Constructors
    public Game() {
    }
    public Game(int idGame, int dau1, int dau2, boolean guanya, Player player) {
        this.idGame = idGame;
        this.dau1 = dau1;
        this.dau2 = dau2;
        this.guanya = guanya;
        this.player = player;
    }

    public Game (Player player) {
        this.dau1 = generarTirada();
        this.dau2 = generarTirada();
        this.guanya = resultatTirada();
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    //Valor random del dau
    public int generarTirada(){
        int random = (int) Math.floor(Math.random()*6);
        return random;
    }

    //Metode que comprova el resultat sigui 7 guanya
    public boolean resultatTirada(){
        boolean resultat;

        if(this.dau1 + this.dau2 == 7){
            resultat = true;
        }else{
            resultat = false;
        }
        return resultat;
    }

    @Override
    public String toString() {
        return "Game{" +
                "idGame=" + idGame +
                ", dau1=" + dau1 +
                ", dau2=" + dau2 +
                ", guanya=" + guanya +
                ", player=" + player +
                '}';
    }
}
