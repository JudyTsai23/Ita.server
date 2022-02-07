package com.web.server.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 產生當前日期時間
 */
public class DateTimeGenerator {

	// YYYYMMdd
	private static DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("uuuuMMdd")
			.withZone(ZoneId.of("Asia/Taipei"));

	// YYYY/MM/dd
	private static DateTimeFormatter yyyy_MM_dd = DateTimeFormatter.ofPattern("uuuu/MM/dd")
			.withZone(ZoneId.of("Asia/Taipei"));

	// HHmmssSSS
	private static DateTimeFormatter HHmmss = DateTimeFormatter.ofPattern("HHmmss")
			.withZone(ZoneId.of("Asia/Taipei"));

	// HH:mm:ss.SSS
	private static DateTimeFormatter HH_mm_ss = DateTimeFormatter.ofPattern("HH:mm:ss")
			.withZone(ZoneId.of("Asia/Taipei"));

	// YYYYMMddHHmmssSSS
	private static DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("uuuuMMddHHmmss")
			.withZone(ZoneId.of("Asia/Taipei"));

	// YYYY/MM/dd-HH:mm:ss.SSS
	private static DateTimeFormatter yyyy_MM_dd_HH_mm_ss = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss")
			.withZone(ZoneId.of("Asia/Taipei"));

	/**
	 * 取得當前時間
	 * @return HHmmss
	 */
	public static String getCurrentTime_HHmmss() {
		String formatTime = HHmmss.format(LocalDateTime.now());
		return formatTime;
	}

	/**
	 * 取得當前時間
	 * @return HH:mm:ss
	 */
	public static String getCurrentTime_HH_mm_ss() {
		String formatTime = HH_mm_ss.format(LocalDateTime.now());
		return formatTime;
	}

	/**
	 * 取得當前日期
	 * @return YYYYMMdd
	 */
	public static String getCurrentDate_YYYYMMdd() {
		String formatDate = yyyyMMdd.format(LocalDate.now());
		return formatDate;
	}

	/**
	 * 取得當前日期
	 * @return YYYY/MM/dd
	 */
	public static String getCurrentDate_YYYY_MM_dd() {
		String formatDate = yyyy_MM_dd.format(LocalDate.now());
		return formatDate;
	}
	
	/**
	 * 取得當前日期時間
	 * @return YYYYMMdd HHmmss
	 */
	public static String getCurrentDate_YYYYMMdd_HHmmss() {
		String formatDate = yyyyMMddHHmmss.format(LocalDate.now());
		return formatDate;
	}
	
	/**
	 * 取得當前日期時間
	 * @return YYYY/MM/dd HH:mm:ss
	 */
	public static String getCurrentDate_YYYY_MM_dd_HH_mm_ss() {
		String formatDate = yyyy_MM_dd_HH_mm_ss.format(LocalDate.now());
		return formatDate;
	}

	/**
	 * 轉換時間string為lovalTime
	 * @param hhmm
	 * @return
	 */
//	public static LocalTime getLocalTimeFromHHmm(String hhmm) {
//		LocalTime localTime = LocalTime.parse(hhmm, DateTimeFormatter.ofPattern("HHmm"));
//		return localTime;
//	}
}
