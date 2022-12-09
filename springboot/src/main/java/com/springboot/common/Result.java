package com.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;
    private String message;
    private Object data;

    public static Result success(){
        return new Result(Constants.CODE_200,"操作成功",null);
    }
    public static Result success(Object data){
        return new Result(Constants.CODE_200,"操作成功",data);
    }
    public static Result error(String code,String message){
        return new Result(code,message,null);
    }
    public static Result success(String code,String message){
        return new Result(code,message,null);
    }
    public static Result success(String code,String message,Object data){
        return new Result(code,message,data);
    }
    public static Result error(){
        return new Result(Constants.CODE_500,"操作失败",null);
    }

}
