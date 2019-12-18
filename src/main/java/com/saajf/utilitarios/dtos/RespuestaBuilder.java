package com.saajf.utilitarios.dtos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.saajf.utilitarios.excep.CustomApplicationException;
import com.saajf.utilitarios.excep.CustomRuntimeException;

public class RespuestaBuilder<T extends Object> {

	// final Class<T> typeParameterClass;
	//
	// public ResponseValorBuilder(Class<T> typeParameterClass) {
	// this.typeParameterClass = typeParameterClass;
	// }

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaPositiva(T responseValor) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>(
				(new ResponseGenericoDto<T>()).responseConsultar2Dto(responseValor), HttpStatus.OK);

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaControlada(String mensaje) {
		// try {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>(
				(new ResponseGenericoDto<T>()).responseConsultar2Dto(new EmptyJsonResponse(), mensaje),
				HttpStatus.PARTIAL_CONTENT);
		// } catch (InstantiationException | IllegalAccessException e) {
		// return respuestaNoControlada(e);
		// }

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaControlada(
			CustomApplicationException crtEX) {
		// try {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>(
				(new ResponseGenericoDto<T>()).responseConsultar2Dto(new EmptyJsonResponse(), crtEX.getMessage()),
				HttpStatus.PARTIAL_CONTENT);
		// } catch (InstantiationException | IllegalAccessException e) {
		// return respuestaNoControlada(e);
		// }

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaNoControlada(
			CustomRuntimeException crtEX) {
		crtEX.printStackTrace();
		return new ResponseEntity<>(HttpStatus.PARTIAL_CONTENT);

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> respuestaNoControlada(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}