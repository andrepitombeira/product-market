/**
 * Excecao para produtos cuja venda ainda nao foram iniciadas
 */
package br.ufc.si.andre.excecoes;

public class VendaNaoIniciadaException extends IllegalArgumentException {

	public VendaNaoIniciadaException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
