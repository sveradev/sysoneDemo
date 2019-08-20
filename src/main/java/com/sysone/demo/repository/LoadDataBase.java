package com.sysone.demo.repository;

import com.sysone.demo.model.Car;
import com.sysone.demo.model.Option;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CarRepository repository, OptionRepository optionRepository) {
        return args -> {
            log.info("Preloading " + optionRepository.save(new Option("TC","Techo corredizo",12000)));
            log.info("Preloading " + optionRepository.save(new Option("AA","Aire acondicionado",20000)));
            log.info("Preloading " + optionRepository.save(new Option("ABS","Sistemas de frenos ABS",14000)));
            log.info("Preloading " + optionRepository.save(new Option("AB","Airbag",7000)));
            log.info("Preloading " + optionRepository.save(new Option("LL","Llantas de aleación",12000)));
            log.info("Preloading " + repository.save(new Car("Sedán",230000)));
            log.info("Preloading " + repository.save(new Car("Familiar",245000)));
            log.info("Preloading " + repository.save(new Car("Coupe",270000)));
        };
    }
}