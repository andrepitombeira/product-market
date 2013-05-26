/**
 * Método abstrato para os participantes
 */
package br.ufc.si.andre.participantes;

public class Participantes {
	/**
	 * Atributos
	 */
	protected String nome;
	protected double cpf;
	protected String email;
	protected double codigo;

	/**
	 * Construtor
	 * 
	 * @param nome
	 * @param cpf
	 * @param email
	 * 
	 */
	public Participantes(String nome, double cpf, String email, double codigo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.codigo = codigo;

	}

	/**
	 * Métodos getteres e setteres
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCpf() {
		return cpf;
	}

	public void setCpf(double cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCodigo() {
		return codigo;
	}

	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}

}
