package com.ktai.openaiconnectspring;

import com.ktai.openaiconnectspring.service.OpenAIMessageService;
import com.theokanning.openai.completion.CompletionChoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.callback.ChoiceCallback;
import java.text.ChoiceFormat;
import java.util.List;

@SpringBootTest
class OpenaiConnectSpringApplicationTests {
    @Autowired
    private OpenAIMessageService openAIMessageService;

    @Test
    void contextLoads() {
        //String sendStr="Q: Javaのフレームワークを教えて下さい。? A:";
        String sendStr="Javaのフレームワークを教えて下さい。";
        List<CompletionChoice> choiceList= openAIMessageService.send(sendStr);
        choiceList.forEach(i->{
            System.out.println(i.getText());
        });
    }

}
