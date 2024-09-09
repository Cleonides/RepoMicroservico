package com.microservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdressDto {
    private Integer id;
    private String adress;
    private String street;
    private int number;
}
