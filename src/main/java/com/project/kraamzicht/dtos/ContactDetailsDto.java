package com.project.kraamzicht.dtos;

public class ContactDetailsDto {
    private String phoneNr;
    private String email;

    public ContactDetailsDto() {
        this.phoneNr = phoneNr;
        this.email = email;
    }
    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
