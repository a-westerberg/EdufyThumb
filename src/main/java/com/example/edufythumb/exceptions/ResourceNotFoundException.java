package com.example.edufythumb.exceptions;

//ED-217-SA
public class ResourceNotFoundException extends RuntimeException {
    private String object;
    private String field;
    private Object value;

    private String field2;
    private Object value2;

    //ED-217-SA
    public ResourceNotFoundException(String object, String field, Object value) {
        super(String.format("No %s found with %s [%s]", object, field, value));
        this.object = object;
        this.field = field;
        this.value = value;
    }

    //ED-217-SA
    public ResourceNotFoundException(String object, String field, String field2, Object value, Object value2) {
        super(String.format("No %s found with both %s [%s] and %s [%s]", object, field, field2, value, value));
        this.object = object;
        this.field = field;
        this.field2 = field2;
        this.value = value;
        this.value2 = value2;
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public String getObject() {
        return object;
    }

    public String getField() {
        return field;
    }

    public Object getValue() {
        return value;
    }

    public String getField2() {
        return field2;
    }

    public Object getValue2() {
        return value2;
    }
}
