package com.kreate.daggerwithhilt.entity.response;

import java.io.Serializable;

public class ResponseEntity implements Serializable {

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
