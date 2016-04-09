package com.time.task;


public interface TimeTaskManage {
	
	public void submitTimeTask(TimeTask timeTask);
	
	public void cancelTimeTask(TimeTask timeTask, boolean ifInterrupt);
	
	public TimeTask getTimeTask(String name);
	
	public TimeTask[] getTimeTasks();
	
	public void stop(boolean isNow);
	
}
