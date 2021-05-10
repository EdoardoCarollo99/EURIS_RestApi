package it.euris.restapi.controller;

import it.euris.restapi.dao.IDaoCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class controllerCalculator {

    @Autowired
    IDaoCalculator dao;

    @GetMapping("/{operation}")
    public String operation(@PathVariable String operation){

        if(operation.contains("+")){
            return dao.sum(operation);
        }
        if(operation.contains("-")){
            return dao.subtraction(operation);
        }
        if(operation.contains("*")){
            return dao.multiplication(operation);
        }
        return "Operazione inesistente";
    }

    @GetMapping("/{dividend}/{numberDivider}")
    public String operation(@PathVariable String dividend, @PathVariable String numberDivider){

        return dao.division(dividend,numberDivider);
    }


}
