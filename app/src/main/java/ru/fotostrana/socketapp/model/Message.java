package ru.fotostrana.socketapp.model;

/* loaded from: classes2.dex */
public class Message {
    private String message;
    private int messageType;

    public Message(String str, int i) {
        this.message = str;
        this.messageType = i;
    }

    public String getMessage() {
        return this.message;
    }

    public int getMessageType() {
        return this.messageType;
    }
}
