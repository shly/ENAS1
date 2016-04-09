package com.time.task;

import java.util.concurrent.TimeUnit;

import com.neusoft.websocket.ChatWebSocketServlet.ChatMessageInbound;

public class PushNodeMessageTask extends TimeTask {
	
	private ChatMessageInbound inbound;
	private String[] attributes;

	public PushNodeMessageTask(ChatMessageInbound inbound,String[] attributes) {
		super(TimeUnit.MILLISECONDS, Long.parseLong(attributes[4]), String.valueOf(inbound.hashCode()));
		this.inbound = inbound;
		this.attributes = attributes;
	}

	@Override
	public void run() {
		inbound.sendMessage(inbound.generateResult(attributes));
	}

}
