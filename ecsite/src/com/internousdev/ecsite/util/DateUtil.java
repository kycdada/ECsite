/**
 *
 */
package com.internousdev.ecsite.util;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author internousdev
 *
 */
public class DateUtil {
	public String getDate(){
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date);
	}

}
