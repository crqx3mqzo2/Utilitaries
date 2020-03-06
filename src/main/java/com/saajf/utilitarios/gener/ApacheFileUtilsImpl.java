package com.saajf.utilitarios.gener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Implementaciòn de Apache FileUtils. Se muestra como usar la librerìa de
 * Apache la cual trabaja con archivos y directorios. En el main encontramos
 * ejemplos de lectura, escritura, copia, creación, eliminación, enumeración y
 * obtención del tamaño de los archivos.
 */
public class ApacheFileUtilsImpl {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		try {
			File file = new File("src/main/resources/myFilesExample.txt");
			FileUtils.touch(file);
			if (file.exists()) {
				System.out.println("Existe documento");
			} else
				System.out.println("No existe documento");
			FileUtils.deleteQuietly(file);
			if(!file.exists()) {
				System.out.println("Documento borrado con exito");
			}else
				System.out.println("Falló el borrado del documento");
			
			File file1 = new File("src/main/resources/fichero1.txt");
			File file2 = new File("src/main/resources/fichero1_copia.txt");
			FileUtils.copyFile(file1, file2);
			if(FileUtils.contentEquals(file1, file2)) {
				System.out.println("los ficheros son iguales o tienen el mismo contenido");
			} else
				System.out.println("los ficheros no son iguales o no tienen el mismo contenido");
		
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
