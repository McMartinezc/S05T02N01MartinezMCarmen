package com.jocDeDaus.MartinezMCarmen.S05T02N01MartinezMCarmen.Service;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class Utils {

    //Utilitzem modelmapper per poder mapejar per convertir d'identitat a dto, o al contrari
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
