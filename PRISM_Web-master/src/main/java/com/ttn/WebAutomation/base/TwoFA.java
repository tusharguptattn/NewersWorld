package com.ttn.WebAutomation.base;

import org.jboss.aerogear.security.otp.Totp;

public class TwoFA {
	public static String  getTwoFactorCode() {
		Totp totp = new Totp("fr77 6cxh kzsk buda m3bw nngi qrv6 yxic");
		String twoFactorCode = totp.now();
		return twoFactorCode;
		
	}

}
