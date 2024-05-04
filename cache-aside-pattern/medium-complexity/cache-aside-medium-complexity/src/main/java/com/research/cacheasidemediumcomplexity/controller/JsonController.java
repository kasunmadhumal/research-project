package com.research.cacheasidemediumcomplexity.controller;

import com.research.cacheasidemediumcomplexity.entity.JsonObjectTransactionEntity;
import com.research.cacheasidemediumcomplexity.service.JsonObjectService;
import com.research.cacheasidemediumcomplexity.service.RedisService;
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

    @Autowired
    private RedisService redisService;

    @GetMapping("/get-selected-object/{id}")
    public Optional<JsonObjectTransactionEntity> getSelectedJsonObject(@PathVariable String id) {
        return jsonObjectService.getSelectedJsonObject(Long.parseLong(id));
    }

    @GetMapping("/get-all-objects")
    public List<JsonObjectTransactionEntity> getAllObjects(){
        return jsonObjectService.getAllObjects();
    }

    @GetMapping("clear-cache")
    public void clearCache() {
        redisService.clearCache();
    }




}
