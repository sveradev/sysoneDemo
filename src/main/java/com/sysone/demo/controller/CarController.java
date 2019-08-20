package com.sysone.demo.controller;

import com.sysone.demo.exceptions.CarNotFoundException;
import com.sysone.demo.exceptions.OptionNotFoundException;
import com.sysone.demo.model.Car;
import com.sysone.demo.model.Option;
import com.sysone.demo.repository.CarRepository;
import com.sysone.demo.repository.OptionRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class CarController {

    private final CarRepository carRepository;
    private final OptionRepository optionRepository;

    CarController(CarRepository carRepository, OptionRepository optionRepository){
        this.carRepository = carRepository;
        this.optionRepository = optionRepository;
    }

    @GetMapping("/cars")
    List<Car> all() {
        return carRepository.findAll();
    }

    @PostMapping("/cars")
    Car newCar(@RequestBody Car car) {
        Car newCar = new Car(car.getName(),car.getBasePrice());
        newCar.setOptions(car.getOptions());
        return carRepository.save(newCar);
    }

    @GetMapping("/cars/{id}")
    Car one(@PathVariable Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    @PutMapping("/cars/{id}")
    Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {
        return carRepository.findById(id)
                .map(car -> {
                    car.setName(newCar.getName());
                    car.setBasePrice(newCar.getBasePrice());
                    car.setOptions(newCar.getOptions());
                    return carRepository.save(car);
                })
                .orElseGet(() -> {
                    newCar.setId(id);
                    return carRepository.save(newCar);
                });
    }

    @PostMapping("cars/{id}/options/{optionId}")
    Car addOption(@PathVariable Long id, @PathVariable Long optionId) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
        Option newOption = optionRepository.findById(optionId)
                .orElseThrow(() -> new OptionNotFoundException(optionId));
        car.addOption(newOption);
        return carRepository.save(car);
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }
}

