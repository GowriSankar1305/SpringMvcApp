package com.tectoro.mvc.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tectoro.mvc.enums.DateFormatEnum;

public class DateAndTimeUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(DateAndTimeUtils.class);
	
	public static Date convertStringtoSqlDate(String date,DateFormatEnum dateFormat)	{
		logger.info("*************** Start of DateAndTimeUtils.convertStringtoSqlDate ***************");
		Date parsedDate = null;
		try	{
			DateFormat format = new SimpleDateFormat(dateFormat.name());
			parsedDate = new Date(format.parse(date).getTime());
		}
		catch(ParseException pe)	{
			logger.error(" <<<<<<<<<<<<<<<<<<<< ParseException at convertStringtoSqlDate:: {}",pe);
		}
		catch(Exception e)	{
			logger.error(" <<<<<<<<<<<<<<<<<<<< Exception at convertStringtoSqlDate:: {}",e);
		}
		logger.info("*************** End of DateAndTimeUtils.convertStringtoSqlDate ***************");
		return parsedDate;
	}
	
	public static String convertSqlDateToString(Date date,DateFormatEnum dateFormat)	{
		logger.info("*************** Start of DateAndTimeUtils.convertSqlDateToString ***************");
		String formattedDate = null;
		try	{
			DateFormat format = new SimpleDateFormat(dateFormat.name());
			formattedDate = format.format(new java.util.Date(date.getTime()));
		}
		catch(Exception e)	{
			logger.error(" <<<<<<<<<<<<<<<<<<<< Exception at convertSqlDateToString:: {}",e);
		}
		logger.info("*************** End of DateAndTimeUtils.convertSqlDateToString ***************");
		return formattedDate;
		
	}
	
	
	public static String convertLocalDateToString(LocalDate date,DateFormatEnum dateFormat)	{
		String formattedDate = null;
		if(date != null)	{
			logger.info("---------------------------> dateFormat:: {}",dateFormat.name());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat.name()); 
			formattedDate = date.format(formatter);
		}
		return formattedDate;
	}
	
	public static LocalDate convertStringToLocalDate(String formattedDate,DateFormatEnum dateFormat)	{
		LocalDate date = null;
		if(formattedDate != null)	{
			logger.info("-----------------------> formattedDate:: {}",formattedDate);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat.name()); 
			date = LocalDate.parse(formattedDate,formatter);
		}
		return date;
	}
}
