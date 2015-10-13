package com.walye.utils;

import java.util.Date;

public class StringUtils {

	/**
	 * 是否包含指定字符
	 *
	 * @param oraStr
	 * @param specificStr
	 * @return
	 */
	public static boolean containSpecificStr(String oraStr,String specificStr){
		if(oraStr.contains(specificStr)){
			return true;
		}

		return false;
	}

	/**
	 *
	 *
	 * @param source
	 * @return
	 */
	public static boolean isNotNull(String source) {
		if (source == null || "".equals(source))
			return false;

		return true;
	}

	public static boolean isNull(String source) {
		return !isNotNull(source);
	}
	/**
	 *
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean eq(String s1,String s2){

		if( s1 == null || s2 == null)return false;

		return s1.equals(s2);
	}
	/**
	 * 
	 * @param s1前台值
	 * @param s2数据库值
	 * @return
	 */
	public static boolean needUpdate(String s1,String s2){
		if(isNotNull(s1)&&!s1.equals(s2))
			return true;
		return false;
	}
	/**
	 * 
	 * @param s1前台值
	 * @param s2数据库值
	 * @return
	 */
	public static boolean needUpdate(String s1,Double s2){
		if(isNotNull(s1)&&!s2.equals(Double.parseDouble(s1)))
			return true;
		return false;
	}
	/**
	 * 
	 * @param s1前台值
	 * @param s2数据库值
	 * @return
	 */
	public static boolean needUpdate(Integer s1,Integer s2){
		if(s1!=null&&!s1.equals(s2))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param s1前台值
	 * @param s2数据库值
	 * @return
	 */
	public static boolean needUpdate(Double s1,Double s2){
		if(s1!=null&&!s1.equals(s2))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param s1前台值
	 * @param s2数据库值
	 * @return
	 */
	public static boolean needUpdate(Date s1,Date s2){
		if(s1.equals(s2))
			return false;
		return true;
	}

	
	/**
	 * 根据分割字符串获得字符串数组
	 * 
	 * @param str 原始字符串
	 * @param split 分割符
	 * @return
	 */
	public static String[] getStringArray(String str,String split){
		if(str == null || "".equals(str)) return new String[0];
		String strArr[] = str.split(split);
		return strArr;
	}
}
