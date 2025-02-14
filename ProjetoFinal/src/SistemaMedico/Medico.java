package SistemaMedico;

import java.util.ArrayList;

import Publico.pessoafisica;

public class Medico extends pessoafisica {
	private String crm;
	private String especialidade;
	private ArrayList<Object> historicoMedico;

	public Medico(String nome, String cpf, String dataNasc, String crm, String espec) {
		super(nome, cpf, dataNasc);
		this.crm = crm;
		this.especialidade = espec;
		this.historicoMedico = new ArrayList<Object>();
	}

	public ArrayList<Object> getHistoricoMedico() {
		return historicoMedico;
	}

	public void setHistoricoMedico(Object novo) {
		this.historicoMedico.add(novo);
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Override
	public String toString() {
		return "[Nome: " + getNome() + ", Especialidade:" + getEspecialidade() + ", CRM: " + getCrm() + "]";
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
