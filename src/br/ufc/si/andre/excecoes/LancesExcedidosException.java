/**
 * Excecao para quantidade de lances excedidos
 */
package br.ufc.si.andre.excecoes;

public class LancesExcedidosException extends IllegalArgumentException {

	public LancesExcedidosException(String message) {
		super(message);
	}

}
