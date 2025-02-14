package SistemaMedico;

public class pagamento {
	private int pagamento;
	private String id_consulta;

	public pagamento() {
		this.pagamento = 0;

	}

	public int getPagamento() {
		return pagamento;
	}

	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public String toString() {
		return "ID Consulta: " + id_consulta + "\nValor: R$" + pagamento + ",00\n";
	}

	public String getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(String id_consulta) {
		this.id_consulta = id_consulta;
	}

}
