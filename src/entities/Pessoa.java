package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pessoa {

	private String nome;
	private Date dataDeNascimento;
	private double altura;

	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	public Pessoa(String nome, Date dataDeNascimento, double altura) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.altura = altura;
	}

	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "O nome é " + this.nome + ", nasceu em " + this.sdf.format(this.dataDeNascimento) + " , a altura é de "
				+ this.altura + " e a idade eh de: " + informaIdade();
	}

	public int informaIdade() {
		Calendar nascimentoCalendar = Calendar.getInstance();
		nascimentoCalendar.setTime(dataDeNascimento);

		Calendar localDateCalendar = Calendar.getInstance();

		int idade = localDateCalendar.get(Calendar.YEAR) - nascimentoCalendar.get(Calendar.YEAR);

		if (nascimentoCalendar.get(Calendar.MONTH) > localDateCalendar.get(Calendar.MONTH)) {
			idade -= 1;
		} else if (nascimentoCalendar.get(Calendar.MONTH) == localDateCalendar.get(Calendar.MONTH)
				&& nascimentoCalendar.get(Calendar.DAY_OF_MONTH) > localDateCalendar.get(Calendar.DAY_OF_MONTH)) {
			idade -= 1;
		}

		return idade;

	}
}
