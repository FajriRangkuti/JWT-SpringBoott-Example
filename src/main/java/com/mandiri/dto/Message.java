package com.mandiri.dto;

public class Message {

    private String message;
    private String subject;

    public Message(String message, String subject) {
        this.message = message;
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }
}
