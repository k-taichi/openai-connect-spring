package com.ktai.openaiconnectspring.service;

import com.ktai.openaiconnectspring.prop.OpenAIProp;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class OpenAIMessageServiceImpl implements OpenAIMessageService{

    private final OpenAIProp openAIProp;

    public OpenAIMessageServiceImpl(OpenAIProp openAIProp){
        this.openAIProp=openAIProp;
    }

    @Override
    public List<CompletionChoice> send(String prompt) {
        int maxTokens = Integer.valueOf(openAIProp.getMaxTokens());
        Double temperature = Double.valueOf(openAIProp.getTemperature());

        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model(openAIProp.getModel())
                .echo(true)
                .maxTokens(maxTokens)
                .temperature(temperature)
                .build();
        ;
        OpenAiService service = new OpenAiService(openAIProp.getToken(),Duration.ofSeconds(120));
        List<CompletionChoice> choiceList = service.createCompletion(completionRequest).getChoices();
        return choiceList;
    }
}
