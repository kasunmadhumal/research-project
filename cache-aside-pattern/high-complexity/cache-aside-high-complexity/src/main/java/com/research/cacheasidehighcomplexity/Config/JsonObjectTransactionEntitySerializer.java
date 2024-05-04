package com.research.cacheasidehighcomplexity.Config;

import com.research.cacheasidehighcomplexity.entity.JsonObjectTransactionEntity;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class JsonObjectTransactionEntitySerializer implements RedisSerializer<
        JsonObjectTransactionEntity> {

    @Override
    public byte[] serialize(JsonObjectTransactionEntity entity) {
        if (entity == null) {
            return null;
        }
        String data = entity.toString();
        return data.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public JsonObjectTransactionEntity deserialize(byte[] bytes) {

        if (bytes == null) {
            return null;
        }

        String data = new String(bytes, StandardCharsets.UTF_8);
        String[] fields = data.split(",");
        Long id = Long.parseLong(fields[0]);
        String name = fields[1];
        String age = fields[2];
        String address = fields[3];
        String email = fields[4];
        String phone = fields[5];
        String school = fields[6];
        String company = fields[7];
        String university = fields[8];
        String college = fields[9];
        String department = fields[10];
        String designation = fields[11];
        String carType = fields[12];
        String carModel = fields[13];
        String carColor = fields[14];
        String carNumber = fields[15];
        String bikeType = fields[16];
        String bikeModel = fields[17];
        String bikeColor = fields[18];
        String bikeNumber = fields[19];
        String busType = fields[20];

        return new JsonObjectTransactionEntity(id, name, age, address, email, phone, school, company, university, college, department, designation, carType, carModel, carColor, carNumber, bikeType, bikeModel, bikeColor, bikeNumber, busType);

    }
}
