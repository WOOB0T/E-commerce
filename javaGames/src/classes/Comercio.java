package classes;
import java.util.ArrayList;

public class Comercio {
	
    public static ArrayList<Produto> produtos = new ArrayList<>();
    private static ArrayList<String> relatorios = new ArrayList<>();
    private static double valorEmCaixa = 50000;
    private static int quantiaDeVendas;
    
    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    public static void setProdutos(ArrayList<Produto> produtos) {
    	Comercio.produtos = produtos;
    }
    
    public static ArrayList<String> getRelatorios() {
        return relatorios;
    }
    
    public static void setRelatorios(ArrayList<String> relatorios) {
    	Comercio.relatorios = relatorios;
    }
    
    
    public static double getValorEmCaixa() {
        return valorEmCaixa;
    }
    
    public static void setValorEmCaixa(double valor) {
       Comercio.valorEmCaixa = valor;
    }
    
    public static int getVendas() {
    	return quantiaDeVendas;
    }
    
    public static void setVendas(int quantidade) {
    	quantiaDeVendas = quantidade;
    }

    // #1 - LISTAR:
    public static ArrayList<Produto> listarProdutos() {
    	return produtos;
    			
    }
    
    public static ArrayList<Produto> listarCategoria(ArrayList<Produto> lista, int codigo) {
    	String categoria = categoriasDeProduto(codigo);
    	ArrayList <Produto> produtosCategoria = new ArrayList<>();
    	for (Produto produto : lista) {
    		if (produto.categoria.equals(categoria)) {
    			produtosCategoria.add(produto);
    		}
    		
    	}
    	
    	 return produtosCategoria;
    	 
    }
    

    // #2 - CADASTRAR:

    public static Produto cadastrarProduto(ArrayList<Produto> lista, String nome, double custoDeCompra, double valorDeVenda, String categoria) {
        Produto produto = new Produto(nome, custoDeCompra, valorDeVenda, categoria);
        if (!lista.contains(produto)) {
        	lista.add(produto);
        }
       
        return produto;
    }
    
    public static Jogos cadastrarJogos(ArrayList<Produto> lista, String nome, double custoDeCompra, double valorDeVenda, String categoria,  String plataforma) {
    	Jogos jogo = new Jogos(nome, custoDeCompra, valorDeVenda, categoria, plataforma);
    	 if (!lista.contains(jogo)) {
         	lista.add(jogo);
         }
        
         return jogo;
    }
    
    public static Informatica cadastrarItem(ArrayList<Produto> lista, String nome, double custoDeCompra, double valorDeVenda, String categoria,  String processador) {
    	Informatica item = new Informatica(nome, custoDeCompra, valorDeVenda, categoria, processador);
    	 if (!lista.contains(item)){
          	lista.add(item);
          	
          }
         
          return item;
    }
    
    public static Acessorios cadastrarAcessorio(ArrayList<Produto> lista, String nome, double custoDeCompra, double valorDeVenda, String categoria,  String conector) {
    	Acessorios acessorio = new Acessorios(nome, custoDeCompra, valorDeVenda, categoria, conector);
    	 if (!lista.contains(acessorio)){
          	lista.add(acessorio);
          	
          }
         
          return acessorio;
    }
    
    // #3 - ADICIONAR:


    public static boolean comprarProduto(Produto produto, int quantidade) {
        
        double custo = produto.getCustoDeCompra() * quantidade;
        boolean add = false;
        
        if (custo <= Comercio.getValorEmCaixa()) {
        add = produto.adicionarEstoque(quantidade);
        
        }
        
        if (add == true) {
        Comercio.valorEmCaixa -= custo;
        return true;
        
        }  
        
        return false;
    }
    
    // #4 - REMOVER:
    
    public static void removerProduto(Produto produto) {
    	produtos.remove(produto);
    	
    }
    
    // #5 - VENDER:
    
    public static void venderProduto(Produto produto, int quantidade) {
    	
    	boolean add = produto.removerEstoque(quantidade);
    	
    	if (add == true) {
    		Comercio.quantiaDeVendas += quantidade;
    		double lucro = produto.getValorDeVenda() * quantidade;
    	
    		valorEmCaixa += lucro;
    	
    	}
    }
    
    // #6 - RELATORIO (A FAZER):
    
    public static void adicionarRelatorio(String relatorio) {
    	relatorios.add(relatorio);
    	
    }
    
    public static String imprimirRelatorio() {
    	if (relatorios != null) {
    		for (String relatorio : relatorios) {
    			return relatorio;
    			}
    		
    		}
    	
    	return null;
    	
    	}
    
    // Funções de auxilio:
    
    public static Produto pesquisarProduto(int codigo) {
    	for (Produto produto : produtos) {
    		if (produto.getCodigo() == codigo) {
    			return produto;
    		}
    	}
    	
    	return null;
    
    }
    
    public static String categoriasDeProduto(int codigo) {
    	String categoria;
    	switch(codigo) {
 
    	case 1:
    		categoria = "Jogos";
    		break;
    	case 2:
    		categoria = "Informática";
    		break;
    	case 3:
    		categoria = "Acessórios";
    		break;
    	default:
    		categoria = "Opção Inválida";
    		break;
    	}
    	
    	return categoria;	
    	
    }
    
    public static boolean consultarLista(ArrayList<Produto> lista ) {
    if (lista.isEmpty()) {
    	return false;
    }
    
    return true; 
    
    }
    
    
    
    
}