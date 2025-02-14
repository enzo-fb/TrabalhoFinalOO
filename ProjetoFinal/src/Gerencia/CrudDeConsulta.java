package Gerencia;

import java.util.ArrayList;
import java.util.List;

import Excecoes.HorarioIndisponivelException;
import Excecoes.PagamentoPendenteException;
import SistemaMedico.Consulta;

public class CrudDeConsulta extends Crud<Consulta> {
	private List<Consulta> consultas = new ArrayList<Consulta>();

	@Override
	public void adicionar(Consulta nova_consulta) throws HorarioIndisponivelException, PagamentoPendenteException {
		for (int i = 0; i < consultas.size(); i++) {
			if (consultas.get(i).getData().equals(nova_consulta.getData())
					&& consultas.get(i).getMedico().equals(nova_consulta.getMedico())
					&& consultas.get(i).getHorarioInicio().equals(nova_consulta.getHorarioInicio())) {
				throw new HorarioIndisponivelException("Médico indisponível neste horário!");
			}
			if (consultas.get(i).getPaciente().equals(nova_consulta.getPaciente())
					&& consultas.get(i).getData().equals(nova_consulta.getData())) {
				System.out.println(
						"Não foi possível concluir a marcação, pois o paciente/médico possui outra consulta marcada para o mesmo dia!");
				return;
			}
		}

		consultas.add(nova_consulta);
		nova_consulta.getPaciente().setPgmtPendente(true);
		nova_consulta.getPaciente().setHistoricoMedico(nova_consulta);
		nova_consulta.getMedico().setHistoricoMedico(nova_consulta);

		System.out.println("Consulta adicionada com sucesso!");

	}

	@Override
	public Consulta consultar(String id) {
		for (int i = 0; i < consultas.size(); i++) {
			if (consultas.get(i).getID().equals(id)) {
				return consultas.get(i);
			}
		}
		System.out.println("Consulta não encontrada!");
		return null;
	}

	@Override
	public void atualizar(String id, Consulta nova_consulta) {
		for (int i = 0; i < consultas.size(); i++) {
			if (consultas.get(i).getID().equals(id)) {
				consultas.remove(i);
				consultas.add(nova_consulta);
				nova_consulta.getPaciente().setHistoricoMedico(nova_consulta);
				nova_consulta.getMedico().setHistoricoMedico(nova_consulta);
				System.out.println("Consulta alterada com sucesso!");
				return;
			}
		}
		System.out.println("Consulta não encontrada no sistema");
		return;
	}

	@Override
	public void remover(String id) {
		for (int i = 0; i < consultas.size(); i++) {
			if (consultas.get(i).getID().equals(id)) {
				consultas.remove(i);
				System.out.println("Consulta removida com sucesso!");
				return;
			}

		}
		System.out.println("Consulta não encontrada!");

	}

	@Override
	public List<Consulta> listar() {
		return consultas;
	}

}
