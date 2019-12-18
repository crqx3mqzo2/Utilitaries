package com.saajf.utilitarios.srv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@EnableKafka
@Component
public class LogInterceptor implements HandlerInterceptor {

	public static final Logger logger = Logger.getLogger(LogInterceptor.class);

	/**
	 * Método encargado de realizar la auditoría de los consumos de los recursos del
	 * BackEnd tras haberse hecho el consumo de los mismos.
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		String mensaje = "{";

		try {
			String metodo = "\"metodoHttp\":" + arg0.getMethod();
			StringBuffer url = arg0.getRequestURL();
			mensaje += "\"url\":" + url + ",";
			HttpServletRequest httpRequest = (HttpServletRequest) arg0;
			String idUsuario = httpRequest.getHeader("idUsuario");
			// Obtenemos la ip desde la cual se está accediendo al recurso del BackEnd.
			String ip = "\"ipUsuario\":" + arg0.getRemoteAddr();
			String urlPath = "\"urlPath\":" + httpRequest.getHeader("urlPath");

			mensaje += ip + ", " + "\"idUsuario:" + idUsuario + " \"metodo:" + metodo + " \"urlPath:" + urlPath
					+ " \"url:" + url + "}";
			logger.info(mensaje);
			// kafkaTemplate.send(topic, mensaje);

		} catch (Exception e) {
			logger.error("Se Produjo el siguiente error: " + e.getMessage());
		}
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		return true;
	}
}
