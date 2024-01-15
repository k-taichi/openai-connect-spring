package com.ktai.openaiconnectspring.controller;

import com.ktai.openaiconnectspring.dto.AnswerDto;
import com.ktai.openaiconnectspring.dto.QuestionDto;
import com.ktai.openaiconnectspring.service.OpenAIMessageService;
import com.theokanning.openai.completion.CompletionChoice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpenAISendController {

        private OpenAIMessageService openAIMessageService;

        public OpenAISendController(OpenAIMessageService openAIMessageService){
                this.openAIMessageService=openAIMessageService;
        }

        @PostMapping(value = "/send",produces= MediaType.APPLICATION_JSON_VALUE)
        public AnswerDto send(@RequestBody QuestionDto questionDto) {
                AnswerDto answerDto = new AnswerDto();
                List<CompletionChoice> result =openAIMessageService.send("Q: "+questionDto.getQuestion()+"\nA:");
                result.forEach(i->{
                        answerDto.setMessage(i.getText());
                });
                return answerDto;
        }
        //curl -X POST -d '{"":""}'

}
