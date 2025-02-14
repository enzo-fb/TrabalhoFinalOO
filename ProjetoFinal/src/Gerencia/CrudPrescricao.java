package Gerencia;

import java.util.ArrayList;
import java.util.List;

import Excecoes.HorarioIndisponivelException;
import Excecoes.PagamentoPendenteException;
import SistemaMedico.Prescricao;

public class CrudPrescricao extends Crud<Prescricao> {

	private List<Prescricao> prescricoes = new ArrayList<Prescricao>();

	@Override
	public void adicionar(Prescricao variavel) throws HorarioIndisponivelException, PagamentoPendenteException {
		prescricoes.add(variavel);
	}

	@Override
	public Prescricao consultar(String data) {
		for (int i = 0; i < prescricoes.size(); i++) {
			if (prescricoes.get(i).getDataValidade().equals(data)) {
				return prescricoes.get(i);
			}
		}
		return null;
	}

	@Override
	public void atualizar(String cpf, Prescricao pacienteNovo) {
		// TODO Stub de método gerado automaticamente

	}

	@Override
	public void remover(String cpf) {
		// TODO Stub de método gerado automaticamente

	}

	@Override
	public List<Prescricao> listar() {
		// TODO Stub de método gerado automaticamente
		return null;
	}

}
