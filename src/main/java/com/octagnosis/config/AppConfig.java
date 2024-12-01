package com.octagnosis.config;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.TimeZone;

@Configuration
public class AppConfig {

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
