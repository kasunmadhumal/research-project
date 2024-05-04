package com.research.cacheasidehighcomplexity.controller;


import com.research.cacheasidehighcomplexity.entity.JsonObjectTransactionEntity;
import com.research.cacheasidehighcomplexity.service.JsonObjectService;
import com.research.cacheasidehighcomplexity.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update/{id}")
    public String updateObject(@PathVariable String id, @RequestBody JsonObjectTransactionEntity jsonObjectTransactionEntity) {
        jsonObjectService.updateObject(Long.parseLong(id), jsonObjectTransactionEntity);
        return "successfully updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteObject(@PathVariable String id) {
        jsonObjectService.deleteObject(Long.parseLong(id));
        return "successfully deleted";
    }

    @GetMapping("clear-cache")
    public void clearCache() {
        redisService.clearCache();
    }




}
