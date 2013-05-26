/**
 * Excecao para lances que sao abaixo do valor do produto
 */
package br.ufc.si.andre.excecoes;

public class LanceAbaixoDoValorException extends IllegalArgumentException {

    public LanceAbaixoDoValorException(String message) {
        super(message);
    }
}
