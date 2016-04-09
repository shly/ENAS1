package com.time.task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class TimeTaskManageImpl implements TimeTaskManage {
	
	public ScheduledExecutorService service;
	public Map<TimeTask,Future<?>> timeTaskFutureMap;
	private boolean isRunning;
	
	static class InstanceHolder{
		static TimeTaskManage manager = new TimeTaskManageImpl();
	}
	
	public static TimeTaskManage getInstance(){
		TimeTaskManage manage = InstanceHolder.manager;
		return manage;
	}
	
	private TimeTaskManageImpl(){
		service = Executors.newScheduledThreadPool(2);
		timeTaskFutureMap = new HashMap<TimeTask,Future<?>>();
	}

	@Override
	public void submitTimeTask(TimeTask timeTask) {
		if(!timeTaskFutureMap.containsKey(timeTask)){
			System.out.println("提交任务："+timeTask.hashCode());
			timeTaskFutureMap.put(timeTask,service.scheduleWithFixedDelay(timeTask, 0, timeTask.period, timeTask.unit));
		}
	}

	@Override
	public void cancelTimeTask(TimeTask timeTask,boolean ifInterrupt) {
		Future<?> future = timeTaskFutureMap.get(timeTask);
		if(future != null){
			future.cancel(ifInterrupt);
			System.out.println("取消任务："+timeTask.hashCode());
			timeTaskFutureMap.remove(timeTask);
		}
	}
	
	@Override
	public TimeTask getTimeTask(String name) {
		for(TimeTask task : timeTaskFutureMap.keySet()){
			if(task.name.equals(name))
				return task;
		}
		return null;
	}

	@Override
	public synchronized void stop(boolean isNow) {
		if(isRunning){
			isRunning = false;
			if(isNow)
				service.shutdownNow();
			else
				service.shutdown();
		}
	}

	public synchronized void start(int poolSize) {
		if(!isRunning){
			initTimeTask();
			service = Executors.newScheduledThreadPool(poolSize);
			timeTaskFutureMap = new HashMap<TimeTask,Future<?>>();
			isRunning = true;
		}
	}
	
	private void initTimeTask(){
		//��ʼ�����
	}

	@Override
	public TimeTask[] getTimeTasks() {
		// TODO Auto-generated method stub
		return (TimeTask[])timeTaskFutureMap.keySet().toArray(new TimeTask[1]);
	}
}
