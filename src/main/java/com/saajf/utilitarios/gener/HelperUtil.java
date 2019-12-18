package com.saajf.utilitarios.gener;

import java.util.Collection;
import java.util.Map;

public class HelperUtil {

	public static boolean isNullOrEmpty(final Object o) {
		return o == null;
	}
	
	public static boolean esMayorAZero(Long o) {
		if(o > 0) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(final Collection<?> c) {
		return c == null || c.isEmpty();
	}

	public static boolean isNullOrEmpty(final Map<?, ?> m) {
		return m == null || m.isEmpty();
	}

}
