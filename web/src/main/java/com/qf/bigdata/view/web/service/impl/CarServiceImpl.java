package com.qf.bigdata.view.web.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.bigdata.view.web.service.CarService;
import com.qf.data.view.core.model.request.CarSignRequest;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.api.CarFacade;
import com.qf.data.view.facade.request.car.CarModelSignRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Cjl
 * @date 2021/8/16 20:04
 */
@Service
public class CarServiceImpl implements CarService {
    @Reference
    private CarFacade carFacade;

    @Override
    public ResultModel signCar(CarSignRequest request) {
        CarModelSignRequest modelSignRequest = new CarModelSignRequest();
        BeanUtils.copyProperties(request,modelSignRequest);
        ResultModel resultModel = carFacade.signCar(modelSignRequest);
        if (Objects.isNull(resultModel)){
            return ResultModel.error("服务器错误");
        }
        return resultModel;
    }

    @Override
    public ResultModel getSignTotal() {
        return carFacade.getSignTotal();
    }


}
