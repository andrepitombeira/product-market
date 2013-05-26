/**
 * Interface para repositorio de produtos
 */
package br.ufc.si.andre.interfac;

import br.ufc.si.andre.produto.Produto;

public interface RepositorioProduto {

	public void adicionarProduto(Produto p);

	public void excluirProduto(double codigo);

}
