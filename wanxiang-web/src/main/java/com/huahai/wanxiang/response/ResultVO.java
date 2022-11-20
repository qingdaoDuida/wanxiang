package com.huahai.wanxiang.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO <T> implements Serializable {

    private T data;
    private Integer code;
    private String desc;

    public void setSuccessData(T data) {
        this.setData(data);
        this.setCode(20000);
        this.setDesc("成功");
    }

    public void setFail(String desc) {
        this.setCode(500);
        this.setDesc(desc);
    }
}
