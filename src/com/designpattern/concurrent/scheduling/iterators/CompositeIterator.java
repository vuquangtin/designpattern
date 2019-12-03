package com.designpattern.concurrent.scheduling.iterators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.designpattern.concurrent.scheduling.tiling.ScheduleIterator;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class CompositeIterator implements ScheduleIterator {

	private List<Date> orderedTimes = new ArrayList<Date>();
	private List<ScheduleIterator> orderedIterators = new ArrayList<ScheduleIterator>();

	public CompositeIterator(ScheduleIterator[] scheduleIterators) {
		for (int i = 0; i < scheduleIterators.length; i++) {
			insert(scheduleIterators[i]);
		}
	}

	private void insert(ScheduleIterator scheduleIterator) {
		Date time = scheduleIterator.next();
		if (time == null) {
			return;
		}
		int index = Collections.binarySearch(orderedTimes, time);
		if (index < 0) {
			index = -index - 1;
		}
		orderedTimes.add(index, time);
		orderedIterators.add(index, scheduleIterator);
	}

	public synchronized Date next() {
		Date next = null;
		while (!orderedTimes.isEmpty() &&
				(next == null || next.equals((Date) orderedTimes.get(0)))) {
			next = (Date) orderedTimes.remove(0);
			insert((ScheduleIterator) orderedIterators.remove(0));
		}
		return next;
	}


}