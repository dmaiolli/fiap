package br.com.fiap.exception;

public class VeiculoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VeiculoNotFoundException() {
		super("Veiculo não encontrado");
	}
	
	public VeiculoNotFoundException(String msg) {
		super(msg);
	}

}
