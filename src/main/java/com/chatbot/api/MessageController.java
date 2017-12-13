package com.chatbot.api;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import org.springframework.web.bind.annotation.*;

import static com.chatbot.api.ChatbotConstant.*;

/**
 * Created by MaximeRnR on 30/11/17.
 */
@RestController
@CrossOrigin(origins = ("http://localhost:4200"))
@RequestMapping("/api/chatbot")
public class MessageController {

    AIConfiguration configuration = new AIConfiguration(PRIVATE_DIALOG_FLOW_TOKEN);

    AIDataService dataService = new AIDataService(configuration);

    @PostMapping(value = "/send")
    public Message getBotResponse(@RequestBody Message message) {

        AIRequest request = new AIRequest(message.getText());
        Message mess = new Message("0",
                new User(HAJIME_ID, HAJIME_NAME, HAJIME_AVATAR),
                false,
                "now",
                "");
        try {
            AIResponse response = dataService.request(request);
            if (response.getStatus().getCode() == 200) {
                mess.setText(response.getResult().getFulfillment().getSpeech());
            } else {
                mess.setText(response.getStatus().getErrorDetails());
            }
            return mess;
        } catch (AIServiceException e) {
            //dont care right now lol
            return null;
        }
    }


}
