package com.chatbot.api;

/**
 * Created by MaximeRnR on 30/11/17.
 */
public class Message {
    private String id;
    private User author;
    private boolean isRead;
    private String sendAt;
    private String text;

    public Message(){}

    public Message(String id, User author, boolean isRead, String sendAt, String text ) {
        this.id = id;
        this.author = author;
        this.isRead = isRead;
        this.sendAt = sendAt;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getSendAt() {
        return sendAt;
    }

    public void setSendAt(String sendAt) {
        this.sendAt = sendAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", author=" + author +
                ", isRead=" + isRead +
                ", sendAt='" + sendAt + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
