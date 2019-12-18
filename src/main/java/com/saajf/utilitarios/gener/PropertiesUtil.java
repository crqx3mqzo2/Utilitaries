package com.saajf.utilitarios.gener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static PropertiesUtil miPropertiesLoader = null;

	/**
	 * @return the mipropertiesloader
	 */
	public static PropertiesUtil getPropertiesloader() {
		if (miPropertiesLoader == null) {
			miPropertiesLoader = new PropertiesUtil();
		}
		return miPropertiesLoader;
	}

	public Properties load(String fileName) {
		Properties prop = new Properties();
		InputStream im = null;
		try {
			im = findFile(fileName);
			prop.load(im);
		} catch (IOException ignore) {
		} finally {
			if (im != null) {
				try {
					im.close();
				} catch (IOException ignore) {
				}
			}
		}
		return prop;
	}

	public Properties load(String directoryName, String fileName) {
		Properties prop = new Properties();
		InputStream im = null;
		try {
			im = findFile(directoryName, fileName);
			prop.load(im);
		} catch (IOException ignore) {
		} finally {
			if (im != null) {
				try {
					im.close();
				} catch (IOException ignore) {
				}
			}
		}
		return prop;
	}

	private InputStream findFile(String fileName) throws FileNotFoundException {
		InputStream im = findInWorkingDirectory(fileName);
		if (im == null)
			im = findInClasspath(fileName);
		if (im == null)
			im = findInSourceDirectory(fileName);
		if (im == null)
			throw new FileNotFoundException(String.format("File %s not found", fileName));
		return im;
	}

	private InputStream findFile(String directoryName, String fileName) throws FileNotFoundException {
		InputStream im = findInPrivateDirectory(directoryName, fileName);
		if (im == null)
			throw new FileNotFoundException(String.format("File %s not found", fileName));
		return im;
	}

	private InputStream findInSourceDirectory(String fileName) {
		try {
			return new FileInputStream("src/main/resources/" + fileName);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	private InputStream findInPrivateDirectory(String directoryName, String fileName) {
		try {
			return new FileInputStream(directoryName + fileName);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	private InputStream findInClasspath(String fileName) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
	}

	private InputStream findInWorkingDirectory(String fileName) {
		try {
			return new FileInputStream(System.getProperty("user.dir") + fileName);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	/*
	 * public static void main (String args[]) {
	 * System.out.println(System.getProperty("user.dir")); }
	 */

}
