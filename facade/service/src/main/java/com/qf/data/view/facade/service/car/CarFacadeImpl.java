package com.qf.data.view.facade.service.car;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.data.view.core.model.constant.RedisConstant;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.core.service.utils.RedisUtil;
import com.qf.data.view.facade.api.CarFacade;
import com.qf.data.view.facade.request.car.CarModelSignRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Cjl
 * @date 2021/8/16 20:13
 */
@Service
public class CarFacadeImpl implements CarFacade {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResultModel signCar(CarModelSignRequest modelSignRequest) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        String date = modelSignRequest.getDate().substring(0,10);
        String redisKey = RedisUtil.getRedisKey(RedisConstant.CAR_SIGN_PRE, date);
        if (redisTemplate.opsForValue().increment(redisKey)==1){
            redisTemplate.expire(redisKey,3, TimeUnit.DAYS);
        }
        return ResultModel.success();
    }

    @Override
    public ResultModel getSignTotal() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        Date date =new Date();
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd");
        String dateFormat = sf.format(date);
        String redisKey = RedisUtil.getRedisKey(RedisConstant.CAR_SIGN_PRE, dateFormat);
        String total = (String) redisTemplate.opsForValue().get(redisKey);
        Integer count = Integer.valueOf(total);
        return ResultModel.success(count);

    }
}
