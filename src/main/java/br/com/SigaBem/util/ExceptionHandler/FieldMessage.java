package br.com.SigaBem.util.ExceptionHandler;

import java.io.Serializable;

public class FieldMessage implements Serializable {

    private String fildname;
    private String message;

    public FieldMessage() {
    }

    public FieldMessage(String fildname, String message) {
        this.fildname = fildname;
        this.message = message;
    }

    public String getFildname() {
        return fildname;
    }

    public void setFildname(String fildname) {
        this.fildname = fildname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
