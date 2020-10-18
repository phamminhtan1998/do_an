package com.example.demo.contants;

public enum  ResponseCode {

    ADD_SUCCESSFUL("Add Successfully"),
    ADD_FAIL("Add Fail"),
    UPDATE_SUCCESSFUL("Update Successfully"),
    UPDATE_FAIL("Update Fail"),
    DELETE_SUCCESSFUL("Delete Successfully"),
    DELETE_FAIL("Delete Fail");


    private String message;
    ResponseCode(String message){
        this.message  = message ;
    }
    public String getMessage(){
        return this.message;
    }
}
