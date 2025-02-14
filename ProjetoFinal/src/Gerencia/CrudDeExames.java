package Gerencia;

import java.util.ArrayList;
import java.util.List;

import SistemaMedico.Exame;

public class CrudDeExames extends Crud<Exame> {
	private List<Exame> exames = new ArrayList<Exame>();

	@Override
	public void adicionar(Exame variavel) {
		for (int i = 0; i < exames.size(); i++) {
			if (exames.get(i).equals(variavel)) {
				System.out.println("Exame já existente");
				return;
			}
		}
		exames.add(variavel);
		System.out.println("Exame registrado!");
	}

	@Override
	public Exame consultar(String tipo) {
		for (int i = 0; i < exames.size(); i++) {
			if (exames.get(i).getTipo().equals(tipo)) {
				return exames.get(i);
			}
		}
		System.out.println("Exame não encontrado!");
		return null;
	}

	@Override
	public void atualizar(String tipo, Exame novoExame) {
		for (int i = 0; i < exames.size(); i++) {
			if (exames.get(i).getTipo().equals(novoExame.getTipo())
					&& exames.get(i).getDataPrescricao().equals(novoExame.getDataPrescricao())) {
				exames.remove(i);
				exames.add(novoExame);
				System.out.println("Exame atualizado com sucesso!");
				return;
			}
		}
		System.out.println("Exame não encontrado!");
	}

	@Override
	public void remover(String dataPresc) {
		for (int i = 0; i < exames.size(); i++) {
			if (exames.get(i).getDataPrescricao().equals(dataPresc)) {
				exames.remove(i);
				System.out.println("Exame removido com sucesso!");
				return;
			}
		}
		System.out.println("Exame informado não encontrado!");

	}

	@Override
	public List<Exame> listar() {
		return exames;
	}

}
