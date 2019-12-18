package com.saajf.utilitarios.dtos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.saajf.utilitarios.excep.CustomApplicationException;
import com.saajf.utilitarios.excep.CustomRuntimeException;

public class RespuestaListaBuilder<T> {

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto> buildRespuestaPositiva(
			List<T> responseListaValor) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto>(
				(new ResponseGenericoDto<T>()).responseConsultarDto(responseListaValor), HttpStatus.OK);
	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto> buildRespuestaControlada(
			CustomApplicationException crtEX) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto>(
				(new ResponseGenericoDto<T>()).responseConsultarDto(new ArrayList<T>(), crtEX.getMessage()),
				HttpStatus.PARTIAL_CONTENT);
	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto> buildRespuestaNoControlada(
			CustomRuntimeException crtEX) {
		crtEX.printStackTrace();
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto>(
				(new ResponseGenericoDto<T>()).responseConsultarDto(new ArrayList<T>(), crtEX.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}