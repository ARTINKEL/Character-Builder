package edu.bsu.cs222.model;

import java.util.HashMap;

public class ErrorHandler {

    HashMap<String, String> errors = new HashMap<>();

    public ErrorHandler(){
        populateErrors();
    }

    private void populateErrors() {
        errors.put("blankField", "ERROR: Text field must not be blank");
        errors.put("generic", "GENERIC ERROR: We derped up");
    }

    public String returnError(String key) {
        try {
            return errors.get(key);
        } catch (Exception e) {
            return errors.get("generic");
        }
    }
}
