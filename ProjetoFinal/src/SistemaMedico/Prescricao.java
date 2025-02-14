package SistemaMedico;

import java.util.ArrayList;
import java.util.List;

public class Prescricao {
	private Consulta consultaAssociada;
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	private List<Exame> examesPrescritos = new ArrayList<Exame>();
	private String dataValidade;

	public Prescricao(Consulta consultaAssociada, String dataValidade) {
		this.consultaAssociada = consultaAssociada;
		this.dataValidade = dataValidade;

	}

	public Consulta getConsultaAssociada() {
		return consultaAssociada;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public List<Exame> getExamesPrescritos() {
		return examesPrescritos;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setexamesPrescritos(Exame exame) {
		examesPrescritos.add(exame);
		consultaAssociada.getMedico().setHistoricoMedico(exame);
	}

	public void setmedicamentos(Medicamento med) {
		medicamentos.add(med);
	}

	@Override
	public String toString() {
		return "Prescricao [Consulta Associada: " + consultaAssociada + ", Medicamentos: =" + medicamentos
				+ ", Exames Prescritos: " + examesPrescritos + ", Data Validade: " + dataValidade + "]";
	}

}
