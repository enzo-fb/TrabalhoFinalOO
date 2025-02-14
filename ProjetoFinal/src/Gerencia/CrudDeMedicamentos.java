package Gerencia;

import java.util.ArrayList;
import java.util.List;

import SistemaMedico.Medicamento;

public class CrudDeMedicamentos extends Crud<Medicamento> {
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

	@Override
	public void adicionar(Medicamento novoMedicamento) {
		for (int i = 0; i < medicamentos.size(); i++) {
			if (medicamentos.get(i).getNome().equals(novoMedicamento.getNome())) {
				System.out.println("Já existe esse medicamento no banco de medicamentos!");
				return;
			}
		}
		medicamentos.add(novoMedicamento);
	}

	@Override
	public Medicamento consultar(String medicamento) {
		for (int i = 0; i < medicamentos.size(); i++) {
			if (medicamentos.get(i).equals(medicamento)) {
				return medicamentos.get(i);
			}
		}
		return null;
	}

	public boolean verificacao(String nome) {

		for (int i = 0; i < medicamentos.size(); i++) {
			if (medicamentos.get(i).getNome().equals(nome)) {
				return true;
			}

		}
		return false;
	}

	@Override
	public void atualizar(String nome, Medicamento novoMedicamento) {
		for (int i = 0; i < medicamentos.size(); i++) {
			if (medicamentos.get(i).getNome().equals(nome)) {
				medicamentos.remove(i);
				medicamentos.add(novoMedicamento);
				return;
			}
		}

	}

	@Override
	public void remover(String nome) {
		for (int i = 0; i < medicamentos.size(); i++) {
			if (medicamentos.get(i).getNome().equals(nome)) {
				medicamentos.remove(i);
			}
		}

	}

	@Override
	public List<Medicamento> listar() {
		return medicamentos;
	}

}
