package Gerencia;

import java.util.ArrayList;
import java.util.List;

import SistemaMedico.Medico;

public class CrudDeMedico extends Crud<Medico> {
	private List<Medico> medicos = new ArrayList<Medico>();

	@Override
	public void adicionar(Medico doutor) {
		for (int i = 0; i < medicos.size(); i++) {
			if (medicos.get(i) == doutor) {
				System.out.println("Médico já cadastrado!");
				return;
			}
		}
		medicos.add(doutor);
		System.out.println("Médico cadastrado com sucesso!");
	}

	@Override
	public Medico consultar(String crm) {
		for (int i = 0; i < medicos.size(); i++) {
			if (medicos.get(i).getCrm().equals(crm)) {
				return medicos.get(i);
			}
		}
		System.out.println("Médico não encontrado!");
		return null;
	}

	public boolean verificacao(String crm) {
		for (int i = 0; i < medicos.size(); i++) {
			if (medicos.get(i).getCrm().equals(crm)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void atualizar(String cpf, Medico pacienteNovo) {
		for (int i = 0; i < medicos.size(); i++) {
			if (medicos.get(i).getCpf() == cpf) {
				medicos.remove(i);
				medicos.add(pacienteNovo);
				System.out.println("Sistema atualizado!");
				return;
			}
		}
		System.out.println("Médico informado não encontrado!");

	}

	@Override
	public void remover(String cpf) {
		for (int i = 0; i < medicos.size(); i++) {
			if (medicos.get(i).getCpf() == cpf) {
				medicos.remove(i);
				System.out.println("Médico removido com sucesso!");
				return;
			}
		}
		System.out.println("Médico não encontrado em nosso sistema!");

	}

	@Override
	public List<Medico> listar() {
		return medicos;
	}

}
