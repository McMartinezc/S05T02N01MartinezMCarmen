package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Repository;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Model.Tirada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiradaRepository extends JpaRepository <Tirada, Integer> {
}
