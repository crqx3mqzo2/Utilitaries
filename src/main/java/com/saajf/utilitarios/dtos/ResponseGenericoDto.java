package com.saajf.utilitarios.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseGenericoDto<T> implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public class ResponseConsultarDto extends UnValorDto {
		private static final long serialVersionUID = 1L;

		private List<T> lValores;

		public ResponseConsultarDto(List<T> lValores, String mensaje) {
			super(mensaje);
			this.lValores = lValores;
		}

		public ResponseConsultarDto(List<T> lValores) {
			this.lValores = lValores;
		}

		public ResponseConsultarDto(String mensaje) {
			super(mensaje);
		}

		/**
		 * @return the lValores
		 */
		@JsonProperty("respuesta")
		public List<T> getlValores() {
			return lValores;
		}

		/**
		 * @param lValores
		 *            the lValores to set
		 */
		public void setlValores(List<T> lValores) {
			this.lValores = lValores;
		}

	}

	public class ResponseConsultar2Dto extends UnValorDto {
		private static final long serialVersionUID = 1L;

		private T lValor;

		public ResponseConsultar2Dto(T lValor, String mensaje) {
			super(mensaje);
			this.lValor = lValor;
		}

		public ResponseConsultar2Dto(T lValor) {
			this.lValor = lValor;
		}

		public ResponseConsultar2Dto(String mensaje) {
			super(mensaje);

		}

		@SuppressWarnings("unchecked")
		public ResponseConsultar2Dto(EmptyJsonResponse lValor, String mensaje) {
			super(mensaje);
			this.lValor = (T) lValor;
		}

		/**
		 * @return the lValores
		 */
		@JsonProperty("respuesta")
		public T getlValor() {
			return lValor;
		}

		/**
		 * @param lValores
		 *            the lValores to set
		 */
		public void setlValor(T lValor) {
			this.lValor = lValor;
		}

	}

	public class ResponseGuardarDto extends UnValorDto {
		private static final long serialVersionUID = 1L;

		public ResponseGuardarDto(String mensaje) {
			super(mensaje);
		}

	}

	public ResponseGuardarDto responseGuardarDto(String mensaje) {
		// TODO Auto-generated method stub
		return new ResponseGuardarDto(mensaje);
	}

	public ResponseConsultarDto responseConsultarDto(List<T> lValores) {
		// TODO Auto-generated method stub
		return new ResponseConsultarDto(lValores);
	}

	public ResponseConsultarDto responseConsultarDto(List<T> lValores, String mensaje) {
		// TODO Auto-generated method stub
		return new ResponseConsultarDto(lValores, mensaje);
	}

	public ResponseConsultar2Dto responseConsultar2Dto(T lValor) {
		// TODO Auto-generated method stub
		return new ResponseConsultar2Dto(lValor);
	}

	public ResponseConsultar2Dto responseConsultar2Dto(T lValor, String mensaje) {
		// TODO Auto-generated method stub
		return new ResponseConsultar2Dto(lValor, mensaje);
	}

	public ResponseConsultar2Dto responseConsultar2Dto(EmptyJsonResponse lValor, String mensaje) {
		// TODO Auto-generated method stub
		return new ResponseConsultar2Dto(lValor, mensaje);
	}

}
