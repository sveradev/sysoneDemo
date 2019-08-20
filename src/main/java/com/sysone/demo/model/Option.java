package com.sysone.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CAR_OPTION")
public class Option {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private String description;
    private int price;

    public Option(String name,
                  String description,
                  int price){
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
