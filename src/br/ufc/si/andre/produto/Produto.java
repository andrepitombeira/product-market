/**
 * Classe abstrata de produtos
 */
package br.ufc.si.andre.produto;

import br.ufc.si.andre.excecoes.LanceAbaixoDoValorException;
import br.ufc.si.andre.excecoes.VendaNaoIniciadaException;

public abstract class Produto {
	/**
	 * Atributos
	 */
	protected double codigo;
	protected String descricao;
	protected String localizacaoDoProduto;
	protected String fabricante;
	protected double dataDeInicioDaVenda;
	protected double dataDeConclusaoDaVenda;
	protected int quantidadeDeLancesOfertados = 0;
	protected double valorAtual;
	protected double codigoDoVendedor;
	protected double codigoDoComprador;
	protected double statusProduto = 0;

	/**
	 * Construtor da classe
	 * 
	 * @param codigo
	 * @param descri�ao
	 * @param localiza�aoDoProduto
	 * @param fabricante
	 * @param dataDeInicioDaVenda
	 * @param dataDeConclusaoDaVenda
	 * @param valorAtual
	 */
	public Produto(double codigo, String descricao,
			String localizacaoDoProduto, String fabricante,
			double dataDeInicioDaVenda, double dataDeConclusaoDaVenda,
			double valorAtual, double codigoDoVendedor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.localizacaoDoProduto = localizacaoDoProduto;
		this.fabricante = fabricante;
		this.dataDeInicioDaVenda = dataDeInicioDaVenda;
		this.dataDeConclusaoDaVenda = dataDeConclusaoDaVenda;
		this.valorAtual = valorAtual;
		this.codigoDoVendedor = codigoDoVendedor;

	}

	/**
	 * Metodos geteres e seteres
	 * 
	 * @return
	 */

	public double getCodigo() {
		return codigo;
	}

	public void setCodigo(int cod) {
		codigo = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descri) {
		descricao = descri;
	}

	public String getLocalizacaoDoProduto() {
		return localizacaoDoProduto;
	}

	public void setLocalizacaoDoProduto(String localDoProd) {
		localizacaoDoProduto = localDoProd;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabric) {
		fabricante = fabric;
	}

	public double getDataDeInicioDaVenda() {
		return dataDeInicioDaVenda;
	}

	public void setDataDeInicioDaVenda(double dataDeIniDaVenda) {
		dataDeInicioDaVenda = dataDeIniDaVenda;
	}

	public double getDataDeConclusaoDaVenda() {
		return dataDeConclusaoDaVenda;
	}

	public void setDataDeConclusaoDaVenda(double dataDeConcluDaVenda) {
		dataDeConclusaoDaVenda = dataDeConcluDaVenda;
	}

	public double getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(double valAtual) {
		valorAtual = valAtual;
	}

	public double getCodigoDoVendedor() {
		return codigoDoVendedor;
	}

	public void setCodigoDoVendedor(double codDoVendedor) {
		codigoDoVendedor = codDoVendedor;
	}

	public double getCodigoDoComprador() {
		return codigoDoComprador;
	}

	public void setCodigoDoComprador(double codDoComprador) {
		codigoDoComprador = codDoComprador;
	}

	public double getStatusProduto() {
		return statusProduto;
	}

	public void setStatusProduto(double statusProd) {
		statusProduto = statusProd;
	}

	/**
	 * Metodo que pega os lances do produto
	 */
	public int getContadorLances() {
		return this.quantidadeDeLancesOfertados;
	}

	/**
	 * Metodo que muda o status do produto para venda iniciada
	 */
	public void iniciarVenda() {
		setStatusProduto(1);
	}

	/**
	 * M�todo que efetua um lance para o produto.
	 * 
	 * @param lance
	 * @return
	 */
	public void efetuarLance(double lance, double codCliente) {

		this.quantidadeDeLancesOfertados++;

		setCodigoDoComprador(codCliente);

		if (getStatusProduto() == 1) {

			if (lance > this.valorAtual) {
				this.valorAtual = lance;

			} else
				throw new LanceAbaixoDoValorException(
						"Voce deu um lance que e abaixo do valor do produto, tente um lance maior");
		}else
		throw new VendaNaoIniciadaException(
					"Este Produto ainda nao esta Disponivel para Venda, inicie Primeiro a Venda");
	}

	/**
	 * Metodo abstrato de desconto
	 */
	public abstract double desconto(double valor);

}
