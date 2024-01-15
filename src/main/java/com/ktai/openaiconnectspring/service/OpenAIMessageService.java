package com.ktai.openaiconnectspring.service;

import com.theokanning.openai.completion.CompletionChoice;

import java.util.List;

public interface OpenAIMessageService {
    List<CompletionChoice> send(String message);
}
