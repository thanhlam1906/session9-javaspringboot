package com.example.session9.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dhgzezjrv");
        config.put("api_key", "828683121961679");
        config.put("api_secret", "PtXRy5QHUMSYikI2uR3mETJYSkk");
        return new Cloudinary(config);
    }
}
