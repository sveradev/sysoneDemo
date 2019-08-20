package com.sysone.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Car {

    private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private int basePrice;
    @ElementCollection
    private List<Option> options = new ArrayList<>();

    public Car(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public int getTotalPrice(){
        int totalPrice = this.basePrice;
        for (Option option : options){
            totalPrice += option.getPrice();
        }
        return totalPrice;
    }

    public void addOption(Option option){
        this.options.add(option);
    }
}
