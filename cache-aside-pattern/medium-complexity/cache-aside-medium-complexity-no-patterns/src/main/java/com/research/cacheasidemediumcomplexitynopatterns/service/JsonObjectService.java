package com.research.cacheasidemediumcomplexitynopatterns.service;

import com.research.cacheasidemediumcomplexitynopatterns.entity.JsonObjectTransactionEntity;
import com.research.cacheasidemediumcomplexitynopatterns.repository.JsonObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JsonObjectService {

    @Autowired
    private JsonObjectRepository jsonObjectRepository;


    public Optional<JsonObjectTransactionEntity> getSelectedJsonObject(Long id) {

        Optional<JsonObjectTransactionEntity> selectedJsonObject = jsonObjectRepository.findById(id);

        return selectedJsonObject;

    }

    public List<JsonObjectTransactionEntity> getAllObjects(){
        return jsonObjectRepository.findAll();
    }
}
