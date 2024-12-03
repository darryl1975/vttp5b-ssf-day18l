package sg.edu.nus.iss.vttp5b_ssf_day18l.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5b_ssf_day18l.constant.Constant;

@Repository
public class MapRepo {

    @Autowired
    @Qualifier(Constant.template02)
    RedisTemplate redisTemplate;

    // day 15 - slide 36
    public void createHash(String key, String hashKey, String value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    // day 15 - slide 37
    public String get(String key, String hashKey) {
        Object objValue = redisTemplate.opsForHash().get(key, hashKey);
        return objValue.toString();
    }

    // day 15 - slide 38
    public void deleteHashKey(String key, String hashKey) {
        redisTemplate.opsForHash().delete(key, hashKey);
    }

    // day 15 - slide 39
    public Boolean hashKeyExists(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    // day 15 - slide 40
    // List<Object> values = template.opsForHash().values("c01")l
    public List<Object> getValues(String key) {
        List<Object> values = redisTemplate.opsForHash().values(key);
        return values;
    }

    // day 15 - slide 41
    // long mapSize= template.opsForHash().size(“c01”);
    public Long size(String key) {
        return redisTemplate.opsForHash().size(key);
    }
}
