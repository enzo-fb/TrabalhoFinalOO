package SistemaMedico;

import java.util.ArrayList;

import Publico.pessoafisica;

public class Paciente extends pessoafisica {

	private boolean pgmtPendente;
	private ArrayList<Object> historicoMedico;
	private ArrayList<pagamento> pagamentos;

	public Paciente(String nome, String cpf, String dataNasc) {
		super(nome, cpf, dataNasc);
		this.pgmtPendente = false; // inicia automaticamente como falso
		this.historicoMedico = new ArrayList<Object>();
		this.pagamentos = new ArrayList<pagamento>();
	}

	public ArrayList<pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(pagamento pagamento) {
		this.pagamentos.add(pagamento);
		if (this.pgmtPendente == false) {
			this.setPgmtPendente(true);
		}
	}

	public void removerDivida(String id) {
		for (int i = 0; i < pagamentos.size(); i++) {
			if (pagamentos.get(i).getId_consulta().equals(id)) {
				pagamentos.remove(i);
			}
		}
		if (pagamentos.isEmpty()) {
			this.setPgmtPendente(false);
		}
	}

	public void setHistoricoMedico(ArrayList<Object> historicoMedico) {
		this.historicoMedico = historicoMedico;
	}

	public ArrayList<Object> getHistoricoMedico() {
		return historicoMedico;
	}

	public void setHistoricoMedico(Object historicoMedico) {
		this.historicoMedico.add(historicoMedico);
	}

	public void setPgmtPendente(boolean pgmtPendente) {
		this.pgmtPendente = pgmtPendente;
	}

	public boolean getPgmtPendente() {
		return pgmtPendente;
	}

	public void setPgmtPendente() {
		if (!pgmtPendente) {
			this.pgmtPendente = true;
		} else {
			this.pgmtPendente = false;
		}
	}

	@Override
	public String toString() {
		return "[Pagamento pendente: " + pgmtPendente + ", Nome: " + getNome() + ", CPF: " + getCpf()
				+ ", Data de Nascimento: " + getDataNasc() + "]";
	}

}
