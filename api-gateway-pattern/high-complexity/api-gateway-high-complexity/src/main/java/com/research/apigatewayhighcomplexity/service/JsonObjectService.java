package com.research.apigatewayhighcomplexity.service;

import com.research.apigatewayhighcomplexity.entity.JsonObjectTransactionEntity;
import com.research.apigatewayhighcomplexity.repository.JsonObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public JsonObjectTransactionEntity updateObject(Long id, JsonObjectTransactionEntity jsonObjectTransactionEntity) {
        Optional<JsonObjectTransactionEntity> selectedJsonObject = jsonObjectRepository.findById(id);
        if(selectedJsonObject.isPresent()) {
            JsonObjectTransactionEntity jsonObjectTransactionEntity1 = selectedJsonObject.get();
            jsonObjectTransactionEntity1.setId(jsonObjectTransactionEntity.getId());
            jsonObjectTransactionEntity1.setName(jsonObjectTransactionEntity.getName());
            jsonObjectTransactionEntity1.setAge(jsonObjectTransactionEntity.getAge());
            jsonObjectTransactionEntity1.setAddress(jsonObjectTransactionEntity.getAddress());
            jsonObjectTransactionEntity1.setEmail(jsonObjectTransactionEntity.getEmail());
            jsonObjectTransactionEntity1.setPhone(jsonObjectTransactionEntity.getPhone());
            jsonObjectTransactionEntity1.setSchool(jsonObjectTransactionEntity.getSchool());
            jsonObjectTransactionEntity1.setCompany(jsonObjectTransactionEntity.getCompany());
            jsonObjectTransactionEntity1.setUniversity(jsonObjectTransactionEntity.getUniversity());
            jsonObjectTransactionEntity1.setCollege(jsonObjectTransactionEntity.getCollege());
            jsonObjectTransactionEntity1.setDepartment(jsonObjectTransactionEntity.getDepartment());
            jsonObjectTransactionEntity1.setDesignation(jsonObjectTransactionEntity.getDesignation());
            jsonObjectTransactionEntity1.setCarType(jsonObjectTransactionEntity.getCarType());
            jsonObjectTransactionEntity1.setCarModel(jsonObjectTransactionEntity.getCarModel());
            jsonObjectTransactionEntity1.setCarColor(jsonObjectTransactionEntity.getCarColor());
            jsonObjectTransactionEntity1.setCarNumber(jsonObjectTransactionEntity.getCarNumber());
            jsonObjectTransactionEntity1.setBikeType(jsonObjectTransactionEntity.getBikeType());
            jsonObjectTransactionEntity1.setBikeModel(jsonObjectTransactionEntity.getBikeModel());
            jsonObjectTransactionEntity1.setBikeColor(jsonObjectTransactionEntity.getBikeColor());
            jsonObjectTransactionEntity1.setBikeNumber(jsonObjectTransactionEntity.getBikeNumber());
            jsonObjectTransactionEntity1.setBusType(jsonObjectTransactionEntity.getBusType());
            jsonObjectRepository.saveAndFlush(jsonObjectTransactionEntity1);
            return jsonObjectTransactionEntity1;
        }
        return null;
    }

    public void deleteObject(Long id) {
        Optional<JsonObjectTransactionEntity> selectedJsonObject = jsonObjectRepository.findById(id);
        if(selectedJsonObject.isPresent()) {
            jsonObjectRepository.deleteById(id);
        }
    }
}
