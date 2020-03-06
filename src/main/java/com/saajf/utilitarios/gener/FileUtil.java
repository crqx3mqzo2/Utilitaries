package com.saajf.utilitarios.gener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import com.saajf.utilitarios.excep.CustomRuntimeException;

/**
 * The Class FileUtil.
 */
public class FileUtil {

	/**
	 * Inputstream.
	 *
	 * @param pathFile the path file
	 * @return the byte[]
	 * @throws CustomRuntimeException the custom runtime exception
	 */
	public static byte[] inputstream(String pathFile) throws CustomRuntimeException {
		java.io.File fichero = null;
		FileInputStream ficheroInputStream = null;
		byte[] contentDimension = null;
		fichero = new java.io.File(pathFile);
		contentDimension = new byte[(int) fichero.length()];
		try {
			ficheroInputStream = new FileInputStream(fichero);
		} catch (FileNotFoundException e) {
			throw new CustomRuntimeException("No se pudo encontrar del servidor el archivo ' ", pathFile);
		}
		try {
			ficheroInputStream.read(contentDimension);
			ficheroInputStream.close();
		} catch (IOException e) {
			throw new CustomRuntimeException("No se pudo abrir del servidor el archivo ' ", pathFile);
		}
		return contentDimension;

	}

	/**
	 * Inputstream.
	 *
	 * @param pathFile the path file
	 * @return the buffered input stream
	 */
	public static BufferedInputStream inputstream_(String pathFile) {
		java.io.File fichero = new java.io.File(pathFile);
		BufferedInputStream buf = null;
		try (InputStream is = new FileInputStream(fichero);
				OutputStream os = new FileOutputStream(fichero + ".copia")) {
			BufferedInputStream buf1 = new BufferedInputStream(is, (int) fichero.length());
			buf1.transferTo(os);
			buf = buf1;
		} catch (FileNotFoundException e) {
			throw new CustomRuntimeException("No se pudo encontrar del servidor el archivo ' ", pathFile);
		} catch (IOException e) {
			throw new CustomRuntimeException("No se pudo abrir del servidor el archivo ' ", pathFile);
		}
		return buf;

	}

	/**
	 * Outputstream.
	 *
	 * @param pathFile the path file
	 * @param arg the arg
	 * @throws CustomRuntimeException the custom runtime exception
	 */
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

	/**
	 * Crear directorio.
	 *
	 * @param filaLocal the fila local
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void crearDirectorio(Path filaLocal) throws IOException {
		if (Files.notExists(filaLocal)) {
			Files.createDirectory(filaLocal);
		}
	}

	/**
	 * Guardar anexo en ruta temporal del server.
	 *
	 * @param binario the binario
	 * @param fila the fila
	 * @return the file
	 */
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

	/**
	 * Guardar anexo en ruta temporal del server.
	 *
	 * @param binario the binario
	 * @param fila the fila
	 * @return the file
	 */
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
	 * Delete linux.
	 *
	 * @param pathFile the path file
	 * @deprecated use {@link #deleteFile(String)}
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
	 * Delete win.
	 *
	 * @param pathFile the path file
	 * @return true, if successful
	 * @deprecated use {@link #deleteFile(String)}
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
	 * @param pathFile the path file
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

	/**
	 * File reader.
	 *
	 * @param nameFile the name file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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

	// revisar https://www.baeldung.com/java-buffered-reader

	/**
	 * Buffer reader.
	 *
	 * @param nameFile the name file
	 * @return the buffered reader
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static BufferedReader bufferReader(String nameFile) throws IOException {
		FileReader fileReader = new FileReader(nameFile, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(fileReader);
		fileReader.close();
		return br;
	}

	/**
	 * Buffer reader.
	 *
	 * @param nameFile the name file
	 * @param charset the charset
	 * @return the buffered reader
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static BufferedReader bufferReader(String nameFile, Charset charset) throws IOException {
		FileReader fileReader = new FileReader(nameFile, charset);
		BufferedReader br = new BufferedReader(fileReader);
		fileReader.close();
		return br;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		fileReader("C:\\EAI\\application.properties");
	}

}