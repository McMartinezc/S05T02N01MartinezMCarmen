package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository <Game, Integer> {
}
