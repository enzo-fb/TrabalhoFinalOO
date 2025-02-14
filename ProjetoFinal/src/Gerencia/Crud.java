package Gerencia;

import java.util.List;

import Excecoes.HorarioIndisponivelException;
import Excecoes.PagamentoPendenteException;

abstract class Crud <T>{ // o T é pra mostrar que é genérico
	
	public abstract void adicionar(T variavel) throws HorarioIndisponivelException, PagamentoPendenteException;
	public abstract T consultar(String cpf);
	public abstract void atualizar(String cpf, T pacienteNovo);
	public abstract void remover(String cpf);
	public abstract List<T> listar();
}
