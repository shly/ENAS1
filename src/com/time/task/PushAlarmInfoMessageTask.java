package com.time.task;

import java.util.concurrent.TimeUnit;

import com.neusoft.websocket.AlarmInfoWebSocketServlet.AlarmInfoInbound;

public class PushAlarmInfoMessageTask extends TimeTask {
	
	private AlarmInfoInbound inbound;
	private String[] attributes;

	public PushAlarmInfoMessageTask(AlarmInfoInbound inbound, String[] attributes) {
		super(TimeUnit.MILLISECONDS, Long.parseLong(attributes[2]), String.valueOf(inbound.hashCode()));
		this.inbound = inbound;
		this.attributes = attributes;
	}

	@Override
	public void run() {
		inbound.sendMessage(inbound.generateResult(attributes));
	}

	public AlarmInfoInbound getInbound() {
		return inbound;
	}

	public void setInbound(AlarmInfoInbound inbound) {
		this.inbound = inbound;
	}

}
