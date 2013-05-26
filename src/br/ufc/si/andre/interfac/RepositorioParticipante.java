/**
 * Interface para o Repositorio de Participantes
 */
package br.ufc.si.andre.interfac;

import br.ufc.si.andre.participantes.Participantes;

public interface RepositorioParticipante {

	public void adicionarParticipante(Participantes p);

	public void excluirParticipante(double cpf);

}
