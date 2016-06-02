package cn.jikexueyuan.ubas.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Date May 25, 2015
 *
 * @Author dengjie
 *
 * @Note String util class
 */
public class StringUtil {

	/**
	 * format "yyyy-MM-dd HH:mm:ss" like 1426439855 to 2015-03-16 01:17:35
	 * 
	 * <br/>
	 * <br/>
	 * 
	 * format "HH" like 1426439855 to 01
	 * 
	 * @param date
	 * @return
	 */
	public static String unix2StringDate(String date, String dateFormat) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(Long.parseLong(date) * 1000);
	}

}
