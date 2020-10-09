package com.dilipmaharjan.learnjava.durgasoft.Multithreading;

import java.util.concurrent.Callable;

public class CallableApp implements Callable<Integer> {
	private Integer num;

	public CallableApp(Integer num) {

		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			sum += i;
		}
		return sum;
	}

}
