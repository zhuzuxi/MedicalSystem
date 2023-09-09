package com.zzs.Common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class R<T> {
    private Integer code;
    private String msg;

    private Object data;

    public static R err(String msg){
        return new R(400,msg,null);
    }

    public static R success(String msg,Object data){
        return new R(200,msg,data);
    }

}
