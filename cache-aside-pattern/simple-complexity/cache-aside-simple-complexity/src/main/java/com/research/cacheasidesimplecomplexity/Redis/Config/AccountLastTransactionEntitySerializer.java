package com.research.cacheasidesimplecomplexity.Redis.Config;

import com.research.cacheasidesimplecomplexity.entity.AccountLastTransactionEntity;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class AccountLastTransactionEntitySerializer implements RedisSerializer<AccountLastTransactionEntity> {

    @Override
    public byte[] serialize(AccountLastTransactionEntity entity) {
        if (entity == null) {
            return null;
        }
        String data = entity.toString();
        return data.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public AccountLastTransactionEntity deserialize(byte[] bytes) {

        if (bytes == null) {
            return null;
        }
        String data = new String(bytes, StandardCharsets.UTF_8);
        String[] fields = data.split(",");
        Long userAccountId = Long.parseLong(fields[0]);
        Long accountNumber = Long.parseLong(fields[1]);
        Long userBalance = Long.parseLong(fields[2]);
        Long lastTransaction = Long.parseLong(fields[3]);
        return new AccountLastTransactionEntity(userAccountId, accountNumber, userBalance, lastTransaction);

    }
}
