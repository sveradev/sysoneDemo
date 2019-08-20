package com.sysone.demo.controller;

import com.sysone.demo.model.Option;
import com.sysone.demo.exceptions.OptionNotFoundException;
import com.sysone.demo.repository.CarRepository;
import com.sysone.demo.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class OptionController {

    private final CarRepository carRepository;
    private final OptionRepository optionRepository;

    OptionController(CarRepository carRepository, OptionRepository optionRepository) {
        this.carRepository = carRepository;
        this.optionRepository = optionRepository;
    }


    @GetMapping("/options")
    List<Option> all() {
        return optionRepository.findAll();
    }

    @PostMapping("/options")
    Option newOption(@RequestBody Option newOption) {
        return optionRepository.save(newOption);
    }

    @GetMapping("/options/{optionId}")
    Option one(@PathVariable Long optionId) {
        return optionRepository.findById(optionId)
                .orElseThrow(() -> new OptionNotFoundException(optionId));
    }

    @PutMapping("/options/{id}")
    Option replaceOption(@RequestBody Option newOption, @PathVariable Long id) {

        return optionRepository.findById(id)
                .map(option -> {
                    option.setName(newOption.getName());
                    option.setDescription(newOption.getDescription());
                    option.setPrice(newOption.getPrice());
                    return optionRepository.save(option);
                })
                .orElseGet(() -> {
                    newOption.setId(id);
                    return optionRepository.save(newOption);
                });
    }

    @DeleteMapping("/options/{id}")
    void deleteOption(@PathVariable Long id) {
        optionRepository.deleteById(id);
    }
}

