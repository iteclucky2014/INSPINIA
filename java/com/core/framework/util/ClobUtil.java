package com.core.framework.util;

import org.apache.commons.lang3.StringUtils;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;

/**
 * 大文本操作工具类
 * 
 * @author lucky
 * 
 */
public class ClobUtil {

	/**
	 * 获得字符串
	 * 
	 * @param clob java.sql.Clob
	 * 
	 * @return 字符串
	 */
	public static String getString(Clob clob) {
		StringBuffer s = new StringBuffer();
		if (clob != null) {
			try {
				BufferedReader bufferRead = new BufferedReader(clob.getCharacterStream());
				try {
					String str;
					while ((str = bufferRead.readLine()) != null) {
						s.append(str);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s.toString();
	}

	/**
	 * 获得Clob
	 * 
	 * @param str 字符串
	 * 
	 * @return java.sql.Clob
	 */
	public static Clob getClob(String str) {
		Clob c = null;
		try {
			if (!StringUtils.isBlank(str)) {
				c = new SerialClob(str.toCharArray());
			}
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

}
