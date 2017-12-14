package com.chatbot.api.service;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.chatbot.api.model.Message;
import com.chatbot.api.model.User;
import com.chatbot.api.util.ChatBotException;
import org.springframework.stereotype.Service;

/**
 * Created by MaximeRnR on 13/12/17.
 */
@Service
public class ChatBotService {

    public static final String PRIVATE_DIALOG_FLOW_TOKEN = "";
    private static final String HAJIME_ID = "hajime";
    private static final String HAJIME_NAME = "HajimeBot";
    private static final User HAJIME_USER = new User(HAJIME_ID, HAJIME_NAME);

    private AIConfiguration configuration = new AIConfiguration(PRIVATE_DIALOG_FLOW_TOKEN);

    private AIDataService dataService = new AIDataService(configuration);

    public Message sendMessageAndGetBotResponse(String textFromUser) throws ChatBotException {

        AIRequest request = new AIRequest(textFromUser);
        String botResponse;
        try {
            AIResponse response = dataService.request(request);
            if (response.getStatus().getCode() == 200) {
                botResponse = response.getResult().getFulfillment().getSpeech();
                return new Message.MessageBuilder()
                        .author(HAJIME_USER)
                        .text(botResponse)
                        .build();
            }
            throw new ChatBotException(response.getStatus().getErrorDetails());

        } catch (AIServiceException e) {
            throw new ChatBotException(e.getResponse().getStatus().getErrorDetails(), e);
        }
    }
}
