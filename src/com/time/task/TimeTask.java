package com.time.task;

import java.util.concurrent.TimeUnit;

public abstract class TimeTask implements Runnable{
	
	public TimeTask(TimeUnit unit,long period,String name){
		this.unit = unit;
		this.period = period;
		this.name = name;
	}
	
	public final TimeUnit unit;
	public final long period; 
	public final String name;
}
