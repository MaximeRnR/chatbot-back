package com.chatbot.api;

/**
 * Created by MaximeRnR on 01/12/17.
 */
public class User {
    private String id;
    private String name;
    private String avatarSrc;

    public User(){}


    public User(String id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatarSrc = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarSrc() {
        return avatarSrc;
    }

    public void setAvatarSrc(String avatarSrc) {
        this.avatarSrc = avatarSrc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatarSrc='" + avatarSrc + '\'' +
                '}';
    }
}
