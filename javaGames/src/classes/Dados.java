package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Dados {

//	ARRAYLIST DE PRODUTOS
    
    public static void arquivaProdutos(ArrayList<Produto> produtos) throws IOException {
		try {
			FileWriter arquivo = new FileWriter("produtos.txt", false);
			PrintWriter writer = new PrintWriter(arquivo);
			for (Produto produto : produtos) {
				writer.write(produto.nome + ", " + produto.codigo + ", " + produto.estoque + ", " + produto.categoria + ", "
						+ produto.custoDeCompra + ", " + produto.valorDeVenda + ", " + produto.getDetalhe() + "\n");
			}
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
	}
 	
	public static ArrayList<Produto> retornaProdutos() {
		ArrayList<Produto> tempArray = new ArrayList<Produto>();
		
		File arquivo = new File("C:\\Users\\jessi\\eclipse-workspace\\javaGames\\produtos.txt");
		try {
			Scanner sc = new Scanner(arquivo);
			Produto novoProduto;
			while (sc.hasNextLine()) {
				String[] produtosArray = sc.nextLine().split(", ");
				
				if (produtosArray[3].equals("Jogos")) {
            		
            		novoProduto = Comercio.cadastrarJogos(tempArray, produtosArray[0], Double.parseDouble(produtosArray[4]), Double.parseDouble(produtosArray[5]), produtosArray[3], produtosArray[6]);
            		
            	} else if (produtosArray[3].equals("Informática")) {
            		
            		novoProduto = Comercio.cadastrarItem(tempArray, produtosArray[0], Double.parseDouble(produtosArray[4]), Double.parseDouble(produtosArray[5]), produtosArray[3], produtosArray[6]);
                	
            	} else if (produtosArray[3].equals("Acessórios")) {
            		
            		novoProduto = Comercio.cadastrarAcessorio(tempArray, produtosArray[0], Double.parseDouble(produtosArray[4]), Double.parseDouble(produtosArray[5]), produtosArray[3], produtosArray[6]);
                	
            		
				
			} else {
            	
            		novoProduto = Comercio.cadastrarProduto(tempArray, produtosArray[0], Double.parseDouble(produtosArray[4]), Double.parseDouble(produtosArray[5]), produtosArray[3]);
            	}
				
				novoProduto.adicionarEstoque(Integer.parseInt(produtosArray[2]));
				
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado");
		}
		
		return tempArray;
	}
     
	//	RELATORIOS (VALOR EM CAIXA/QUANTIDADE DE VENDAS)
	
    public static void arquivaRelatorios(ArrayList<String> relatorios) throws IOException {
		try {
			FileWriter arquivo = new FileWriter("dados.txt", false);
			PrintWriter writer = new PrintWriter(arquivo);
			for (String relatorio : relatorios) {
				writer.write(relatorio + "\n");
			}
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
	}
    
    public static ArrayList<String> retornaDados() {
		ArrayList<String> tempArray = new ArrayList<String>();
		
		File arquivo = new File("C:\\Users\\jessi\\eclipse-workspace\\javaGames\\dados.txt");
		try {
			Scanner sc = new Scanner(arquivo);
			String novoRelatorio;
			while (sc.hasNextLine()) {
				novoRelatorio = sc.nextLine();
				tempArray.add(novoRelatorio);
				
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado");
		}
		
		return tempArray;
		
    }
    
    public static void arquivaCaixa(int vendas, double saldo) throws IOException {
		try {
			FileWriter caixa = new FileWriter("caixa.txt", false);
			PrintWriter writerSaldo = new PrintWriter(caixa);
			
			FileWriter unidades = new FileWriter("vendas.txt", false);
			PrintWriter writerVendas = new PrintWriter(unidades);
			
			String valorCaixa = Double.toString(saldo);
			writerSaldo.write(valorCaixa);
				
			String quantiaVendas = Integer.toString(vendas);
			writerVendas.write(quantiaVendas);
	
			writerSaldo.close();
			writerVendas.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
		
    }
    
    public static double retornaCaixa() {

		File arquivo = new File("C:\\Users\\jessi\\eclipse-workspace\\javaGames\\caixa.txt");
		
		double valorCaixa = Comercio.getValorEmCaixa();
		try {
			
			Scanner sc = new Scanner(arquivo);
			while (sc.hasNextLine()) {
				valorCaixa = Double.parseDouble(sc.nextLine());
				
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado");
		}
		
		return valorCaixa;
		
    }
    
    public static int retornaVendas() {

		File arquivo = new File("C:\\Users\\jessi\\eclipse-workspace\\javaGames\\vendas.txt");
		
		int quantidade = Comercio.getVendas();
		try {
			
			Scanner sc = new Scanner(arquivo);
			while (sc.hasNextLine()) {
				quantidade = Integer.parseInt(sc.nextLine());
				
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado");
		}
		
		return quantidade;
		
    }
}

