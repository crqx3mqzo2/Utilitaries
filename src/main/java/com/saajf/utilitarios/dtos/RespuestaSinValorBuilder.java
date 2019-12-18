package com.saajf.utilitarios.dtos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.saajf.utilitarios.excep.CustomApplicationException;
import com.saajf.utilitarios.excep.CustomRuntimeException;
import com.saajf.utilitarios.gener.ConstantesCoreUtil.ConstantesRespustasRest;

public class RespuestaSinValorBuilder<T> {

	public ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto> buildRespuestaPositiva(String mensaje) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto>(
				(new ResponseGenericoDto<T>()).responseGuardarDto(mensaje), HttpStatus.OK);

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto> buildRespuestaControlada(
			CustomApplicationException crtEX) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto>(
				(new ResponseGenericoDto<T>()).responseGuardarDto(crtEX.getMessage()), HttpStatus.PARTIAL_CONTENT);
	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto> buildRespuestaNoControlada(
			CustomRuntimeException crtEX) {
		crtEX.printStackTrace();
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto> buildRespuestaControlada(String mensaje) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto>(
				(new ResponseGenericoDto<T>()).responseGuardarDto(mensaje), HttpStatus.PARTIAL_CONTENT);
	}

	public ResponseEntity<Object> buildRespuestaOk0() {
		return new ResponseEntity<>(new ResponseGenericoDto<>().responseConsultar2Dto("",
				ConstantesRespustasRest.CONST_RESPUESTA_WS_EXITOSO), HttpStatus.OK);
	}

	public ResponseEntity<Object> buildRespuestaError() {
		return new ResponseEntity<>(new ResponseGenericoDto<>().responseConsultar2Dto("",
				ConstantesRespustasRest.CONST_RESPUESTA_WS_ERROR_PARAMETROS), HttpStatus.PARTIAL_CONTENT);
	}

	public ResponseEntity<Object> buildRespuestaNoControlada() {
		return new ResponseEntity<>(new ResponseGenericoDto<>().responseConsultar2Dto("",
				ConstantesRespustasRest.CONST_RESPUESTA_WS_ERROR_INTENRO), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}