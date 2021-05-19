package br.com.fiap.cp02.exception;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String msg) {
		super(msg);
	}

	public EntityNotFoundException() {
		super("Entidade não foi encontrada");
	}
}