/**
 * Classe de repositorio de participantes
 */
package br.ufc.si.br.mercado;

import java.util.Vector;

import br.ufc.si.andre.interfac.RepositorioParticipante;
import br.ufc.si.andre.negocio.Sistema;
import br.ufc.si.andre.participantes.Participantes;

public class MercadoArrayParticipante implements RepositorioParticipante {

	Sistema sistema = new Sistema();
	Vector<Participantes> participantes = new Vector<Participantes>();

	/**
	 * Metodo que adiciona um participante
	 */
	public void adicionarParticipante(Participantes p) {
		participantes.add(p);
	}

	/**
	 * Metodo que exclui um participante
	 */
	public void excluirParticipante(double cpf) {
		int index = sistema.buscaParticipante(cpf);
		participantes.remove(index);
	}

}
