package com.time.task.test;

import java.util.concurrent.TimeUnit;

import com.time.task.TimeTask;

public class TestTimeTask extends TimeTask {

	public TestTimeTask(TimeUnit unit, long period, String name) {
		super(unit, period, name);
	}

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis() + ":" + name + ": is running.");
	}
	
	public String toString(){
		return name + "_" + unit + "_" + period;
	}

}
