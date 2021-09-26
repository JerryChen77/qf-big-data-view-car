package com.qf.data.view.facade.api;

import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.request.car.CarModelSignRequest;

/**
 * @author Cjl
 * @date 2021/8/16 20:13
 */
public interface CarFacade {
    ResultModel signCar(CarModelSignRequest modelSignRequest);

    ResultModel getSignTotal();
}
