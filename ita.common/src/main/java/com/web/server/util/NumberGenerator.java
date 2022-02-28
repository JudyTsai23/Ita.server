package com.web.server.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 流水號、UUID 產生器
 */
public class NumberGenerator {

	/**
	 * 產生當前日期時間
	 */
	public static String getStrDate() {
		Date currentTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		String dateStr = sdf.format(currentTime);
		return dateStr;
	}

	/**
	 * 由當前日期時間+3位隨機數 生成流水號
	 * e.g. 2202272048 = 2022/02/27 20:48
	 */
	public static String getSerialNum() {
		String date = getStrDate();
		int num = (int) (Math.random() * 900) + 100;
		String serialNum = date.substring(2) + num;
		return serialNum;
	}

	/**
	 * 產生UUID
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		return uuidStr;
	}
}
