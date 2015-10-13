package com.walye.utils;

import org.apache.commons.lang.StringUtils;

public class MaterialUrlResolver {
	public static String resolveVideoCodeId(String url) {
		String[] items = StringUtils.split(url, "_");
		if (items.length < 3) {
			return null;
		}

		String codeSuffix = items[2];
		String[] codeItems = StringUtils.split(codeSuffix, ".html");
		return codeItems[0];
	}

	public static String resolveShowCodeId(String url) {
		return resolveVideoCodeId(url);
	}
	
	public static String resolveLaifengCodeId(String url) {
		return StringUtils.substring(url, StringUtils.lastIndexOf(url, "/") + 1);
	}

	public static void main(String[] args) {
		String url = "http://v.youku.com/v_show/id_XODA2OTkwMDU2";
		System.out.println(resolveVideoCodeId(url));
		String showUrl = "http://www.youku.com/show_page/id_z0375f6ec568a11e4a080.html";
		System.out.println(resolveShowCodeId(showUrl));
		String laifengUrl = "www.laifeng.com/room/4156";
		System.out.println(resolveLaifengCodeId(laifengUrl));
	}
}
