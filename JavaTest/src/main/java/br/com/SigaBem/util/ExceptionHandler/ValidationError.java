package br.com.SigaBem.util.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private static final long SerialVersionUID = 1L;

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timestamp) {
        super(status, msg, timestamp);
    }

    public List<FieldMessage> getErrors() {
        return erros;
    }

    public void AddError(String fildname, String message){
        erros.add(new FieldMessage(fildname, message));
    }

}
