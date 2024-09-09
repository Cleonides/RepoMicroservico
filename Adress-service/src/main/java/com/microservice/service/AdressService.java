package com.microservice.service;

import com.microservice.model.Adress;

public class AdressService {

    public Adress getAdressById(Long id) {
        return new Adress(id, "Travessa olva", "Rua joabi", 25);
    }
}
