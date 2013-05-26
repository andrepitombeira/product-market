package br.ufc.si.andre.produto;

public class ProdutoUsado extends Produto {
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
	 */
	public ProdutoUsado(double codigo, String descricao,
			String localizacaoDoProduto, String fabricante,
			double dataDeInicioDaVenda, double dataDeConclusaoDaVenda,
			double valorAtual, double codigoDoVendedor) {
		super(codigo, descricao, localizacaoDoProduto, fabricante,
				dataDeInicioDaVenda, dataDeConclusaoDaVenda, valorAtual,
				codigoDoVendedor);
		// TODO Auto-generated constructor stub
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
		}

		else {
			return this.valorAtual -= (this.valorAtual * 0.2);
		}
	}

	/**
    *Metodo que encerra a venda de um produto 
    */
	
	public void encerrarVenda() {
		setStatusProduto(2);
	}

}
