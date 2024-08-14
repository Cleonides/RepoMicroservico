package com.example.demo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/")
public class HomeResource {

    @GetMapping
    public String getHello(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        StringBuffer string_format = new StringBuffer();
        string_format.append("### Servidor no ar, horário :");
        string_format.append(dtf.format(now));
        string_format.append("###");
        System.out.println(string_format);
        return string_format.toString();
    }
}
