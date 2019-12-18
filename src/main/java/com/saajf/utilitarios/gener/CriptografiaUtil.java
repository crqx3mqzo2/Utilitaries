package com.saajf.utilitarios.gener;

import java.util.Base64;

public class CriptografiaUtil {

	public static String encode(byte[] arg) {
		return Base64.getEncoder().encodeToString(arg);
	}

	public static byte[] decode(String arg) {
		return Base64.getDecoder().decode(arg);
	}

}