/**
 * Classe da logica Principal do Negocio
 */
package br.ufc.si.andre.negocio;

/**
 * Pacotes
 */
import java.util.ArrayList;
import java.util.Vector;

import br.ufc.si.andre.excecoes.LocalException;
import br.ufc.si.andre.excecoes.ProdutoNaoEncontradoException;
import br.ufc.si.andre.excecoes.VendaNaoIniciadaException;
import br.ufc.si.andre.participantes.Participantes;
import br.ufc.si.andre.produto.Produto;
import br.ufc.si.andre.produto.ProdutoNovo;
import br.ufc.si.andre.produto.ProdutoUsado;

public class Sistema {

	Vector<Participantes> participantes = new Vector<Participantes>();
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	static double codParticipante = 1; // variavel para gerar codigo do
	// participante
	static double codProduto = 1; // variavel para gerar codigo do produto

	/**
	 * Metodo para adicionar produto
	 * 
	 * @param p
	 */

	public void adicionarProduto(Produto p) {
		produtos.add(p);
	}

	/**
	 * Metodo para adicionar Participante
	 * 
	 * @param p
	 */
	public void adicionarParticipante(Participantes p) {
		participantes.add(p);
	}

	/**
	 * Metodo para buscar produto pelo codigo
	 * 
	 * @param codigo
	 * @return
	 */
	public int buscaProduto(double codigo) {
		int y = 0; // variavel que retornara o indice da lista
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = (Produto) produtos.get(i);
			if (p.getCodigo() == codigo) {
				y = i;
			} else
				throw new ProdutoNaoEncontradoException(
						"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
		}
		return y;
	}

	/**
	 * Metodo para buscar produto novo pelo codigo
	 * 
	 * @param codigo
	 * @return
	 */

	public int buscaProdutoNovo(double codigo) {
		int y = 0; // variavel que retornara o indice da lista
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = (Produto) produtos.get(i);
			if (p instanceof ProdutoNovo) {
				if (p.getCodigo() == codigo) {
					y = i;
				} else
					throw new ProdutoNaoEncontradoException(
							"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
			}
		}
		return y;
	}

	/**
	 * Metodo para buscar produto usado pelo codigo
	 * 
	 * @param codigo
	 * @return
	 */
	public int buscaProdutoUsado(double codigo) {
		int x = 0; // variavel que retornara o indice da lista
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = (Produto) produtos.get(i);
			if (p instanceof ProdutoUsado) {
				if (p.getCodigo() == codigo) {
					x = i;
				} else
					throw new ProdutoNaoEncontradoException(
							"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
			}
		}
		return x;
	}

	/**
	 * Metodo para buscar psrticipante pelo cpf
	 * 
	 * @param cpf
	 * @return
	 */

	public int buscaParticipante(double cpf) {
		int z = 0; // variable that return the index of the list
		for (int i = 0; i < participantes.size(); i++) {
			Participantes p = (Participantes) participantes.get(i);
			if (p.getCpf() == cpf) {
				z = i;
			}
		}
		return z;

	}

	/**
	 * Metodo para iniciar a venda de um produto novo
	 * 
	 * @param cod
	 */
	public void iniciarVendaProdutoNovo(double cod) {
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = (Produto) produtos.get(i);
			if (p instanceof ProdutoNovo) {
				if (p.getCodigo() == cod) {
					p.iniciarVenda();
				} else
					throw new ProdutoNaoEncontradoException(
							"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
			}
		}

	}

	/**
	 * Metodo para iniciar a venda de um produto usado
	 * 
	 * @param cod
	 */
	public void iniciarVendaProdutoUsado(double cod) {
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = (Produto) produtos.get(i);
			if (p instanceof ProdutoUsado) {
				if (p.getCodigo() == cod) {
					p.iniciarVenda();
				} else
					throw new ProdutoNaoEncontradoException(
							"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
			}
		}

	}

	/**
	 * Metodo para encerrar a venda de um produto
	 * 
	 * @param cod
	 */

	public void encerrarVendaProduto(double cod) {
		for (int i = 0; i < produtos.size(); i++) {
			ProdutoUsado pu = (ProdutoUsado) produtos.get(i);
			if (pu instanceof ProdutoUsado) {
				if (pu.getCodigo() == cod) {
					pu.encerrarVenda();
				} else
					throw new ProdutoNaoEncontradoException(
							"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
			}
		}

	}

	/**
	 * Metodo que verifica descricao de um produto pelo codigo
	 * 
	 * @param cogigo
	 * @return
	 */

	public String verificaDescricao(double codigo) {
		String desc = ""; // variavel que retornara a descricao do produto
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = (Produto) produtos.get(i);
			if (p.getCodigo() == codigo) {
				desc = p.getDescricao();
			} else
				throw new ProdutoNaoEncontradoException(
						"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
		}
		return desc;
	}

	/**
	 * Metodo que verifica o preco de um produto pelo codigo
	 * 
	 * @param codigo
	 * @return
	 */

	public double verificaPreco(double codigo) {
		double preco = 0; // variavel que retornara o valor do produto
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = (Produto) produtos.get(i);
			if (p.getCodigo() == codigo) {
				preco = p.getValorAtual();
			} else
				throw new ProdutoNaoEncontradoException(
						"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
		}
		return preco;
	}

	/**
	 * Metodo que verifica o desconto de um produto novo
	 * 
	 * @param codigo
	 * @param local
	 * @return
	 */

	public double verificaDescontoProdutoNovo(double codigo, String local) {
		double desconto = 0; // variavel que retornara o desconto do produto
		for (int i = 0; i < produtos.size(); i++) {
			ProdutoNovo pn = (ProdutoNovo) produtos.get(i);
			if (pn instanceof ProdutoNovo) {
				if (pn.getCodigo() == codigo) {
					if (pn.getLocalizacaoDoProduto().equals(local)) {
						desconto = pn.desconto(pn.getValorAtual());
					}
				} else
					throw new ProdutoNaoEncontradoException(
							"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
			}
		}
		return desconto;

	}

	/**
	 * Metodo que verifica o desconto de um produto usado
	 * 
	 * @param codigo
	 * @param local
	 * @return
	 */

	public double verificaDescontoProdutoUsado(double codigo, String local) {
		double desconto = 0; // variavel que retornara o desconto do produto
		for (int i = 0; i < produtos.size(); i++) {
			ProdutoUsado pu = (ProdutoUsado) produtos.get(i);
			if (pu instanceof ProdutoUsado) {
				if (pu.getCodigo() == codigo) {
					if (pu.getLocalizacaoDoProduto().equals(local)) {
						desconto = pu.desconto(pu.getValorAtual());
					}
				} else
					throw new ProdutoNaoEncontradoException(
							"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
			}
		}
		return desconto;

	}

	/**
	 * Metodo para efetuar lance em um produto novo
	 * 
	 * @param codigo
	 * @param valor
	 * @param codCliente
	 */
	public void efetuaLanceProdutoNovo(double codigo, double valor,
			double codCliente) {
		for (int i = 0; i < produtos.size(); i++) {
			ProdutoNovo pn = (ProdutoNovo) produtos.get(i);
			if (pn instanceof ProdutoNovo) {
				if (pn.getStatusProduto() == 1) {
					if (pn.getCodigo() == codigo) {
						pn.efetuarLance(valor, codCliente);
					} else
						throw new ProdutoNaoEncontradoException(
								"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
				}
				throw new VendaNaoIniciadaException(
						"Este Produto nao teve a Tenda Iniciada, inici-a Primeiro");
			}
		}
	}

	/**
	 * Metodo para efetuar lance em um produto usado
	 * 
	 * @param codigo
	 * @param valor
	 * @param codCliente
	 */

	public void efetuaLanceProdutoUsado(double codigo, double valor,
			double codCliente) {
		for (int i = 0; i < produtos.size(); i++) {
			ProdutoUsado pu = (ProdutoUsado) produtos.get(i);
			if (pu instanceof ProdutoUsado) {
				if (pu.getStatusProduto() == 1) {
					if (pu.getCodigo() == codigo) {
						pu.efetuarLance(valor, codCliente);
					} else
						throw new ProdutoNaoEncontradoException(
								"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
				}
				throw new VendaNaoIniciadaException(
						"Este Produto nao teve a Tenda Iniciada, inici-a Primeiro");
			}
		}
	}

	/**
	 * Metodo que verifica a quantidade de lances efetuados em um produto
	 * 
	 * @param codigo
	 * @return
	 */

	public double verificaLancesEfetuados(double codigo) {
		double lances = 0; // variavel que retornara o numero de lances
		// efetuados
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = (Produto) produtos.get(i);
			if (p.getCodigo() == codigo) {
				lances = p.getContadorLances();
			} else
				throw new ProdutoNaoEncontradoException(
						"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
		}
		return lances;
	}

	/**
	 * Metodo que verifica a quantidade maxima de lances permitidos para um
	 * produto
	 * 
	 * @param codigo
	 * @return
	 */
	public double verificaLancesMaximos(double codigo) {
		double lancesMaximo = 0; // variavel que retornara o numero de maxomo
		// de lances
		for (int i = 0; i < produtos.size(); i++) {
			ProdutoNovo pn = (ProdutoNovo) produtos.get(i);
			if (pn instanceof ProdutoNovo) {
				if (pn.getCodigo() == codigo) {
					lancesMaximo = pn.getlancesMaximo();
				} else
					throw new ProdutoNaoEncontradoException(
							"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
			}
		}
		return lancesMaximo;
	}

	/**
	 * Metodo que verifica todos os produtos de um vendedor
	 * 
	 * @param codVendedor
	 * @return
	 */

	public ArrayList produtosVendedor(double codVendedor) {
		ArrayList<Produto> prod = new ArrayList<Produto>();
		for (int i = 0; i < this.produtos.size(); i++) {
			Produto p = this.produtos.get(i);
			if (p.getCodigoDoVendedor() == codVendedor) {
				prod.add(p);
			}
		}
		return prod;
	}

	/**
	 * Metodo que verifica todos os produtos cuja venda foi encerrada dentro de
	 * um periodo
	 * 
	 * @param inicio
	 * @param fim
	 * @return
	 */
	public ArrayList<Produto> produtosPeriodo(double inicio, double fim) {
		ArrayList<Produto> prod = new ArrayList<Produto>();
		for (int i = 0; i < this.produtos.size(); i++) {
			Produto p = this.produtos.get(i);
			if (p.getStatusProduto() == 2) {
				if (p.getDataDeConclusaoDaVenda() >= inicio
						&& p.getDataDeConclusaoDaVenda() <= fim) {
					prod.add(p);
				}
			} else
				throw new VendaNaoIniciadaException(
						"Nao ha Produtos com a venda Encerrada neste Periodo");
		}
		return prod;
	}

	/**
	 * Metodo que verifica o codigo de um comprador pelo codigo do produto
	 * 
	 * @param codigo
	 * @return
	 */

	public double verificaComprador(double codigo) {
		double comprador = 0; // variavel que retornara o codigo do comprador
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = (Produto) produtos.get(i);
			if (p.getCodigo() == codigo) {
				comprador = p.getCodigoDoComprador();
			} else
				throw new ProdutoNaoEncontradoException(
						"Este Produto nao existe, Verifique se voce digitou corretamente o Codigo");
		}
		return comprador;
	}

	/**
	 * Metodo que gera o codigo dos participantes
	 * 
	 * @return
	 */
	public double geraCodigoParticipante() {
		return codParticipante++;

	}

	/**
	 * Metodo que gera o codigo dos produtos
	 * 
	 * @return
	 */

	public double geraCodigoProduto() {
		return codProduto++;

	}

}
