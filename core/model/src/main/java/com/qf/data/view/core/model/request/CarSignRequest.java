package com.qf.data.view.core.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Cjl
 * @date 2021/8/16 20:09
 */
@Data
public class CarSignRequest implements Serializable {
    private Integer id;
    private String date;
    private String owner;


}
