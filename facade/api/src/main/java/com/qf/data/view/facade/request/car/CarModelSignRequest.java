package com.qf.data.view.facade.request.car;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Cjl
 * @date 2021/8/16 20:16
 */
@Data
public class CarModelSignRequest implements Serializable {
    private Integer id;
    private String date;
    private String owner;
}
