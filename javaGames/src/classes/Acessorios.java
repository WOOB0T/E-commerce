package classes;

public class Acessorios extends Produto {
	protected String conector;

	public Acessorios(String nome, double custoDeCompra, double valorDeVenda, String categoria, String conector) {
		super(nome, custoDeCompra, valorDeVenda, categoria);
		this.conector = conector;
	}
	
	public static String conector(int codigo) {
		
		if (codigo == 1) {
			return "Com fio";
		} else if (codigo == 2) {
			return "Bluetooth";
		}
		
		return "Desconhecido";
	}
	
	@Override
    public String getDetalhe() {
    return conector;
	}
    
    @Override
    public String listarDetalhe() {
    	String detalhe = this.getDetalhe();
    	return "Conector: " + detalhe;
    }
    
}

