package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_cliente")
    private int id_cliente;

    @Column(name = "id_product")
    private int id_product;

    @Column(name = "description")
    private String description;

    @Column(name = "dt_start")
    private LocalDate dtStart;

    @Column(name = "dt_end")
    private LocalDate dtEnd;

    @Column(name = "price_buy")
    private double priceBuy;

    @Column(name = "payment")
    private String payment;
}
