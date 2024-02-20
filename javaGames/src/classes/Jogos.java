package classes;

public class Jogos extends Produto {
	protected String plataforma;

	public Jogos(String nome, double custoDeCompra, double valorDeVenda, String categoria, String plataforma) {
		super(nome, custoDeCompra, valorDeVenda, categoria);
		this.plataforma = plataforma;
	}
	
	@Override
    public String getDetalhe() {
    return plataforma;
    
    }
	
    @Override
    public String listarDetalhe() {
    	String detalhe = this.getDetalhe();
    	return "Plataforma: " + detalhe;
    }
}
