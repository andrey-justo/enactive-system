package com.social.enactive.bot.queue.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.social.enactive.bot.components.message.Message;
import com.social.enactive.bot.configuration.log.Log;

public class MessagingReceiverHandlerRouter {

	private final SimpMessagingTemplate webSocket;

	public MessagingReceiverHandlerRouter(SimpMessagingTemplate webSocket) {
		this.webSocket = webSocket;
	}

	public void handleMessage(List<Message> messages) {
		Log.SYSTEM.info("Sending messages={}", messages);
		messages.stream().collect(Collectors.groupingBy(Message::getConversationId)).forEach((key, value) -> {
			Log.SYSTEM.info("Messages to={}, {}", key, value);
			webSocket.convertAndSend("/channel/public/" + key, value);
		});
	}

}
