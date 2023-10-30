package com.example.p1;

public class BusinessStatusRequest {
    private String[] b_no;

    public BusinessStatusRequest(String[] b_no) {
        this.b_no = b_no;
    }

    public String[] getB_no() {
        return b_no;
    }

    public void setB_no(String[] b_no) {
        this.b_no = b_no;
    }
}
