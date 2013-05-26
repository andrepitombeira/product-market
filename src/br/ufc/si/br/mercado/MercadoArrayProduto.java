/**
 * Classe repositorio de produtos
 */
package br.ufc.si.br.mercado;

import java.util.ArrayList;

import br.ufc.si.andre.interfac.RepositorioProduto;
import br.ufc.si.andre.negocio.Sistema;
import br.ufc.si.andre.produto.Produto;

public class MercadoArrayProduto implements RepositorioProduto {

	ArrayList<Produto> produtos = new ArrayList<Produto>();
	Sistema sistema = new Sistema();

	/**
	 * Metodo que adiciona um produto
	 */

	public void adicionarProduto(Produto p) {
		produtos.add(p);
	}

	/**
	 * Metodo que exclui um produto
	 */
	public void excluirProduto(double codigo) {
		int index = sistema.buscaProduto(codigo);
		produtos.remove(index);

	}

}
