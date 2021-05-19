package br.com.fiap.cp02.exception;

public class CommitException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommitException(String msg) {
		super(msg);
	}
	
	public CommitException() {
		super("Erro ao efetuar o commit");
	}
	
}