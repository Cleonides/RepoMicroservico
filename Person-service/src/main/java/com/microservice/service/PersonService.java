package com.microservice.service;

import com.microservice.controller.PersonController;
import com.microservice.dto.AdressDto;
import com.microservice.dto.PersonDto;
import com.microservice.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {

    @Value("${address.service.url}")
    private String addressServiceUrl;

    private final RestTemplate restTemplate;

    public PersonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PersonDto getPersonWithAdress(Long id) {
        // Simulação de uma pessoa buscada no banco de dados
        Person person = new Person(id, "Joao", "08104215447", "cleondies@gmail.com" , "819887458", 30, 1L);

        // Fazendo uma chamada para o Address Service
        String addresServiceUrl = addressServiceUrl + "/addresses/" + person.getAdressId();
        AdressDto adress = restTemplate.getForObject(addresServiceUrl, AdressDto.class);

        //criar um converter
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setCpf(person.getCpf());
        personDto.setEmail(person.getEmail());
        personDto.setFone(person.getFone());
        personDto.setAge(person.getAge());
        personDto.setAdressDto(adress);
         // Incluindo os dados do endereço na resposta, se necessário
        // (poderia ser uma customização, como criar um PersonDTO)
        return personDto;
    }
}
