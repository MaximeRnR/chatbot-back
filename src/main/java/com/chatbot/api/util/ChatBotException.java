package com.chatbot.api.util;

import ai.api.AIServiceException;

/**
 * Created by ippon-t on 13/12/17.
 */
public class ChatBotException extends Exception {

    public ChatBotException(String message, Throwable cause) {
        super(message, cause);
    }
}
