package com.walye.utils;

import javax.servlet.http.HttpServletRequest;

public class IpUtils {
	public static String getIp(HttpServletRequest req) {
		String ipAddress = req.getHeader("x-forwarded-for");
		if (StringUtils.isNotNull(ipAddress) && !"unknown".equalsIgnoreCase(ipAddress)) {
			String after = ipAddress.trim();
			ipAddress = null;
			while ((StringUtils.isNull(ipAddress)|| "unknown".equalsIgnoreCase(ipAddress))&& StringUtils.isNotNull(after)&& !"unknow".equalsIgnoreCase(after)) {
				int index = after.indexOf(',');
				if (index > 0) {
					ipAddress = after.substring(0, index);
					after = after.substring(index + 1);
				}
				else{
					ipAddress=after;
					after=null;
				}
			}
		}
		if(StringUtils.isNull(ipAddress)|| "unknown".equalsIgnoreCase(ipAddress)){
			ipAddress = req.getHeader("client_ip");
			if(StringUtils.isNotNull(ipAddress))
				ipAddress=ipAddress.trim();
		}
		
		if(StringUtils.isNull(ipAddress)|| "unknown".equalsIgnoreCase(ipAddress)){
			ipAddress = req.getRemoteAddr();
			if(StringUtils.isNotNull(ipAddress))
				ipAddress=ipAddress.trim();
		}
		
		
		if(StringUtils.isNull(ipAddress)|| "unknown".equalsIgnoreCase(ipAddress))
			return null;
		else
			return ipAddress;
			
	}

}
