package com.neusoft.utils;

import com.neu.mail.MailSenderInfo;
import com.neu.mail.SimpleMailSender;
import com.neusoft.model.FailureReportT;
import com.neusoft.model.NpAlarmInfoT;

public class SendEmail {
	
	public static String sednEmail(FailureReportT report){
		try{
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost("smtp.163.com");
			mailInfo.setMailServerPort("25");
			mailInfo.setValidate(true);
			mailInfo.setUserName("18604023635@163.com");
			mailInfo.setPassword("13478247765qiang");// 您的邮箱密码
			mailInfo.setFromAddress("18604023635@163.com");
			String email = report.getNpDeviceInfoT().getNpContactorInfoT().getContactorEmail();
			mailInfo.setToAddress(email);
			mailInfo.setSubject("设备故障");
			
			String[] message = report.generateString().split(NpAlarmInfoT.SEPARATECHARS);
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("设备名称：" + message[1] + "\n");
			stringBuilder.append("设备IP：" + message[2] + "\n");
			stringBuilder.append("故障时间：" + message[0] + "\n");
			
			mailInfo.setContent(stringBuilder.toString());
			// 这个类主要来发送邮件
			SimpleMailSender sms = new SimpleMailSender();
			sms.sendTextMail(mailInfo);// 发送文体格式
			return "send email to " + email + " ok.";
			
		}catch (Exception e) {
			e.printStackTrace();
			return "send email error.";
		}
	}

}
