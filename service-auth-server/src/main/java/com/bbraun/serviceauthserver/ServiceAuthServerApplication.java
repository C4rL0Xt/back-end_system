package com.bbraun.serviceauthserver;

import com.bbraun.serviceauthserver.models.entity.Rol;
import com.bbraun.serviceauthserver.models.entity.RolName;
import com.bbraun.serviceauthserver.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceAuthServerApplication{


    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthServerApplication.class, args);
    }


}
