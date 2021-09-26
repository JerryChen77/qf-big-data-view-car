package com.qf.bigdata.view.web.service;

import com.qf.data.view.core.model.request.CarSignRequest;
import com.qf.data.view.core.model.result.ResultModel;

import java.sql.ResultSet;

/**
 * @author Cjl
 * @date 2021/8/16 20:03
 */
public interface CarService {
    ResultModel signCar(CarSignRequest request);


    ResultModel getSignTotal();
}
