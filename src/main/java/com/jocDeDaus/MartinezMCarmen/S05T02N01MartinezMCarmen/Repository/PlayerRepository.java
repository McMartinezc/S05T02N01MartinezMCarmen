package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
