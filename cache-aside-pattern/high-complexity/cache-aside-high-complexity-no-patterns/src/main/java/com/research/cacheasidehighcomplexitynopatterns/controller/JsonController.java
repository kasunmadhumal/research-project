package com.research.cacheasidehighcomplexitynopatterns.controller;



import com.research.cacheasidehighcomplexitynopatterns.entity.JsonObjectTransactionEntity;
import com.research.cacheasidehighcomplexitynopatterns.service.JsonObjectService;
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


}
