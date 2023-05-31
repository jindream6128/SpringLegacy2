package com.bit.dto;

import lombok.Data;

@Data
public class TestDTO {
    private String userName;
    private String userLoc;
    private int wait;

    public TestDTO(String userName, String userLoc, int wait) {
        super();
        this.userName = userName;
        this.userLoc = userLoc;
        this.wait = wait;
    }
}
