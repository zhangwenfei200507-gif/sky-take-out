package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "The data model transmitted when employees log in")
public class EmployeeLoginDTO implements Serializable {

    @ApiModelProperty("Username")
    private String username;

    @ApiModelProperty("password")
    private String password;

}
