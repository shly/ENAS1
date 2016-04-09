package com.time.task.test;

import java.util.concurrent.TimeUnit;

import com.time.task.TimeTask;
import com.time.task.TimeTaskManage;
import com.time.task.TimeTaskManageImpl;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		TimeTaskManage timeTaskManage = TimeTaskManageImpl.getInstance();
		
		TimeTask task_1 = new TestTimeTask(TimeUnit.MILLISECONDS, 1000, "TimeTask_1");
		TimeTask task_2 = new TestTimeTask(TimeUnit.SECONDS, 2, "TimeTask_2");
		
		timeTaskManage.submitTimeTask(task_1);
		timeTaskManage.submitTimeTask(task_2);
		
		Thread.sleep(5000);
		
		for(TimeTask task : timeTaskManage.getTimeTasks()){
			System.out.println(task.toString());
		}
		
		timeTaskManage.cancelTimeTask(task_1, false);
		
		for(TimeTask task : timeTaskManage.getTimeTasks()){
			System.out.println(task.toString());
		}
		
		timeTaskManage.stop(false);

	}

}
