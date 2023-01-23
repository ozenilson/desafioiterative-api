package br.com.arenacode.desafioiterative.config.exception;

import br.com.arenacode.desafioiterative.config.util.ExcessaoUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;

	public CustomException(String message, HttpStatus status) {
		this(message, status, null);
	}

	public CustomException(String message, HttpStatus status, Exception e) {
		super(message, e);
		this.status = status;
	}

	/**
	 * @return the code
	 */
	public HttpStatus getStatus() {
		return status;
	}




	public ResponseEntity<Object> getResponseEntity() {
		HttpStatus status = getStatus();

		String json = ExcessaoUtil.criar(getStatus(), super.getMessage());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<>(json, headers, status);
	}
}
