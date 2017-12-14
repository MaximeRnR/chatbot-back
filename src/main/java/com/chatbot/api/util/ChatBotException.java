package com.chatbot.api.util;

/**
 * Created by MaximeRnR on 13/12/17.
 */
public class ChatBotException extends Exception {

    public ChatBotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChatBotException(String message) {
        super(message);
    }
}
