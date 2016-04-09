package com.neusoft.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
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

import com.neusoft.model.FailureReportT;
import com.neusoft.service.FailureReportService;
import com.neusoft.utils.PageHelper;
import com.neusoft.utils.SendEmail;
import com.time.task.PushFailureReportMessageTask;
import com.time.task.TimeTask;
import com.time.task.TimeTaskManage;
import com.time.task.TimeTaskManageImpl;

public class FailureReportWebSocketServlet extends WebSocketServlet {
	
	private static final String GUEST_PREFIX = "Guest";
	private final AtomicInteger connectionIds = new AtomicInteger(0);
	private final static Set<FailureReportInbound> connections =
            new CopyOnWriteArraySet<FailureReportInbound>();

	@Override
	protected StreamInbound createWebSocketInbound(String arg0,
			HttpServletRequest arg1) {
		// TODO Auto-generated method stub
		return new FailureReportInbound(connectionIds.incrementAndGet());
	}
	
	 public final class FailureReportInbound extends MessageInbound {

	        private final String nickname;

	        private FailureReportInbound(int id) {
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
	        	if("begin".equals(messageValue)){
	        		TimeTaskManage timeTaskManage = TimeTaskManageImpl.getInstance();
	        		TimeTask task = timeTaskManage.getTimeTask(String.valueOf(this.hashCode()));
	        		if(task != null)
	        			timeTaskManage.cancelTimeTask(task, false);
	        		String[] attributes = {"5000"};
		        	task = new PushFailureReportMessageTask(this,attributes);
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
		    		FailureReportService failureReportService = (FailureReportService) webApplicationContext.getBean("failureReportService");
		    		
		    		PageHelper pageHelper = new PageHelper();
					  
					pageHelper.setBeginPage(0);
		    		//List<NpAlarmInfoT> npAlarmInfoTs = npAlarmInfoService.findRandomAlarmInfos(size);
		    		List<FailureReportT> failureReports = failureReportService.findFailureReports("", "", pageHelper);
		    		
		    		int size = failureReports.size();
		    		size = new Random().nextInt(size);
		    		
	    			StringBuilder sb = new StringBuilder();
	    			final FailureReportT report = failureReports.get(size);
	    			
	    			sb.append(report.generateString());
	    			sb.append("\n");
	    			
	    			String email = report.getNpDeviceInfoT().getNpContactorInfoT().getContactorEmail();
	    			sb.append("send email to " + email + " ok.");
	    			
	    			new Thread(new Runnable(){

						@Override
						public void run() {
							try{
								SendEmail.sednEmail(report);
							}catch(Exception e){
								//e.printStackTrace();
								System.out.println("邮件发送失败");
							}
						}
	    				
	    			}).start();

	    			
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
