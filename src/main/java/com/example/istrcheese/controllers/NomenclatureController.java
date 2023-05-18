package com.example.istrcheese.controllers;

import com.example.istrcheese.execeptions.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("nomenclature")
public class NomenclatureController {

    private final List<Map<String, String>> nomenclatures = new ArrayList<>();

    @GetMapping
    public List<Map<String, String>> getNomenclatures(){
        return nomenclatures;
    }

    @GetMapping("{id}")
    public Map<String, String> getNomenclatureById(@PathVariable String id){
        return nomenclatures.stream()
                .filter(nomenclatures -> nomenclatures.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

}
