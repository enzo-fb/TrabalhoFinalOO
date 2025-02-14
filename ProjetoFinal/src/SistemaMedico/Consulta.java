package SistemaMedico;

public class Consulta {
	private String data;
	private String horarioInicio;
	private int duracao;
	private String status;
	private int valor;
	private Paciente paciente;
	private Medico medico;
	private String ID;

	public Consulta(String data, String horarioInicio, int duracao, String ID, Paciente paciente, Medico medico) {
		this.data = data;
		this.horarioInicio = horarioInicio;
		this.duracao = duracao;
		this.status = "Agendada - Aguardando pagamento";
		this.valor = 150;
		this.ID = ID;
		this.paciente = paciente;
		this.medico = medico;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Consulta\t\nData: " + data + "\t\nHorário de Inicio: " + horarioInicio + "\t\nDuração: " + duracao
				+ " min" + "\t\nStatus: " + status + "\t\nValor: " + valor + "\t\nPaciente: " + paciente
				+ "\t\nMédico: " + medico;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
