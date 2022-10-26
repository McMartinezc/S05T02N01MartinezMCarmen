package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Controller;

import com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Service.TiradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TiradaController {

    @Autowired
    private TiradaService tiradaService;


}
