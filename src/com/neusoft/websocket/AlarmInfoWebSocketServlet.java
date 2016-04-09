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

import com.neusoft.model.NpAlarmInfoT;
import com.neusoft.model.facade.NodeFacade;
import com.neusoft.model.facade.NpAlarmInfoFacade;
import com.neusoft.service.NodeLinkManageService;
import com.neusoft.service.NpAlarmInfoService;
import com.time.task.PushAlarmInfoMessageTask;
import com.time.task.PushNodeMessageTask;
import com.time.task.TimeTask;
import com.time.task.TimeTaskManage;
import com.time.task.TimeTaskManageImpl;

public class AlarmInfoWebSocketServlet extends WebSocketServlet {
	
	private static final String GUEST_PREFIX = "Guest";
	private final AtomicInteger connectionIds = new AtomicInteger(0);
	private final static Set<AlarmInfoInbound> connections =
            new CopyOnWriteArraySet<AlarmInfoInbound>();

	@Override
	protected StreamInbound createWebSocketInbound(String arg0,
			HttpServletRequest arg1) {
		// TODO Auto-generated method stub
		return new AlarmInfoInbound(connectionIds.incrementAndGet());
	}
	
	 public final class AlarmInfoInbound extends MessageInbound {

	        private final String nickname;

	        private AlarmInfoInbound(int id) {
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

			@Override
	        protected void onTextMessage(CharBuffer message) throws IOException {
	        	String messageValue = message.toString();
	        	//checkAlarm_随机数量_周期
	        	if(messageValue.startsWith("checkAlarm")){
	        		//执行查询请求
	        		try{
		        		String[] attributes = messageValue.split("_");
		        		TimeTaskManage timeTaskManage = TimeTaskManageImpl.getInstance();
		        		TimeTask task = timeTaskManage.getTimeTask(String.valueOf(this.hashCode()));
		        		if(task != null)
		        			timeTaskManage.cancelTimeTask(task, false);
			        	task = new PushAlarmInfoMessageTask(this,attributes);
			        	timeTaskManage.submitTimeTask(task);
	        		}catch (Exception e) {
	        			e.printStackTrace();
	                }
	        		
	        	}else if("begin".equals(messageValue)){
	        		TimeTaskManage timeTaskManage = TimeTaskManageImpl.getInstance();
	        		TimeTask task = timeTaskManage.getTimeTask(String.valueOf(this.hashCode()));
	        		if(task != null)
	        			timeTaskManage.cancelTimeTask(task, false);
	        		String[] attributes = {"checkAlarm","5","2000"};
		        	task = new PushAlarmInfoMessageTask(this,attributes);
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
		    		NpAlarmInfoService npAlarmInfoService = (NpAlarmInfoService) webApplicationContext.getBean("npAlarmInfoService");
		    		
		    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    		//List<NpAlarmInfoT> npAlarmInfoTs = npAlarmInfoService.findAlarmInfos(df.parse("2014-01-01 01:01:01"), new Date(), null, null, null, null);
		    		int size = Integer.parseInt(attributes[1]);
		    		size = new Random().nextInt(size) + size;
		    		//List<NpAlarmInfoT> npAlarmInfoTs = npAlarmInfoService.findRandomAlarmInfos(size);
		    		List<NpAlarmInfoFacade> npAlarmInfoFacades = npAlarmInfoService.findRandomAlarmInfoFacades(size);
		    		
	    			StringBuilder sb = new StringBuilder();
	    			sb.append(df.format(new Date()) + "\n");
	    			for(NpAlarmInfoFacade npAlarmInfoFacade : npAlarmInfoFacades){
	    				sb.append(npAlarmInfoFacade.generateString());
	    				sb.append("\n");
	    			}
	    			return sb.toString();
	    		}catch (Exception e) {
					e.printStackTrace();
					return "Exception in generateResult.";
				}
			}
			
			public void sendMessage(String message){
				try {
                    CharBuffer buffer = CharBuffer.wrap(message);
                    getWsOutbound().writeTextMessage(buffer);
                } catch (Exception e) {
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
	 }

}
