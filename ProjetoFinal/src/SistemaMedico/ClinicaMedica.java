package SistemaMedico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Excecoes.EspecialidadeInvalidaException;
import Excecoes.PagamentoPendenteException;
import Gerencia.CrudDeConsulta;
import Gerencia.CrudDeExames;
import Gerencia.CrudDeMedicamentos;
import Gerencia.CrudDeMedico;
import Gerencia.CrudDePacientes;

public class ClinicaMedica {

	public static void main(String[] args) throws Exception {
		List<Prescricao> lista_prescricoes = new ArrayList<Prescricao>();
		CrudDeConsulta gerenciaConsulta = new CrudDeConsulta();
		CrudDeExames gerenciaExame = new CrudDeExames();
		CrudDeMedicamentos gerenciaMedicamento = new CrudDeMedicamentos();
		CrudDeMedico gerenciaMedico = new CrudDeMedico();
		CrudDePacientes gerenciaPacientes = new CrudDePacientes();
		//
		int escolha = 0;
		Scanner scanner = new Scanner(System.in);
		//

		do {
			System.out.println("\n\n	CLÍNICA MÉDICA FGA CENTRAL OESTE"); // nome fictício
			System.out.println("1 - Cadastro de Pacientes e Médicos\t");
			System.out.println("2 - Agendamento de Consultas\t");
			System.out.println("3 - Prescrição de Exames e Medicamentos\t");
			System.out.println("4 - Gestão de pagamentos\t");
			System.out.println("5 - Sair\t");
			escolha = scanner.nextInt();
			//

			switch (escolha) {
			case 1: {
				int decisao = 0;
				System.out.println("1 - Médico\t");
				System.out.println("2 - Paciente\t");
				System.out.println("3 - Voltar\t");

				decisao = scanner.nextInt();
				//

				switch (decisao) {
				case 1: {
					System.out.println(
							"\n\n	MENU DE MÉDICOS\t\n1 - Cadastrar\t\n2 - Consultar\t\n3 - Remover\t\n4 - Médicos\t\n5 - Voltar");
					decisao = scanner.nextInt();
					switch (decisao) {
					case 1: {
						String nome, cpf, dataNasc, crm, espec;
						System.out.println("Digite o nome do médico: ");
						nome = scanner.next();
						do {
							System.out.println("Digite o cpf do(a) " + nome + " (XXX.XXX.XXX-XX): ");
							cpf = scanner.next();
						} while (!validarFormatoCPF(cpf));
						do {
							System.out.println("Digite a data de nascimento(dd-mm-aaaa): ");
							dataNasc = scanner.next();
						} while (!ValidadorData(dataNasc));

						do {
							System.out.println("Digite o crm do " + nome + " (NNNNNN/LL): ");
							crm = scanner.next();
						} while (!validarFormatoCRM(crm));

						System.out.println("Digite a especialidade: ");
						espec = scanner.next();
						if (!gerenciaMedico.verificacao(crm)) {
							Medico med = new Medico(nome, cpf, dataNasc, crm, espec);
							gerenciaMedico.adicionar(med);
						} else {
							System.out.println("Médico já está registrado!");
						}
						break;
					}
					case 2: {
						String crm;
						System.out.println("Digite o CRM do médico que vai ser consultado: ");
						crm = scanner.next();
						Medico medico = gerenciaMedico.consultar(crm);
						if (medico != null) {
							System.out.println("Nome: " + medico.getNome());
							System.out.println("CRM: " + medico.getCrm());
							System.out.println("Especialidade: " + medico.getEspecialidade());
						}
						break;
					}
					case 3: {
						String crm;
						System.out.println("Digite o CRM do médico que vai ser removido do sistema: ");
						crm = scanner.next();
						gerenciaMedico.remover(crm);
						break;
					}
					case 4: {
						if (gerenciaMedico.listar().isEmpty()) {
							System.out.println("Nenhum médico cadastrado.");
						} else {
							for (Medico medico : gerenciaMedico.listar()) {
								System.out.println(medico);

							}
						}
						break;
					}
					case 5: {
						break;
					}

					default:
						System.out.println("Opção inválida! Tente novamente.");
					}
					break;
				}
				case 2: {
					System.out.println(
							"\n\n	MENU DE PACIENTES\t\n1 - Cadastrar\t\n2 - Consultar\t\n3 - Remover\t\n4 - Pacientes\t\n5 - Voltar");
					decisao = scanner.nextInt();
					switch (decisao) {
					case 1: {
						String nome, cpf, dataNasc;
						System.out.println("Digite o nome do paciente: ");
						nome = scanner.next();
						do {
							System.out.println("Digite o cpf do(a) " + nome + " (XXX.XXX.XXX-XX): ");
							cpf = scanner.next();
						} while (!validarFormatoCPF(cpf));
						do {
							System.out.println("Digite a data de nascimento(dd-mm-aaaa): ");
							dataNasc = scanner.next();
						} while (!ValidadorData(dataNasc));

						if (!gerenciaPacientes.verificacao(cpf)) {
							Paciente pac = new Paciente(nome, cpf, dataNasc);
							gerenciaPacientes.adicionar(pac);
						} else {
							System.out.println("Paciente já está registrado!");
						}
						break;
					}
					case 2: {
						String cpf;
						System.out.println("Digite o CPF do paciente que vai ser consultado: ");
						cpf = scanner.next();
						Paciente paciente = gerenciaPacientes.consultar(cpf);
						if (paciente != null) {
							System.out.println("Nome: " + paciente.getNome());
							System.out.println("CPF: " + paciente.getCpf());
							System.out.println("Data de nascimento: " + paciente.getDataNasc());
						}
						break;
					}
					case 3: {
						String cpf;
						System.out.println("Digite o CPF do paciente que vai ser removido do sistema: ");
						cpf = scanner.next();
						gerenciaPacientes.remover(cpf);
						break;
					}
					case 4: {
						if (gerenciaPacientes.listar().isEmpty()) {
							System.out.println("Nenhum paciente cadastrado.");
						} else {
							for (Paciente paciente : gerenciaPacientes.listar()) {
								System.out.println(paciente);
							}
						}
						break;
					}
					case 5: {
						break;
					}

					default:
						System.out.println("Opção inválida! Tente novamente.");
					}
					break;
				}
				}
				break;
			}

			// #################################### CONSULTA //
			// ######################################################################
			case 2: {
				int k = 0;
				do {
					System.out.println(
							"\n\n	MENU DE CONSULTA\t\n1 - Adicionar consulta\t\n2 - Procurar consulta existente\t\n3 - Remover Consulta\t\n4 - Lista de consultas existentes\t\n5 - Voltar ao menu principal");
					k = scanner.nextInt();
					switch (k) {
					case 1: {
						String data, especialidade, hora_inicio, id, cpf, crm;
						int duracao;
						do {
							System.out.println("Digite a especialidade a qual deseja(tudo em letra minúscula): ");
							especialidade = scanner.next();
							System.out.println("Digite a data da consulta (DD-MM-AAAA): ");
							data = scanner.next();
							if (!ValidadorData(data)) {
								System.out.println(
										"Modelo de data inválido!\nPor favor, digite a data conforme o modelo apresentado!\n\n");
							}
						} while (!ValidadorData(data));
						System.out.println("Digite a hora de inicio da consulta: ");
						hora_inicio = scanner.next();
						System.out.println("Digite um id para a consulta: ");
						id = scanner.next();
						System.out.println("Digite, em minutos, o tempo de duração: ");
						duracao = scanner.nextInt();
						do {
							System.out.println("Digite o CPF do paciente (XXX.XXX.XXX-XX): ");
							cpf = scanner.next();
							if (!validarFormatoCPF(cpf)) {
								System.out.println(
										"Formato de CPF inválido!\nPor favor, digite o CPF conforme o modelo\n");
							}
						} while (!validarFormatoCPF(cpf) || !gerenciaPacientes.verificacao(cpf));
						do {
							System.out.println("Digite o CRM do médico (NNNNNN/EE): ");
							crm = scanner.next();
							if (!validarFormatoCRM(crm)) {
								System.out
										.println("CRM inválido!\nPor favor, digite conforme o modelo apresentado\n\n");
							}
							if (!gerenciaMedico.verificacao(crm)) {
								System.out.println("CRM não encontrado!\n\n");
							}
							;
							if (!gerenciaMedico.consultar(crm).getEspecialidade().equals(especialidade)) {
								throw new EspecialidadeInvalidaException(
										"Especialidade passada incompatível com médico indicado!");
							}
						} while (!validarFormatoCRM(crm) || !gerenciaMedico.verificacao(crm));
						if (gerenciaPacientes.consultar(cpf).getPgmtPendente()) {
							throw new PagamentoPendenteException(
									"Não foi possivel concluir a marcação, pois o paciente possui pendências financeiras!");
						}
						Paciente paciente = gerenciaPacientes.consultar(cpf);
						Consulta nova_consulta = new Consulta(data, hora_inicio, duracao, id, paciente,
								gerenciaMedico.consultar(crm));
						pagamento pag = new pagamento();
						pag.setId_consulta(id);
						pag.setPagamento(nova_consulta.getValor());
						gerenciaPacientes.consultar(cpf).setPagamentos(pag);
						gerenciaConsulta.adicionar(nova_consulta);
						break;
					}
					case 2: {
						String id;
						System.out.println("Digite o ID da consulta: ");
						id = scanner.next();
						Consulta consulta = gerenciaConsulta.consultar(id);
						if (consulta != null) {
							System.out.println("Consulta " + consulta.getID());
							System.out.println("Paciente: " + consulta.getPaciente());
							System.out.println("Médico: " + consulta.getMedico());
							System.out.println("Status: " + consulta.getStatus());
							System.out.println("Data: " + consulta.getData());
							System.out.println("Hora de início: " + consulta.getHorarioInicio());
							System.out.println("Tempo de duração da consulta: " + consulta.getDuracao() + " min");
						} else {
							System.out.println("Consulta não encontrada!");
						}
						break;
					}
					case 3: {
						String id;
						System.out.println("Digite o ID da consulta a ser removida: ");
						id = scanner.next();
						if (gerenciaConsulta.consultar(id).getStatus().equals("Agendada - Aguardando pagamento")) {
							throw new PagamentoPendenteException(
									"Não foi possível retirar consulta, pagamento pendente!");
						}
						gerenciaConsulta.consultar(id).setStatus("Concluída");
						gerenciaConsulta.remover(id);
						break;
					}
					case 4: {
						if (gerenciaConsulta.listar().isEmpty()) {
							System.out.println("Nenhuma consulta cadastrada.");
						} else {
							for (Consulta consulta : gerenciaConsulta.listar()) {
								System.out.println(consulta);
							}
						}
						break;
					}
					case 5: {
						break;
					}
					default:
						System.out.println("Escolha uma opção válida!");
					}
				} while (k != 5);
				break;
			}
			// ########################################################
			case 3: {
				String crm;
				System.out.println(
						"Para cadastrar, remover ou consultar prescrições, é necessário o CRM do médico!\nPor favor, digite o CRM: ");
				crm = scanner.next();
				if (gerenciaMedico.verificacao(crm)) {
					int x = 0;
					System.out.println("	MENU PRESCRIÇÕES\t\n\n1 - Cadastrar\t\n2 - Consultar\t\n3 - Voltar\t\n");
					x = scanner.nextInt();

					switch (x) {
					case 1: {
						Prescricao nova_presc;
						String consultaassoc, id;
						System.out.println("Digite o ID da consulta para a prescrição: ");
						id = scanner.next();

						if (gerenciaConsulta.consultar(id) != null) {
							String data_validade = null;
							do {
								System.out.println("Digite a data de validade desta prescrição: ");
								data_validade = scanner.next();
							} while (!ValidadorData(data_validade));
							nova_presc = new Prescricao(gerenciaConsulta.consultar(id), data_validade);
						} else {
							System.out.println("Paciente não encontrado!");
							break;
						}
						System.out.println("Deseja adicionar algum exame na prescrição?\n1 - Sim\t\n2 - Não\t");
						x = scanner.nextInt();
						if (x == 1) {
							int y = 0;
							do {
								String tipo, datapres;
								System.out.println("Digite o tipo de exame: ");
								tipo = scanner.next();
								System.out.println("Digite a data de prescrição: ");
								datapres = scanner.next();
								Exame exame = new Exame(tipo, datapres);
								gerenciaExame.adicionar(exame);
								gerenciaConsulta.consultar(id).getPaciente().setHistoricoMedico(exame);
								nova_presc.setexamesPrescritos(exame);
								pagamento pag = new pagamento();
								pag.setPagamento(gerenciaExame.consultar(tipo).getCusto());
								pag.setId_consulta(id);
								gerenciaConsulta.consultar(id).getPaciente().setPagamentos(pag);
								System.out.println(
										"Deseja adicionar mais algum exame na prescrição?\n1 - Sim\t\n2 - Não\t");
								y = scanner.nextInt();
							} while (y != 2);
						}
						System.out.println("Deseja adicionar algum medicamento na prescrição?\n1 - Sim\t\n2 - Não\t");
						x = scanner.nextInt();
						if (x == 1) {
							int z = 0;
							do {
								String nome_med;
								System.out.println("Digite o nome do medicamento: ");
								nome_med = scanner.next();
								if (gerenciaMedicamento.verificacao(nome_med)) {
									nova_presc.setmedicamentos(gerenciaMedicamento.consultar(nome_med));
								} else {
									Medicamento novo_medicamento = new Medicamento(nome_med);
									gerenciaMedicamento.adicionar(novo_medicamento);
									nova_presc.setmedicamentos(novo_medicamento);
								}
								System.out.println(
										"Deseja adicionar mais algum medicamento na prescrição?\n1 - Sim\t\n2 - Não\t");
								z = scanner.nextInt();
							} while (z != 2);
						}
						lista_prescricoes.add(nova_presc);
						break;
					}
					case 2: {
						if (lista_prescricoes.isEmpty()) {
							System.out.println("Nenhuma prescrição cadastrada.");
						} else {
							for (Prescricao p : lista_prescricoes) {
								System.out.println(p);
								System.out.println("----------------------");
							}
						}
						break;
					}

					case 3: {

						break;
					}

					}

				} else {
					System.out.println("CRM INVÁLIDO!");
					break;
				}
				break;
			}
			case 4: {
				int h = 0;
				do {
					System.out.println(
							"\n\n	GESTÃO DE PAGAMENTOS\t\n1 - Consultar pacientes com pagamentos pendentes\t\n2 - Quitar pendência\t\n3 - Voltar pro Menu Principal");
					h = scanner.nextInt();
					switch (h) {
					case 1: {
						for (Paciente p : gerenciaPacientes.listar()) {
							if (p.getPgmtPendente()) {
								System.out.println(p);
							}
							break;
						}

						break;
					}
					case 2: {
						String cpf;
						String id;
						int opc;
						do {
							System.out.println("Digite o CPF do paciente: ");
							cpf = scanner.next();

							if (!gerenciaPacientes.consultar(cpf).getPgmtPendente()) {
								System.out.println("Paciente sem obrigações financeiras. ");
							} else {
								System.out.println("\nPagamentos em aberto: \n");
								for (pagamento x : gerenciaPacientes.consultar(cpf).getPagamentos()) {

									System.out.println(x);

								}
								System.out.println("Digite o ID da consulta que deseja pagar: ");
								id = scanner.next();
								gerenciaPacientes.consultar(cpf).removerDivida(id);
								gerenciaConsulta.consultar(id).setStatus("Agendada - Pagamento Efetuado");
							}

							System.out.println("Deseja realizar novamente a operação [1-Sim/2-Não]?");
							opc = scanner.nextInt();
						} while (opc != 2);

						break;
					}
					case 3: {

						break;
					}
					default:
						System.out.println("Opção inválida!\nEscolha uma das opções!\n\n");
					}
					break;
				} while (h != 3);
				break;
			}
			case 5: {
				System.out.println("Saindo...");
				break;
			}

			}
		} while (escolha != 5);

	}

	private static boolean ValidadorData(String data) {

		String padrao = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";

		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = pattern.matcher(data);

		return matcher.matches();
	}

	public static boolean validarFormatoCPF(String cpf) {

		String padrao = "^(\\d{3})\\.(\\d{3})\\.(\\d{3})-(\\d{2})$";

		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = pattern.matcher(cpf);

		return matcher.matches();
	}

	public static boolean validarFormatoCRM(String crm) {

		String padrao = "^(\\d{4,6})/(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$";

		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = pattern.matcher(crm);

		return matcher.matches();
	}
}
