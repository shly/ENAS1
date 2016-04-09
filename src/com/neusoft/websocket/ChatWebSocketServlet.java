/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neusoft.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.neusoft.model.facade.NodeFacade;
import com.neusoft.model.facade.NpAlarmInfoFacade;
import com.neusoft.service.NodeLinkManageService;
import com.neusoft.service.NpAlarmInfoService;
import com.time.task.PushNodeMessageTask;
import com.time.task.TimeTask;
import com.time.task.TimeTaskManage;
import com.time.task.TimeTaskManageImpl;



/**
 * Example web socket servlet for chat.
 */
public class ChatWebSocketServlet extends WebSocketServlet {

    private static final long serialVersionUID = 1L;

    private static final String GUEST_PREFIX = "Guest";

    private final AtomicInteger connectionIds = new AtomicInteger(0);
    private final static Set<ChatMessageInbound> connections =
            new CopyOnWriteArraySet<ChatMessageInbound>();

    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol,
            HttpServletRequest request) {
        return new ChatMessageInbound(connectionIds.incrementAndGet());
    }
    
    public static Set<ChatMessageInbound> getChatMessageInbounds(){
    	return connections;
    }
    
    /*private ServletContext getServletContext(){
    	return this.getServletContext();
    }*/

    public final class ChatMessageInbound extends MessageInbound {

        private final String nickname;

        private ChatMessageInbound(int id) {
            this.nickname = GUEST_PREFIX + id;
        }
        
        public String getNickName(){
        	return nickname;
        }

        @Override
        protected void onOpen(WsOutbound outbound) {
            connections.add(this);
        }

        @Override
        protected void onClose(int status) {
            connections.remove(this);
            try{
        		TimeTaskManage timeTaskManage = TimeTaskManageImpl.getInstance();
        		TimeTask task = timeTaskManage.getTimeTask(String.valueOf(this.hashCode()));
        		if(task != null)
        			timeTaskManage.cancelTimeTask(task, false);
    		}catch (Exception ex) {
    			ex.printStackTrace();
    		}
        }

        @Override
        protected void onBinaryMessage(ByteBuffer message) throws IOException {
            throw new UnsupportedOperationException(
                    "Binary message not supported.");
        }

        @SuppressWarnings("deprecation")
		@Override
        protected void onTextMessage(CharBuffer message) throws IOException {
        	String messageValue = message.toString();
        	if(messageValue.startsWith("check_")){
        		//执行查询请求
        		try{
	        		String[] attributes = messageValue.split("_");
	        		TimeTaskManage timeTaskManage = TimeTaskManageImpl.getInstance();
	        		TimeTask task = timeTaskManage.getTimeTask(String.valueOf(this.hashCode()));
	        		if(task != null)
	        			timeTaskManage.cancelTimeTask(task, false);
		        	task = new PushNodeMessageTask(this,attributes);
		        	timeTaskManage.submitTimeTask(task);
        		}catch (Exception e) {
        			e.printStackTrace();
                }
        		
        	}else if("begin".equals(messageValue)){
        		TimeTaskManage timeTaskManage = TimeTaskManageImpl.getInstance();
        		TimeTask task = timeTaskManage.getTimeTask(String.valueOf(this.hashCode()));
        		if(task != null)
        			timeTaskManage.cancelTimeTask(task, false);
        		String[] attributes = {"check","222.62.193.243","3","1","2000"};
	        	task = new PushNodeMessageTask(this,attributes);
	        	timeTaskManage.submitTimeTask(task);
        	}else if("stop".equals(messageValue)){
        		TimeTaskManage timeTaskManage = TimeTaskManageImpl.getInstance();
        		TimeTask task = timeTaskManage.getTimeTask(String.valueOf(this.hashCode()));
        		if(task != null)
        			timeTaskManage.cancelTimeTask(task, false);
        	}
        }
        
        public String generateResult(String[] attributes){
			try{
				ServletContext context = getServletContext();
	    		WebApplicationContext  webApplicationContext  = WebApplicationContextUtils.getWebApplicationContext(context);
	    		NodeLinkManageService nodeLinkManageService = (NodeLinkManageService) webApplicationContext.getBean("nodeLinkManageService");
	    		NodeFacade nodeFacade = nodeLinkManageService.getNodeTopology(attributes[1], Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]));
	    		String result = nodeLinkManageService.transformNodeFacade(nodeFacade);
    			return result;
    		}catch (Exception e) {
				e.printStackTrace();
				return "Exception in generateResult.";
			}
		}
        
        public void sendMessage(String message){
        	try{
        		CharBuffer buffer = CharBuffer.wrap(message);
                getWsOutbound().writeTextMessage(buffer);
        	}catch (IOException e) {
        		try{
	        		TimeTaskManage timeTaskManage = TimeTaskManageImpl.getInstance();
	        		TimeTask task = timeTaskManage.getTimeTask(String.valueOf(this.hashCode()));
	        		if(task != null)
	        			timeTaskManage.cancelTimeTask(task, false);
        		}catch (Exception ex) {
        			ex.printStackTrace();
        		}
        	}
        }

       /* private void broadcast(String message) {
            for (ChatMessageInbound connection : connections) {
                try {
                    CharBuffer buffer = CharBuffer.wrap(message);
                    connection.getWsOutbound().writeTextMessage(buffer);
                } catch (IOException ignore) {
                    // Ignore
                }
            }
        }*/
    }
}