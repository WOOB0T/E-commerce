package classes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		
		Comercio.setVendas(Dados.retornaVendas());
		Comercio.setProdutos(Dados.retornaProdutos());
		Comercio.setRelatorios(Dados.retornaDados());
		Comercio.setValorEmCaixa(Dados.retornaCaixa());	
		
    	String menu2 = ("\n🔄 Redirecionando para o menu. 🔄");
        boolean sair = false;

        while (!sair) {
        	
        	System.out.println("\n        \uD83C\uDFAE   JAVA GAMES   \uD83C\uDFAE        \n");
			System.out.println("[ 1 ] ▸ Listar produtos \uD83D\uDCCB");
			System.out.println("[ 2 ] ▸ Cadastrar um novo produto \uD83D\uDD8A\uFE0F");
			System.out.println("[ 3 ] ▸ Adicionar estoque de um produto ➕");
			System.out.println("[ 4 ] ▸ Remover um produto do comércio ❌");
			System.out.println("[ 5 ] ▸ Vender algum produto existente 💲");
			System.out.println("[ 6 ] ▸ Imprimir Relatório");
			System.out.println("[ 7 ] ▸ Sair do programa \uD83C\uDFC3");
			System.out.print("\n▶ Escolha uma opção: ");
			
            int escolha = Integer.parseInt(sc.nextLine());

            switch (escolha) {
            
                case 1:
            		
        			System.out.println("\n[ 1 ] ▸ Listar todos os produtos \uD83D\uDCCB");
        			System.out.println("[ 2 ] ▸ Listar produtos por categoria \uD83D\uDD8A\uFE0F");
        			System.out.print("\n▶ Escolha uma opção: ");
        			int listagemEscolha = Integer.parseInt(sc.nextLine());
        			
        			if (listagemEscolha == 1) {
	                	
	                	if (Comercio.produtos.isEmpty()) {
	                		System.out.println("\n⌕ Ainda não existem produtos cadastrados no comércio.");            		
	                	
	                	} else {
	                	System.out.println("\n⌕ Listando produtos disponiveis!\n");
	            		for (Produto produto : Comercio.produtos) {
	            			System.out.println("➥ Cód.: " + produto.codigo + " | Nome: " + produto.nome + " | Categoria: " + produto.categoria + " | Estoque: " + produto.estoque + 
	            					" | Custo de Compra: " + produto.custoDeCompra + " | Valor de venda: " + produto.valorDeVenda + " | " + produto.listarDetalhe() + "\n");
	            			
	            			}
	                	} 
	                		
	                		
	                	} else { 

		                	if (Comercio.produtos.isEmpty()) {
		                		System.out.println("\n⌕ Ainda não existem produtos cadastrados no comércio.");
		                		
		                	} else {
		                		
		                		System.out.println("\n⌕ Ainda não existem produtos cadastrados no comércio."); 
		                		System.out.println("\nCategorias de produto disponiveis: ");
		                    	System.out.println("[ 1 ] ▸ Jogos");
		                    	System.out.println("[ 2 ] ▸ Informática");
		                    	System.out.println("[ 3 ] ▸ Acessórios");
		                    	System.out.print("\n▶ Escolha uma opção: ");
		                    	int categoria = Integer.parseInt(sc.nextLine());
		                    	
		                    	ArrayList<Produto> produtosCategoria = new ArrayList<Produto>();
		                    	produtosCategoria = Comercio.listarCategoria(Comercio.getProdutos(), categoria);
		                    	
	                	
		                    	
		                    	if (produtosCategoria.isEmpty()) {
			                		System.out.println("\n⌕ Ainda não existem produtos cadastrados nessa categoria.");            		
			                	
			                	} else {
			                    	System.out.println("\n⌕ Listando produtos disponiveis!\n");
				            		for (Produto produto : produtosCategoria) {
				            			System.out.println("➥ Cód.: " + produto.codigo + " | Nome: " + produto.nome + " | Categoria: " + produto.categoria + " | Estoque: " + produto.estoque + 
				            						" | Custo de Compra: " + produto.custoDeCompra + " | Valor de venda: " + produto.valorDeVenda + " | " + produto.listarDetalhe() + "\n");
				            		
				            		}
			            		
			                	}
		                    	
		                	}
		                	
	                	}
        			
                    System.out.println(menu2);
                    break;
                    
        			
                case 2:
                	String categoria;
                	
                	while(true) {
                	System.out.println("\nCategorias de produto disponiveis: ");
                	System.out.println("[ 1 ] ▸ Jogos");
                	System.out.println("[ 2 ] ▸ Informática");
                	System.out.println("[ 3 ] ▸ Acessórios");
                	System.out.print("\n▶ Escolha uma opção: ");
                	int produtoCategoria = Integer.parseInt(sc.nextLine());
              
                	categoria = Comercio.categoriasDeProduto(produtoCategoria);
                	
                	if (categoria.equals("Opção Inválida")) {
                		System.out.println("\n• " + categoria + "! Tente novamente");
                	
                	} else { break; }
                	
                	}
                		
                	System.out.print("\n▶ Digite o nome do novo produto: ");
                    String nome = sc.nextLine();
                    
                	System.out.print("▶ Digite o custo de compra desse produto: ");            
                	double custo = Double.parseDouble(sc.nextLine());
                	
                	System.out.print("▶ Digite o valor da venda desse produto: ");
                	double venda = Double.parseDouble(sc.nextLine());
                	
                	Produto produto;
                	
                	if (categoria.equals("Jogos")) {
                		
                		System.out.println("▶ Digite a plataforma em que esse jogo está disponivel: ");
                		String plataforma = sc.nextLine();
                		
                		produto = Comercio.cadastrarJogos(Comercio.produtos, nome, custo, venda, categoria, plataforma);
                		
                	} else if (categoria.equals("Acessórios")) {
                		
                		System.out.println("\nCategorias de conexão: ");
                    	System.out.println("[ 1 ] ▸ Com fio");
                    	System.out.println("[ 2 ] ▸ Bluetooth");
                    	System.out.print("\n▶ Escolha uma opção: ");
                    	int codigo = Integer.parseInt(sc.nextLine());
                    	
                    	String conector = Acessorios.conector(codigo);
                    	
                    	produto = Comercio.cadastrarAcessorio(Comercio.getProdutos(), nome, custo, venda, categoria, conector);
                    	
                	}  else if (categoria.equals("Informática")) {
                		
                		System.out.println("\nTipos de processadores: ");
                    	System.out.println("[ 1 ] ▸ AMD Ryzen");
                    	System.out.println("[ 2 ] ▸ Intel Core");
                    	System.out.print("\n▶ Escolha uma opção: ");
                    	int codigo = Integer.parseInt(sc.nextLine());
                    	
                    	String tipo = Informatica.processador(codigo);
                    	
                    	produto = Comercio.cadastrarItem(Comercio.getProdutos(), nome, custo, venda, categoria, tipo);
                    	
                	} else {
                	
                		produto = Comercio.cadastrarProduto(Comercio.getProdutos(), nome, custo, venda, categoria);
                	}
                	
                	
                	System.out.println("\n▶ Você deseja cadastrar estoque a esse produto? (S/N)");
                	String verificar = sc.nextLine();
                	
                	if (verificar.equalsIgnoreCase("s")) {
                		
                    	System.out.print("▶ Digite a quantidade que deseja adicionar ao estoque: ");
                    	int quantidadeEstoque = Integer.parseInt(sc.nextLine());
                    	
                		boolean estoqueAdd = Comercio.comprarProduto(produto, quantidadeEstoque);
                		
                		if (estoqueAdd == false) {
                			System.out.println("• Não foi possivel comprar essa quantidade de estoque para o produto " + produto + ". Verifique se o saldo do comércio é suficiente para essa compra e tente novamente!");
                			
                		}
                	}
                	
                    System.out.println("\n" + produto.nome + " cadastrado com sucesso ✔\uFE0F\n" + "➥ Categoria: " + produto.getCategoria() + "\n" + "➥ Código: " + produto.getCodigo() + "\n" + "➥ Estoque: " + produto.getEstoque());
                   
                    String relatorioCadastro = "✔ O comércio acrescentou em seu catalogo o produto " + produto.nome + " de categoria " + produto.categoria + ". -A quantidade de estoque desse produto atualmente é " + produto.estoque + " e o valor em caixa atual do comércio é de R$" + Comercio.getValorEmCaixa();
                    Comercio.adicionarRelatorio(relatorioCadastro);
                    
                    System.out.println(menu2);
                    break;
                    
                case 3:
                	
                	if (Comercio.getProdutos().isEmpty()) {
                        System.out.println("\n⌕ Não há nenhum produto no sistema no qual o estoque possa ser alterado. \uD83D\uDEAB");
                	
                	} else { 
                		
                		System.out.println("⌕ Listando Produtos!");
                		for (Produto produtoPesquisado : Comercio.produtos) {
	            			System.out.println("➥ Cód.: " + produtoPesquisado.codigo + " | Nome: " + produtoPesquisado.nome + " | Estoque: " + produtoPesquisado.estoque + 
	            					" | Custo de Compra: " + produtoPesquisado.custoDeCompra + "\n");
             
                		}
                		
	                	System.out.println("▶ Digite o código do produto que deseja adicionar estoque: ");
	                	int codigo = Integer.parseInt(sc.nextLine());
	                	
	                	Produto produtoPesquisado = Comercio.pesquisarProduto(codigo);
	                	
	                	if (produtoPesquisado == null) {
	                		
	                		System.out.println("\n• Não existe produto cadastrado com esse código!");
	                		
	                	} else {
	                		
	                		String nomeProduto = produtoPesquisado.getNome();
	                		System.out.println("▶ Digite a quantidade de estoque que deseja adicionar em " + nomeProduto);
	                		int quantidadeEstoque = Integer.parseInt(sc.nextLine());
	                		
	                		boolean estoqueAdd = Comercio.comprarProduto(produtoPesquisado, quantidadeEstoque);
	                		
	                		if (estoqueAdd == false) {
	                			System.out.println("• Não foi possivel comprar essa quantidade de estoque para o produto " + nomeProduto + ". Verifique se o saldo do comércio é suficiente para essa compra e tente novamente!");
	                			String relatorioCompra = " ❌ O comércio tentou comprar a quantidade de " + quantidadeEstoque + " de unidades para o produto " + produtoPesquisado.nome + ", mas não conseguiu por insuficiencia de saldo no caixa. - O valor em caixa atual do comércio é de R$" + Comercio.getValorEmCaixa();
			                    Comercio.adicionarRelatorio(relatorioCompra);
		                  
	                		} else {
			                    System.out.println("\nEstoque do produto" + nomeProduto + " atualizado com sucesso ✔\uFE0F\n" + "➥ Categoria: " + produtoPesquisado.getCategoria() + "\n" + "➥ Código: " + produtoPesquisado.getCodigo() + "\n" + "➥ Estoque: " + produtoPesquisado.getEstoque());
			                    String relatorioCompra = "💲 O comércio comprou a quantidade de " + produtoPesquisado.estoque + " de estoque para o produto " + produtoPesquisado.nome + " que, anteriormente, tinha " + (produtoPesquisado.estoque - quantidadeEstoque) + " unidades em seu estoque. |O valor em caixa atual do comércio é de R$" + Comercio.getValorEmCaixa();
			                    Comercio.adicionarRelatorio(relatorioCompra);
		                  
			                    System.out.println(menu2);
			                    break;
			                    
	                		}
	                	
	                	}
	                	
                	}
                	
                	System.out.println(menu2);
                	break;
                	
                case 4:
                	if (Comercio.getProdutos().isEmpty()) {
                		System.out.println("\n⌕ Ainda não existem produtos cadastrados no comércio.");            		
                	
                	} else {
	                	System.out.println("\n⌕ Listando produtos disponiveis!\n");
	            		for (Produto produtoRemover : Comercio.getProdutos()) {
	            			System.out.println("➥ Cód.: " + produtoRemover.codigo + " | Nome: " + produtoRemover.nome + " | Categoria: " + produtoRemover.categoria + " | Estoque: " + produtoRemover.estoque + "\n");
            			
            			}
            		
	            		System.out.println("▶ Digite o código do produto que deseja remover: ");
	            		int codigo = Integer.parseInt(sc.nextLine());
	            		
	            		Produto produtoPesquisado = Comercio.pesquisarProduto(codigo);
	            		
	            		if (produtoPesquisado != null) {
	            			
	            			System.out.println("▶ Você tem certeza que deseja remover esse produto? (S/N) ");
	            			String produtoRemover = sc.nextLine();
	            			
	            			if (produtoRemover.equalsIgnoreCase("s")) {
	            				
	            				Comercio.removerProduto(produtoPesquisado);
	            				System.out.println("\nProduto removido com sucesso!");
	            				
	            				String relatorioRemover = "⌦ Foi removido pelo comércio o produto " + produtoPesquisado.nome + " de categoria " + produtoPesquisado.categoria + " de seu catalogo de vendas.|O produto tinha" + produtoPesquisado.estoque + "e causou um prejuizo de " + (produtoPesquisado.custoDeCompra * produtoPesquisado.estoque) + " ao comércio";
			                    Comercio.adicionarRelatorio(relatorioRemover);
	            				
	            			} else {
	            				
	            				System.out.println("\n• Remoção de produto cancelada!");
	            			}
	            		
	            		} else {
	            			
	            			System.out.println("\n• Esse produto não existe!");
	            		}
	            		
                	}
                	
                    System.out.println(menu2);
                    break;
                    
                case 5:
                	if (Comercio.getProdutos().isEmpty()) {
                		System.out.println("\n▶ Ainda não existem produtos cadastrados no comércio.");            		
                	
                	} else {
	                	System.out.println("\n▶ Listando produtos disponiveis!\n");
	            		for (Produto produtoVenda : Comercio.getProdutos()) {
	            			System.out.println("➥ Codigo: " + produtoVenda.codigo + " | Nome: " + produtoVenda.nome + " | Categoria: " + produtoVenda.categoria + " | Estoque: " + produtoVenda.estoque + 
	            					" | Valor de venda: " + produtoVenda.valorDeVenda + " | " + produtoVenda.listarDetalhe() + "\n");
            			
            			}
            		
	            		System.out.println("▶ Digite o código do produto que deseja vender: ");
	            		int codigo = Integer.parseInt(sc.nextLine());
	            		
	            		Produto produtoPesquisado = Comercio.pesquisarProduto(codigo);
	            		
	            		if (produtoPesquisado != null) {
	            		
		            		System.out.println("▶ Digite a quantidade a ser vendida desse produto: ");
		            		int quantidade = Integer.parseInt(sc.nextLine());
		            		Comercio.venderProduto(produtoPesquisado, quantidade);
		            		
		            		System.out.println("▶ Produto vendido com sucesso!");
		                    String relatorioVenda = "💲 O comércio vendeu " + quantidade + " unidades de " + produtoPesquisado.nome + " de categoria " + produtoPesquisado.categoria + ".|A quantidade de estoque desse produto atualmente é: " + produtoPesquisado.estoque + " e o valor em caixa atual do comércio é de R$" + Comercio.getValorEmCaixa();
		                    Comercio.adicionarRelatorio(relatorioVenda);
	            		
	            		} else {
	            			
	            			System.out.println("▶ Esse produto não existe!");
	            		}
            		}
                	
                    System.out.println(menu2);
                    break;
                case 6:
                	
                	System.out.println("Tipos de relatorio: ");
                	System.out.println("[ 1 ] ▸ Valor em caixa");
                	System.out.println("[ 2 ] ▸ Total de vendas");
                	System.out.println("[ 3 ] ▸ Movimentações do comércio");
                	System.out.print("\n▶ Escolha uma opção: ");
                	int codigo = Integer.parseInt(sc.nextLine());
                	
                	if (codigo == 1) {
                		
                		System.out.println("\n• O valor de caixa atual do comércio é de: R$" + Comercio.getValorEmCaixa() );
                		
                	} else if (codigo == 2) {
                		
                		System.out.println("\n• Até o momento atual, o comércio fez vendas de " + Comercio.getVendas() + " unidades de produtos");

                		
                	} else if (codigo == 3) {
                		
                		if (Comercio.getRelatorios() == null) {
                		
                			System.out.println("\n⌕ Ainda não houveram movimentos de compras e vendas de produtos no comércio.");

                		} else {
                			System.out.println("⌕ Listando relatorios!");
                			for (String relatorio : Comercio.getRelatorios()) {
	                    		System.out.println("\n" + relatorio);
	                    		
                			}
                		}
                		
                	
                	} else {
                		
                		System.out.println("\nOpção invalida!");
                		
                	}
                	
                
                	System.out.println(menu2);
                    break;
                    
                case 7:
 
            		Dados.arquivaProdutos(Comercio.getProdutos());
            		Dados.arquivaRelatorios(Comercio.getRelatorios());
            		Dados.arquivaCaixa(Comercio.getVendas(), Comercio.getValorEmCaixa());
                    System.out.println("\nSaindo do programa. \uD83D\uDC4B");
            		sc.close();
            		sair = true;
                    break;
                    
                default:
                    System.out.println("\nOpção inválida. \uD83D\uDEAB Escolha novamente.");
                    break;
            }
        }
    }
	
}
