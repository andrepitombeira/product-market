/**
 * Classe para os Produtos Novos
 */
package br.ufc.si.andre.produto;

import br.ufc.si.andre.excecoes.LanceAbaixoDoValorException;
import br.ufc.si.andre.excecoes.LancesExcedidosException;
import br.ufc.si.andre.excecoes.VendaNaoIniciadaException;

public class ProdutoNovo extends Produto {
	public double lancesMaximo;

	/**
	 * Construtor
	 * 
	 * @param codigo
	 * @param descricao
	 * @param localizacaoDoProduto
	 * @param fabricante
	 * @param dataDeInicioDaVenda
	 * @param dataDeConclusaoDaVenda
	 * @param valorAtual
	 * @param lancesMaximo
	 */
	public ProdutoNovo(double codigo, String descricao,
			String localizacaoDoProduto, String fabricante,
			double dataDeInicioDaVenda, double dataDeConclusaoDaVenda,
			double valorAtual, double lancesMaximo, double codigoDoVendedor) {
		super(codigo, descricao, localizacaoDoProduto, fabricante,
				dataDeInicioDaVenda, dataDeConclusaoDaVenda, valorAtual,
				codigoDoVendedor);
		this.lancesMaximo = lancesMaximo;

	}

	public double getlancesMaximo() {
		return lancesMaximo;
	}

	/**
	 * Metodo que dar um desconto ao cliente. O desconto varia conforme o valor
	 * do produto.
	 * 
	 * @param valor
	 */
	public double desconto(double valor) {
		if (valor > 0 && valor <= 100) {
			return this.valorAtual -= (this.valorAtual * 0.05);
		} else if (valor >= 101 && valor <= 200) {
			return this.valorAtual -= (this.valorAtual * 0.1);
		} else if (valor >= 201 && valor <= 400) {
			return this.valorAtual -= (this.valorAtual * 0.15);
		} else {
			return this.valorAtual -= (this.valorAtual * 0.2);
		}

	}

	/**
	 * Metodo que efetua um lance
	 */

	public void efetuarLance(double lance, double codCliente) {
		this.quantidadeDeLancesOfertados++;
		setCodigoDoComprador(codCliente);
		if (getStatusProduto() == 1) {
			if (getContadorLances() < getlancesMaximo()) {
				if (lance > this.valorAtual) {
					this.valorAtual = lance;
				} else
					throw new LanceAbaixoDoValorException(
							"O Seu lance foi Inferior ao Valor do Produto, Tente um Lance Maior");

			} else
				throw new LancesExcedidosException(
						"Desculpe, a Quantidade de Lances Permitidos foi Esgotada ");
			setStatusProduto(2);

		} else
			throw new VendaNaoIniciadaException(
					"Este Produto ainda nao esta Disponivel para Venda, inicie Primeiro a Venda");
	}
}
