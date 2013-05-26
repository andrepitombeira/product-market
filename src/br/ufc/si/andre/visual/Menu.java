package br.ufc.si.andre.visual;

import java.util.ArrayList;

import br.ufc.si.andre.excecoes.LanceAbaixoDoValorException;
import br.ufc.si.andre.excecoes.LancesExcedidosException;
import br.ufc.si.andre.excecoes.LocalException;
import br.ufc.si.andre.excecoes.ProdutoNaoEncontradoException;
import br.ufc.si.andre.excecoes.VendaNaoIniciadaException;
import br.ufc.si.andre.negocio.Sistema;
import br.ufc.si.andre.participantes.Participantes;
import br.ufc.si.andre.produto.Produto;
import br.ufc.si.andre.produto.ProdutoNovo;
import br.ufc.si.andre.produto.ProdutoUsado;
import br.ufc.si.br.mercado.MercadoArrayParticipante;
import br.ufc.si.br.mercado.MercadoArrayProduto;

public class Menu {
	MercadoArrayParticipante arrayparticipante = new MercadoArrayParticipante();
	MercadoArrayProduto arrayproduto = new MercadoArrayProduto();
	Sistema sistema = new Sistema();

	public void getMenu() {
		boolean control = true;
		while (control == true) {

			System.out
					.println("*************************************************************************************************************");
			System.out
					.println("* 0 - Cadastrar um novo Participante                                                                        *");
			System.out
					.println("* 1- Cadastrar um novo Produto                                                                              *");
			System.out
					.println("* 2- Iniciar a venda de um determinado Produto                                                              *");
			System.out
					.println("* 3- Encerrar a venda de um determinado Produto 			                                                  *");
			System.out
					.println("* 4- Consultar o valor atual de um Produto                                                                  *");
			System.out
					.println("* 5- Consultar o valor de desconto para um determinado Produto                                              *");
			System.out
					.println("* 6- Efetuar Lance                                                                                          *");
			System.out
					.println("* 7- Consultar o numero maximo de lances e a quantidade de lances ja realizados para um determinado produto *");
			System.out
					.println("* 8- Listar todos os Produtos de um determinado Vendedor                                                    *");
			System.out
					.println("* 9- Listar as informacoes de todos os Produtos cuja venda foi finalizada, dentro de um periodo             *");
			System.out
					.println("* 10- SAIR                                                                                                  *");
			System.out
					.println("*************************************************************************************************************");
			try {
				System.out.println("DIGITE A OPCAO DESEJADA");
				int opcao = Util.readInt();

				switch (opcao) {
				// Cadastrar Participante
				case 0:
					try {
						System.out.println("Digite seu nome  ");
						String nome = Util.readStr();
						System.out.println("Digite seu cpf   ");
						double cpf = Util.readDbl();
						System.out.println("Digite seu e-mail");
						String email = Util.readStr();
						double cod = sistema.geraCodigoParticipante();
						Participantes p = new Participantes(nome, cpf, email,
								cod);
						sistema.adicionarParticipante(p);
						System.out
								.println("Participante adicionado com Sucesso!");
						System.out.println("Seu codigo e: " + cod);
					} catch (Exception e) {
						System.out.println("Erro:" + e);
					}
					break;

				// Cadastrar Produto
				case 1:
					System.out.println("*************************");
					System.out.println("* 1- Produto Novo       *");
					System.out.println("* 2- Produto Usado      *");
					System.out.println("*************************");

					System.out.println("DIGITE A OPCAO DESEJADA");
					int escolha3 = Util.readInt();

					if (escolha3 == 1) {
						try {
							double codprod = sistema.geraCodigoProduto();
							System.out.println("Digite a Descricao do Produto");
							String descricao = Util.readStr();
							System.out
									.println("Digite a Localizacao do Produto");
							String localizacao = Util.readStr();
							System.out
									.println("Digite o Fabricante do Produto");
							String fabricante = Util.readStr();
							System.out
									.println("Digite a Data do inicio da Venda do Produto");
							double datinicio = Util.readDbl();
							System.out
									.println("Digite a Data do Fim da Venda do Produto");
							double datfim = Util.readDbl();
							System.out
									.println("Digite o valor da venda inicial do Produto");
							double valatual = Util.readDbl();
							System.out
									.println("Digite a quantidade de lances Maxima");
							double lances = Util.readDbl();
							System.out.println("Digite o codigo do Vendedor");
							double vendedor = Util.readDbl();
							ProdutoNovo pn = new ProdutoNovo(codprod,
									descricao, localizacao, fabricante,
									datinicio, datfim, valatual, lances,
									vendedor);
							sistema.adicionarProduto(pn);
							System.out
									.println("Produto Novo adicionado com Sucesso!");
							System.out.println("O codigo do Produto e: "
									+ codprod);
						} catch (Exception e) {
							System.out.println("Erro:" + e);
						}
						break;
					}
					if (escolha3 == 2) {
						try {
							double codprod2 = sistema.geraCodigoProduto();
							System.out.println("Digite a Descricao do Produto");
							String descricao2 = Util.readStr();
							System.out
									.println("Digite a Localizacao do Produto");
							String localizacao2 = Util.readStr();
							System.out
									.println("Digite o Fabricante do Produto");
							String fabricante2 = Util.readStr();
							System.out
									.println("Digite a Data do inicio da Venda do Produto");
							double datinicio2 = Util.readDbl();
							System.out
									.println("Digite a Data do Fim da Venda do Produto");
							double datfim2 = Util.readDbl();
							System.out
									.println("Digite o valor da venda inicial do Produto");
							double valatual2 = Util.readDbl();
							System.out.println("Digite o codigo do Vendedor");
							double vendedor2 = Util.readDbl();
							ProdutoUsado pu = new ProdutoUsado(codprod2,
									descricao2, localizacao2, fabricante2,
									datinicio2, datfim2, valatual2, vendedor2);
							sistema.adicionarProduto(pu);
							System.out
									.println("Produto Usado adicionado com Sucesso!");
							System.out.println("O codigo do Produto e: "
									+ codprod2);
						} catch (Exception e) {
							System.out.println("Erro:" + e);
						}
						break;
					}

					// Iniciar a venda de um Produto
				case 2:

					System.out.println("*************************");
					System.out.println("* 1- Produto Novo       *");
					System.out.println("* 2- Produto Usado      *");
					System.out.println("*************************");

					System.out.println("DIGITE A OPCAO DESEJADA");
					int escolha2 = Util.readInt();

					if (escolha2 == 1) {
						System.out
								.println("Digite o cogigo do produto que voce deseja Iniciar a Venda");
						double codigo = Util.readDbl();
						try {
							sistema.iniciarVendaProdutoNovo(codigo);
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						}
						System.out.println("Venda Iniciada com Sucesso!");
						break;
					}

					if (escolha2 == 2) {
						System.out
								.println("Digite o cogigo do produto que voce deseja Iniciar a Venda");
						double cod2 = Util.readDbl();
						try {
							sistema.iniciarVendaProdutoUsado(cod2);
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						}

						System.out.println("Venda Iniciada com Sucesso!");
						break;
					}

					// Encerrar a venda de um Produto
				case 3:

					System.out.println("*************************");
					System.out.println("* 1- Produto Novo       *");
					System.out.println("* 2- Produto Usado      *");
					System.out.println("*************************");

					System.out.println("DIGITE A OPCAO DESEJADA");
					int esc = Util.readInt();

					if (esc == 1) {
						System.out
								.println("Este tipo de Prouduto nao pode ter a Venda Encerrada");
						break;
					}

					if (esc == 2) {
						System.out
								.println("Digite o cogigo do produto que voce deseja Encerrar a Venda");
						double c = Util.readDbl();
						try {
							sistema.encerrarVendaProduto(c);
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						}
						System.out.println("Venda Encerrada com Sucesso!");
						break;
					}

					// Verificar o preco de um Produto
				case 4:
					System.out.println("*************************");
					System.out.println("* 1- Produto Novo       *");
					System.out.println("* 2- Produto Usado      *");
					System.out.println("*************************");

					System.out.println("DIGITE A OPCAO DESEJADA");
					int esc8 = Util.readInt();

					if (esc8 == 1) {

						System.out
								.println("Digite o codigo do Produto que voce deseja verificar o Valor");
						double codPreco = Util.readDbl();
						System.out.println("Digite onde voce mora");
						String local = Util.readStr();
						try {
							String desc = sistema.verificaDescricao(codPreco);
							double val = sistema.verificaPreco(codPreco);
							double comprador = sistema
									.verificaComprador(codPreco);
							double desconto = sistema
									.verificaDescontoProdutoNovo(codPreco,
											local);
							System.out.print("O valor do produto " + desc);
							System.out.println("e: " + val);
							if (desconto > 0) {
								System.out.println("O valor com desconto e: "
										+ desconto);
							} else {
								System.out
										.println("Este produto nao tem desconto");
							}
							System.out.println("Ultimo lance feito por: "
									+ comprador);
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						}
						break;
					}
					if (esc8 == 2) {
						System.out
								.println("Digite o codigo do Produto que voce deseja verificar o preco");
						double codPreco = Util.readDbl();
						System.out.println("Digite onde voce mora");
						String local = Util.readStr();
						try {
							String desc = sistema.verificaDescricao(codPreco);
							double val = sistema.verificaPreco(codPreco);
							double comprador = sistema
									.verificaComprador(codPreco);
							double desconto2 = sistema
									.verificaDescontoProdutoUsado(codPreco,
											local);
							System.out.print("O valor do produto " + desc);
							System.out.println("e: " + val);
							if (desconto2 > 0) {
								System.out.println("O valor com desconto e: "
										+ desconto2);
							} else
								System.out
										.println("Este produto nao tem desconto");
							System.out.println("Ultimo lance feito por: "
									+ comprador);
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						}
						break;
					}

					// Verificar o desconto de um produto
				case 5:
					System.out.println("*************************");
					System.out.println("* 1- Produto Novo       *");
					System.out.println("* 2- Produto Usado      *");
					System.out.println("*************************");

					System.out.println("DIGITE A OPCAO DESEJADA");
					int esc4 = Util.readInt();

					if (esc4 == 1) {

						System.out
								.println("Digite o codigo do produto que voce deseja verificar o Desconto");
						double codDesc = Util.readDbl();
						System.out.println("Digite onde voce mora");
						String local = Util.readStr();
						try {
							double desconto = sistema
									.verificaDescontoProdutoNovo(codDesc, local);
							if (desconto > 0) {
								System.out
										.println("O valor do Produto com desconto e: "
												+ desconto);
							} else
								System.out
										.println("Este Produto nao tem Desconto");
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						}

						break;
					}

					if (esc4 == 2) {
						System.out
								.println("Digite o codigo do produto que voce deseja verificar o Desconto");
						double codDesc = Util.readDbl();
						System.out.println("Digite onde voce mora");
						String local = Util.readStr();
						try {
							double desconto = sistema
									.verificaDescontoProdutoUsado(codDesc,
											local);
							if (desconto > 0) {
								System.out
										.println("O valor do Produto com desconto e: "
												+ desconto);
							} else
								System.out
										.println("Este Produto nao tem Desconto");
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						}
						break;

					}

					// Efetuar um lance
				case 6:
					System.out.println("*************************");
					System.out.println("* 1- Produto Novo       *");
					System.out.println("* 2- Produto Usado      *");
					System.out.println("*************************");

					System.out.println("DIGITE A OPCAO DESEJADA");
					int escolha5 = Util.readInt();

					if (escolha5 == 1) {
						System.out
								.println("Digite o codigo do produto que voce deseja efetuar um Lance");
						double codi = Util.readDbl();
						System.out.println("Digite o valor do lance");
						double valor = Util.readDbl();
						System.out.println("Digite seu codigo");
						double codParticipante = Util.readDbl();
						try {
							sistema.efetuaLanceProdutoNovo(codi, valor,
									codParticipante);
							System.out.println("Lance Efetuado com Sucesso!");
						} catch (LancesExcedidosException e) {
							System.out.println("Erro: " + e);
						} catch (LanceAbaixoDoValorException e) {
							System.out.println("Erro: " + e);
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						} catch (VendaNaoIniciadaException e) {
							System.out.println("Erro: " + e);
						}
						break;
					}
					if (escolha5 == 2) {
						System.out
								.println("Digite o codigo do produto que voce deseja efetuar um Lance");
						double codig = Util.readDbl();
						System.out.println("Digite o valor do lance");
						double lance = Util.readDbl();
						System.out.println("Digite seu codigo");
						double codCliente = Util.readDbl();
						try {
							sistema.efetuaLanceProdutoUsado(codig, lance,
									codCliente);
							System.out.println("Lance Efetuado co Sucesso!");
						} catch (LancesExcedidosException e) {
							System.out.println("Erro: " + e);
						} catch (LanceAbaixoDoValorException e) {
							System.out.println("Erro: " + e);
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						} catch (VendaNaoIniciadaException e) {
							System.out.println("Erro: " + e);
						}
						break;
					}

					// Verificar quantidade lances efetuados e Quantidade Maxima
					// de
					// Lances
				case 7:
					System.out.println("*************************");
					System.out.println("* 1- Produto Novo       *");
					System.out.println("* 2- Produto Usado      *");
					System.out.println("*************************");

					System.out.println("DIGITE A OPCAO DESEJADA");
					int escolha6 = Util.readInt();

					if (escolha6 == 1) {
						System.out.println("Digite o codigo do Produto");
						double cod2 = Util.readDbl();
						try {
							double lances = sistema
									.verificaLancesEfetuados(cod2);
							double lancesMaximos = sistema
									.verificaLancesMaximos(cod2);
							System.out
									.println("A quantidade de lances efetuados e: "
											+ lances);
							System.out
									.println("O numero maximo de lances permitidos e: "
											+ lancesMaximos);
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						}
						break;
					}
					if (escolha6 == 2) {
						System.out.println("Digite o codigo do Produto");
						double cod3 = Util.readDbl();
						try {
							double lances = sistema
									.verificaLancesEfetuados(cod3);
							System.out
									.println("A quantidade de lances efetuados e: "
											+ lances);
							System.out
									.println("Este produto nao tem limite de numero maximo de lances");
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("Erro: " + e);
						}
						break;
					}

					// Verificar todos os Produtos de um vendedor
				case 8:
					System.out.println("Digite o codigo do vendedor");
					double vendedor = Util.readDbl();
					ArrayList<Produto> produtos = sistema
							.produtosVendedor(vendedor);
					if (produtos.size() == 0) {
						System.out
								.println("Este vendedor nao tem produtos cadastrados");
					} else {
						for (int i = 0; i < produtos.size(); i++) {
							Produto pro = produtos.get(i);
							System.out.println("Codigo: " + pro.getCodigo());
							System.out.println("Descricao: "
									+ pro.getDescricao());
							System.out.println("Localizacao: "
									+ pro.getLocalizacaoDoProduto());
							System.out.println("Fabricante: "
									+ pro.getFabricante());
							System.out.println("Valor: " + pro.getValorAtual());
							System.out.println();
						}

					}
					break;

				// Verificar todos os produtos cuja venda foi encerrada dentro
				// de um
				// prazo
				case 9:
					ArrayList<Produto> produto = new ArrayList();
					System.out.println("Digite o periodo inicial");
					double inicial = Util.readDbl();
					System.out.println("Digite o periodo final");
					double fim = Util.readDbl();
					try {
						produto = sistema.produtosPeriodo(inicial, fim);
						for (int i = 0; i < produto.size(); i++) {
							Produto pro = (Produto) produto.get(i);
							System.out.println("Codigo: " + pro.getCodigo());
							System.out.println("Descricao: "
									+ pro.getDescricao());
							System.out.println("Localizacao: "
									+ pro.getLocalizacaoDoProduto());
							System.out.println("Fabricante: "
									+ pro.getFabricante());
							System.out.println("Valor: " + pro.getValorAtual());
							System.out.println();
						}
					} catch (VendaNaoIniciadaException e) {
						System.out.println("Erro: " + e);
					}
					break;

				// Sair
				case 10:
					control = false;
					break;

				default:
					System.out.println("ESTA TECLA NAO TEM FUNCAO!");
					System.out.println();
					System.out.println("Aperte ENTER para voltar ao Menu");
					Util.waitEnter();
					break;

				}
			} catch (Exception e) {
				System.out.println("Erro:" + e);
			}
		}
	}
}
