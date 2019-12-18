package com.saajf.utilitarios.gener;

public class ConstantesCoreUtil {

	public static final String CONST_PATH_PROPIEDADES = "application.properties";
	public static final String PATH_PROPERTIES = "PATH.properties";
	public static final String KEY_PATH_PROPERTIES_OFV = "path.app";
	public static final String KEY_FILE_PROPERTIES_OFV = "file.app";

	public static class ConstantesBoolean {
		public static final Integer TRUE = 1;
		public static final Integer FALSE = 0;
	}

	public static class ConstantesDominiosDB {
		public static final String DOMINIO_TIPO_CONTRATO = "TIPO_CONTRATO";
		public static final String DOMINIO_EVENTOS_NOTIFICACION = "EVENTOS_NOTIFICACION";
		public static final String DOMINIO_ESTADOS_NOTIFICACION = "ESTADOS_NOTIFICACION";

	}

	public static class ConstantesSimbolos {
		public static final String GUION = "-";
		public static final String SLASH = "/";
		public static final String BACKSLASH = "\\";
		public static final String VACIO = "";

	}

	public static class ConstantesURLInternas {
		public static final String URL_INTERNAS_CONSTRUCTORAS = "url.internas.constructoras";
		public static final String URL_INTERNAS_PROYECTOSPORCONSTRUCTORA = "url.internas.proyectosPorConstructora";
		public static final String URL_INTERNAS_CONVERTIDOR_DOCUMENTO_DOCX_PDF = "url.internas.convertidor-documento.docx-pdf";

	}

	public static class ConstantesRespustasRest {
		public static final String CONST_RESPUESTA_WS_EXITOSO = "Ejecución exitosa";
		public static final String CONST_RESPUESTA_WS_ERROR_PARAMETROS = "Error en los párametros";
		public static final String CONST_RESPUESTA_WS_ERROR_INTENRO = "Error interno";
	}

}
