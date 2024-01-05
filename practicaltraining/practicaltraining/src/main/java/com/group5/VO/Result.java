package com.group5.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private Object data;
    private int code;
    private String msg;

    public static Result ok(Object data){
        return new Result(data,1,"success!!");
    }

    public static Result fail(String msg){
        return new Result(null,-1,"fail!!");
    }

}
