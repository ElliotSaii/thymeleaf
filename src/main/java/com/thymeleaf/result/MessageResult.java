package com.thymeleaf.result;

import com.thymeleaf.constant.CommonCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResult implements Serializable {

    private int code;
    private String message;
    private boolean success;
    private Object result;

    public MessageResult success(String message){
        this.message =message;
        this.code= CommonCode.OK_200;
        this.success = true;
        return this;
    }
    public MessageResult success(){
        this.message ="Operation Success";
        this.code= CommonCode.OK_200;
        this.success = true;
        return this;
    }
    public MessageResult success(Object data){
        this.message ="Operation success";
        this.code= CommonCode.OK_200;
        this.success = true;
        this.result = data;
        return this;
    }
    public MessageResult fail(String message){
        this.message =message;
        this.code= CommonCode.Internal_Server_500;
        this.success = false;
        return this;
    }
    public MessageResult fail(){
        this.message ="Operation fail";
        this.code= CommonCode.Internal_Server_500;
        this.success = false;
        return this;
    }

}
