package Publico;

public abstract class pessoafisica {
	private String nome;
	private String cpf;
	private String dataNasc;
	
	public pessoafisica(String nome, String cpf, String dataNasc) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
