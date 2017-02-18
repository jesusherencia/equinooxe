package com.equinooxe.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mitchellbosecke.pebble.extension.Filter;

/**
 * Caclculate a Since from input string and output desired format
 * @todo use desired format
 * 
 * @author mboullouz
 *
 */
public class SinceDatePebbleFilter implements Filter {
	private final List<String> argumentNames = new ArrayList<>();

	public SinceDatePebbleFilter() {
		// argumentNames.add("full");
		// argumentNames.add("medium");
		// argumentNames.add("minimal");

	}

	@Override
	public List<String> getArgumentNames() {
		return argumentNames;
	}

	@Override
	public Object apply(Object input, Map<String, Object> args) {
		if (input == null) {
			return "Unknown";
		}
		String desiredFormat = (String) args.get("format");
		String inString = (String) input;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime in = LocalDateTime.parse(inString, formatter);

		return getDiff(in, desiredFormat);
	}

	private String getDiff(LocalDateTime from, String desiredFormat) {
		LocalDateTime toDateTime = LocalDateTime.now();
		LocalDateTime tempDateTime = LocalDateTime.from(from);

		long years = tempDateTime.until(toDateTime, ChronoUnit.YEARS);
		tempDateTime = tempDateTime.plusYears(years);

		long months = tempDateTime.until(toDateTime, ChronoUnit.MONTHS);
		tempDateTime = tempDateTime.plusMonths(months);

		long days = tempDateTime.until(toDateTime, ChronoUnit.DAYS);
		tempDateTime = tempDateTime.plusDays(days);

		long hours = tempDateTime.until(toDateTime, ChronoUnit.HOURS);
		tempDateTime = tempDateTime.plusHours(hours);

		long minutes = tempDateTime.until(toDateTime, ChronoUnit.MINUTES);
		tempDateTime = tempDateTime.plusMinutes(minutes);

		String out = "";
		if (years > 1) {
			out += years + " ans";
			return out;
		}
		if (years > 0)
			out += years + " an ";
		if (months > 0)
			out += months + " mois ";
		if (days > 0)
			out += days + " jour"+(days>1?"s ":" ");
		if (hours > 0)
			out += hours + " heure"+(hours>1?"s ":" ");
		if(minutes>0)
			out+= minutes+ " minute"+(minutes>1?"s ":" ");
		
		if(StringUtils.isBlank(out)){
			out=" il y un instant";
		}
		return out;
	}
}