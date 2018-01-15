package com.social.enactive.bot.components.message;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.social.enactive.bot.components.user.User;

public class Message implements Serializable {

	private static final long serialVersionUID = 916551022124799080L;

	@Id
	private final String id;
	private final String conversationId;
	private final User sender;
	private final Content content;
	private final Instant instant;

	@JsonCreator
	public Message(String conversationId, User sender, Content content) {
		this.id = UUID.randomUUID().toString();
		this.conversationId = conversationId;
		this.sender = sender;
		this.content = content;
		this.instant = Instant.now();
	}

	public String getId() {
		return id;
	}

	public Content getContent() {
		return content;
	}

	public User getSender() {
		return sender;
	}

	public String getConversationId() {
		return conversationId;
	}

	public Instant getInstant() {
		return instant;
	}
	
	@Override
	public String toString() {
		return "Message {id=" + id + ", conversationId=" + conversationId + ", sender=" + sender + ", content="
				+ content + ", instant=" + instant + "}";
	}

}