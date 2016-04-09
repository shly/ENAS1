package com.time.task;

import java.util.concurrent.TimeUnit;

import com.neusoft.websocket.FailureReportWebSocketServlet.FailureReportInbound;

public class PushFailureReportMessageTask extends TimeTask {
	
	private FailureReportInbound inbound;
	private String[] attributes;

	public PushFailureReportMessageTask(FailureReportInbound inbound, String[] attributes) {
		super(TimeUnit.MILLISECONDS, Long.parseLong(attributes[0]), String.valueOf(inbound.hashCode()));
		this.inbound = inbound;
		this.attributes = attributes;
	}

	@Override
	public void run() {
		System.out.println("发送故障，发送报告。");
		inbound.sendMessage(inbound.generateResult(attributes));
	}

}
