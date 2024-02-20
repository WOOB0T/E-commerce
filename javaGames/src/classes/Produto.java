package classes;

public class Produto {

    // A variável serve como um contador que autoincrementa o codigo do produto!
    protected static int contador;

    protected int codigo;
    protected String nome;
    protected int estoque;
    protected String categoria;
    protected double custoDeCompra;
    protected double valorDeVenda;

    public Produto(String nome, double custoDeCompra, double valorDeVenda, String categoria) {
    	contador++;
    	this.codigo = contador;
        this.nome = nome;
        this.custoDeCompra = custoDeCompra;
        this.valorDeVenda = valorDeVenda;
        this.categoria = categoria;
        
    // Getters da classe:
        
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getCustoDeCompra() {
        return custoDeCompra;
    }

    public double getValorDeVenda() {
        return valorDeVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    // Setters da classe:
    
    public boolean adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            estoque += quantidade;
            return true;
        }
        
        return false;
        
        // Caso o estoque seja alterado, retorna true, caso o contrário, false.
        // Utilizaremos esse boolean de retorno para confirmação no método "comprarEstoque" do comércio.
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade <= getEstoque()) {
            estoque -= quantidade;
            return true;
        }
        
        return false;
        
        // Utilizaremos esse boolean de retorno para confirmação no método "venderProduto" do comércio.
 
    }
    
    public String getDetalhe() {
    	return null;
    }
   
    public String listarDetalhe() {
    	return null;
    }
} 