package com.example.demo.controller;

import com.example.demo.model.msg.ChatMensagem;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
@Controller
public class ChatController {

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMensagem register(@Payload ChatMensagem mensagem, SimpMessageHeaderAccessor accessor){
        System.out.println("new >>"+mensagem);
        accessor.getSessionAttributes().put("username",mensagem.getRemetente());
        accessor.getSessionAttributes().put("nome","anonimo");
        mensagem.setConteudo("chegui nessa porra!!!");
        return mensagem;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMensagem sendMessage(@Payload ChatMensagem mensagem, SimpMessageHeaderAccessor accessor){
        System.out.println("msg >>" + mensagem);
        System.out.println("acessor >>>" + accessor.getSessionAttributes().get("username"));
        mensagem.setNome(accessor.getSessionAttributes().get("nome").toString());
        return mensagem;
    }
}
