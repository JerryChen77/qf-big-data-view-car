package com.qf.bigdata.view.web.controller.api;

import com.qf.bigdata.view.web.service.CarService;
import com.qf.data.view.core.model.exception.ViewException;
import com.qf.data.view.core.model.request.CarSignRequest;
import com.qf.data.view.core.model.result.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarAPIController  {
    @Autowired
    private CarService carService;

    @PostMapping("/sign")
    public ResultModel signCar(@RequestBody CarSignRequest request){
        try {
            if (Objects.isNull(request)||Objects.isNull(request.getId())){
                throw new ViewException("参数错误");
            }
        }
        catch (ViewException e) {
            return ResultModel.error(e.getMessage());
        }
        return carService.signCar(request);
    }

    @GetMapping("/sign/total")
    public ResultModel getSignTotal(){
        return carService.getSignTotal();
    }


}
