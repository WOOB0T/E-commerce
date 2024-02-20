package classes;

public class Informatica extends Produto {
	protected String processador;

	public Informatica(String nome, double custoDeCompra, double valorDeVenda, String categoria, String processador) {
		super(nome, custoDeCompra, valorDeVenda, categoria);
		this.processador = processador;
	}
	
	public static String processador(int codigo) {
		
		if (codigo == 1) {
			return "AMD Ryzen";
		} else {
			return "Intel Core";
		}
	}
	
	@Override
    public String getDetalhe() {
    return processador;
	}
    
    @Override
    public String listarDetalhe() {
    	String detalhe = this.getDetalhe();
    	return "Processador: " + detalhe;
    }
    
}



