package com.research.cacheasidemediumcomplexity.service;

import com.research.cacheasidemediumcomplexity.entity.JsonObjectTransactionEntity;
import com.research.cacheasidemediumcomplexity.repository.JsonObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JsonObjectService {

    @Autowired
    private JsonObjectRepository jsonObjectRepository;


    @Cacheable(value = "AllJsonObjects", key = "#id")
    public Optional<JsonObjectTransactionEntity> getSelectedJsonObject(Long id) {

        Optional<JsonObjectTransactionEntity> selectedJsonObject = jsonObjectRepository.findById(id);

        return selectedJsonObject;

    }

    @Cacheable(value = "AllJsonObjects")
    public List<JsonObjectTransactionEntity> getAllObjects(){
        return jsonObjectRepository.findAll();
    }
}
