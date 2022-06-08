package com.meupetzinho.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeansCofigs {

    @Bean
    public PropertiesUtils propertiesUtils(){
        return new PropertiesUtils();
    }


}
