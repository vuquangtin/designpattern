package com.designpattern.concurrent.scheduling.iterators;

import java.util.Calendar;
import java.util.Date;

import com.designpattern.concurrent.scheduling.tiling.ScheduleIterator;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class OffsetIterator implements ScheduleIterator {

	private final ScheduleIterator scheduleIterator;
	private final int field;
	private final int offset;
	private final Calendar calendar = Calendar.getInstance();

	public OffsetIterator(ScheduleIterator scheduleIterator, int field,
			int offset) {
		this.scheduleIterator = scheduleIterator;
		this.field = field;
		this.offset = offset;
	}

	public Date next() {
		Date date = scheduleIterator.next();
		if (date == null) {
			return null;
		}
		calendar.setTime(date);
		calendar.add(field, offset);
		return calendar.getTime();
	}

}