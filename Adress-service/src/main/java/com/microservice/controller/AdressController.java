package com.microservice.controller;
import com.microservice.model.Adress;
import com.microservice.service.AdressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdressController {

    private final AdressService adressService;

    public AdressController(AdressService adressService){
        this.adressService = adressService;
    }

    @GetMapping("/adresses/{id}")
    public Adress getAdressById(@PathVariable Long id){
        //Simulação de uma busca de banco de dados
        return adressService.getAdressById(id);
    }
}