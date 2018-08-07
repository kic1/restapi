package com.nalanhi.common.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**  
 * @author       임정채
 * @since        2014.08.20
 * @description  날짜 관련 유틸
 * @history
 *       
 *  수정일                수정자              수정내용
 *  ----------   ---------   -------------------------------
 *  2014.08.20      임정채              최초생성	
 *  2014.09.19   임정채              포멧 상수 추가
 *  2014.09.29   임정채              포멧 상수 추가(dd)
 *****************************************************************************************************/
public class UDate {

	public final static String PREFIX_FORMAT_YYYY              = "yyyy";              		/** 2014              		*/
	public final static String PREFIX_FORMAT_MM                = "MM";               		/** 01                		*/  
	public final static String PREFIX_FORMAT_DD                = "dd";                		/** 01                		*/
	public final static String PREFIX_FORMAT_YYYYMM            = "yyyyMM";            		/** 201312            		*/  
	public final static String PREFIX_FORMAT_YYYYMMDD          = "yyyyMMdd";          		/** 20131231          		*/  
	public final static String PREFIX_FORMAT_YYYYMMDDHHMMSS    = "yyyyMMddHHmmss";    		/** 20131231120303    		*/  
	public final static String PREFIX_FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS"; 		/** 20131231120303123 		*/
	public final static String PREFIX_FORMAT_YYYY_MM_DD        = "yyyy.MM.dd";        		/** 2013.12.31        		*/
	public final static String PREFIX_FORMAT_YYYY_MM_DD2       = "yyyy-MM-dd";        		/** 2013-12-31        		*/
	public final static String PREFIX_FORMAT_YYYY_MM_DD_HMS    = "yyyy.MM.dd HH:mm:ss";		/** 2013.12.31 12:03:03		*/
	public final static String PREFIX_FORMAT_YYYY_MM_DD_HMS2   = "yyyy-MM-dd HH:mm:ss";		/** 2013-12-31 12:03:03		*/
	public final static String PREFIX_FORMAT_YYYY_MM_DD_HMS3   = "yyyy년MM월dd일 HH:mm:ss";	/** 2013년12월31일 12:03:03	*/

	/**
	 * 현재 날짜를 반환한다.
	 * <br><br>
	 * 
	 * @return         현재 날짜 yyyymmdd
	 ********************************************************************************************/
	public static String getToday() {
		return getDate(PREFIX_FORMAT_YYYYMMDD);
	}
	
	/**
	 * 현재 날짜를 반환한다.
	 * <br><br>
	 * 
	 * @param  _format 해당 날짜 포멧
	 * @return         해당 날짜
	 ********************************************************************************************/
	public static String getDate(String _format) {
				
		return new SimpleDateFormat(_format).format(new Date());
	}
	
	/**
	 * 날짜로 변환해서 반환한다.
	 * <br><br>
	 * 
	 * @param  _format 해당 날짜 포멧
	 * @param  _time   해당 날짜 시간
	 * @return         해당 날짜 시간
	 ********************************************************************************************/
	public static String getConvertTime(String _format, long _time) {
				
		return new SimpleDateFormat(_format).format(new Date(_time));
	}
	
	/**
	 * 날짜로 변환해서 반환한다.
	 * <br><br>
	 * 
	 * @param  _format 해당 날짜 포멧
	 * @param  _time   해당 날짜 시간
	 * @return         해당 날짜 시간
	 ********************************************************************************************/
	public static String getConvertTime(String _format, Date _date) {
				
		return new SimpleDateFormat(_format).format(_date);
	}
	
	/**
	 * 해당 날짜의 더한 날짜를 반환한다.
	 * <br><br>
	 * 
	 * @param  _format 해당 날짜 포멧
	 * @param  _date   해당 날짜
	 * @param  _day    더한 날짜
	 * @return         계산 된 날짜
	 *********************************************************************************/
	public static String getDate(String _format, String _date, int _day) {
				
		SimpleDateFormat format      = new SimpleDateFormat(_format);
		Calendar         calendar    = Calendar.getInstance();
		
		try                    { calendar.setTime(format.parse(_date));	}
		catch(ParseException e){ e.printStackTrace();                   }
		
		calendar.add(Calendar.DATE, _day);
		
		
		return new SimpleDateFormat(_format).format(calendar.getTime());
	}
}
