package com.research.cacheasidemediumcomplexitynopatterns.controller;


import com.research.cacheasidemediumcomplexitynopatterns.entity.JsonObjectTransactionEntity;
import com.research.cacheasidemediumcomplexitynopatterns.service.JsonObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@Controller
@RestController
@RequestMapping("/json")
public class JsonController {

    @Autowired
    private JsonObjectService jsonObjectService;

    @GetMapping("/get-selected-object/{id}")
    public Optional<JsonObjectTransactionEntity> getSelectedJsonObject(@PathVariable String id) {
        return jsonObjectService.getSelectedJsonObject(Long.parseLong(id));
    }

    @GetMapping("/get-all-objects")
    public List<JsonObjectTransactionEntity> getAllObjects(){
        return jsonObjectService.getAllObjects();
    }



}
