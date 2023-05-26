package com.bit.dto;

public class BitDemoDTO {
    private int no;
    private String message;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BitDemoDTO(int no, String message, String name) {
        super();
        this.no = no;
        this.message = message;
        this.name = name;
    }

    public BitDemoDTO() {

    }
}
