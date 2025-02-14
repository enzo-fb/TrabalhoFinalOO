package Gerencia;

import java.util.ArrayList;
import java.util.List;

import SistemaMedico.Paciente;

public class CrudDePacientes extends Crud<Paciente> {
	private List<Paciente> pacientes = new ArrayList<Paciente>();

	public void adicionar(Paciente paciente_new) {
		pacientes.add(paciente_new);
		if (!pacientes.add(paciente_new)) {
			System.out.println("Erro!\nPaciente não adicionado!");
		}
	}

	public Paciente consultar(String cpf) {
		for (int i = 0; i < pacientes.size(); i++) {
			if (pacientes.get(i).getCpf().equals(cpf)) {
				return pacientes.get(i);
			}
		}
		System.out.println("Paciente não encontrado!");
		return null;
	}

	public boolean verificacao(String cpf) {
		for (int i = 0; i < pacientes.size(); i++) {
			if (pacientes.get(i).getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	public void atualizar(String cpf, Paciente pacienteNovo) {
		for (int i = 0; i < pacientes.size(); i++) {
			if (pacientes.get(i).getCpf() == cpf) {
				pacientes.remove(i);
				pacientes.add(pacienteNovo);
				return;
			}
		}
		System.out.println("Paciente não encontrado!");

	}

	public void remover(String cpf) {
		for (int i = 0; i < pacientes.size(); i++) {
			if (pacientes.get(i).getCpf().equals(cpf)) {
				pacientes.remove(i);
				System.out.println("Removido com sucesso!");
				return;
			}
		}
		System.out.println("Paciente não encontrado!");

	}

	public List<Paciente> listar() {
		return pacientes;
	}

}
