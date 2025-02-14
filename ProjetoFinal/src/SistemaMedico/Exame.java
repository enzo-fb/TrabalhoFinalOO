package SistemaMedico;

public class Exame {

	private String tipo;
	private String dataPrescricao;
	private String dataRealizacao;
	private String resultado;
	private int custo;

	public Exame(String tipo, String dataPrescricao) {
		super();
		this.tipo = tipo;
		this.dataPrescricao = dataPrescricao;
		this.dataRealizacao = "Não feito";
		this.custo = 150;
		this.resultado = "Sem resultado";

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDataPrescricao() {
		return dataPrescricao;
	}

	public void setDataPrescricao(String dataPrescricao) {
		this.dataPrescricao = dataPrescricao;
	}

	public String getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}

	@Override
	public String toString() {
		return "Exame\n Tipo: " + tipo + "\nData de Prescrição: " + dataPrescricao + "\nData de Realização: "
				+ dataRealizacao + "\nResultado: " + resultado + "\nCusto: " + custo;
	}
}
