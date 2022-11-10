package com.finalproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("studentMapper")
    public ModelMapper studentMapper(){


        return new ModelMapper();
    }

    @Bean("courseMapper")
    public ModelMapper courseMapper(){


        return new ModelMapper();
    }

    @Bean("registrationMapper")
    public ModelMapper registrationMapper(){


        return new ModelMapper();
    }

}
