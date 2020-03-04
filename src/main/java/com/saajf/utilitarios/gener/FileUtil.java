package com.saajf.utilitarios.gener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import com.saajf.utilitarios.excep.CustomRuntimeException;

public class FileUtil {

	public static byte[] inputstream(String pathFile) throws CustomRuntimeException {
		java.io.File fichero = null;
		FileInputStream ficheroStream = null;
		byte contenido[] = null;
		fichero = new java.io.File(pathFile);
		contenido = new byte[(int) fichero.length()];
		try {
			ficheroStream = new FileInputStream(fichero);
		} catch (FileNotFoundException e) {
			throw new CustomRuntimeException("No se pudo encontrar del servidor el archivo ' ", pathFile);
		}
		try {
			ficheroStream.read(contenido);
			ficheroStream.close();
		} catch (IOException e) {
			throw new CustomRuntimeException("No se pudo abrir del servidor el archivo ' ", pathFile);
		}
		return contenido;

	}

//	public static  inputstream(String pathFile) throws CustomRuntimeException {
//		java.io.File fichero = null;
//		FileInputStream ficheroStream = null;
//		byte contenido[] = null;
//		fichero = new java.io.File(pathFile);
//		contenido = new byte[(int) fichero.length()];
//		try {
//			ficheroStream = new FileInputStream(fichero);
//		} catch (FileNotFoundException e) {
//			throw new CustomRuntimeException("No se pudo encontrar del servidor el archivo ' ", pathFile);
//		}
//		try {
//			ficheroStream.read(contenido);
//			ficheroStream.close();
//		} catch (IOException e) {
//			throw new CustomRuntimeException("No se pudo abrir del servidor el archivo ' ", pathFile);
//		}
//		return contenido;
//
//	}

	public static void outputstream(String pathFile, byte[] arg) throws CustomRuntimeException {
		FileOutputStream ficheroStream = null;
		try {
			ficheroStream = new FileOutputStream(pathFile);
			ficheroStream.write(arg);
			ficheroStream.close();
		} catch (IOException e) {
			throw new CustomRuntimeException("No se pudo crear en el servidor el archivo '", pathFile + "'");
		}

	}

	public static void crearDirectorio(Path filaLocal) throws IOException {
		if (Files.notExists(filaLocal)) {
			Files.createDirectory(filaLocal);
		}
	}

	public static File guardarAnexoEnRutaTemporalDelServer(MultipartFile binario, File fila) {
		try {
			byte[] arregloByte = binario.getBytes();
			OutputStream outFile = new FileOutputStream(fila);
			outFile.write(arregloByte);
			outFile.close();
			return fila;
		} catch (Exception e) {
			return null;
		}
	}

	public static File guardarAnexoEnRutaTemporalDelServer(byte[] binario, File fila) {
		try {
			byte[] arregloByte = binario;
			OutputStream outFile = new FileOutputStream(fila);
			outFile.write(arregloByte);
			outFile.close();
			return fila;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @deprecated use {@link #deleteFile(String)}
	 * @param pathFile
	 */
	public static void deleteLinux(String pathFile) {
		File f = new File(pathFile);
		try {
			java.lang.Runtime.getRuntime().exec("rm -f " + f.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @deprecated use {@link #deleteFile(String)}
	 * @param pathFile
	 * @return
	 */
	public static boolean deleteWin(String pathFile) {
		File f = new File(pathFile);
		boolean isSuccessful = f.delete();
		return isSuccessful;
	}

	/**
	 * Elimina el archivo corespondiente.<br>
	 * este metodo identifica el SO en el cual se desea eliminar el archivo. De ese
	 * modo ejecuta el comando mas adecuado
	 * 
	 * @param pathFile
	 */
	public static void deleteFile(String pathFile) {
		String OS = System.getProperty("os.name").toLowerCase();
		if ((OS.indexOf("win") >= 0)) {
			deleteWin(pathFile);
		}
		if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {
			deleteLinux(pathFile);
		}
	}

	public static void fileReader(String nameFile) throws IOException {
		FileReader fileReader = new FileReader(nameFile, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(fileReader);
		String a = null;
		while ((a = br.readLine()) != null) {
			System.out.println(a);
		}
		fileReader.close();
		br.close();
	}

	//revisar https://www.baeldung.com/java-buffered-reader
	
	public static BufferedReader bufferReader(String nameFile) throws IOException {
		FileReader fileReader = new FileReader(nameFile, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(fileReader);
		fileReader.close();
		return br;
	}

	public static BufferedReader bufferReader(String nameFile, Charset charset) throws IOException {
		FileReader fileReader = new FileReader(nameFile, charset);
		BufferedReader br = new BufferedReader(fileReader);
		fileReader.close();
		return br;
	}

	public static void main(String[] args) throws IOException {
		fileReader("C:\\EAI\\application.properties");
	}

}