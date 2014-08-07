package com.projeto.facade;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.projeto.exception.*;
import com.projeto.negocios.*;

public class GestorAuxiliarParaSistema {

	//private List<Aula> aulas = new LinkedList<Aula>();
	private List<GrupoDiscussao> grupos = new LinkedList<GrupoDiscussao>();
	private List<Arquivo> arquivos = new LinkedList<Arquivo>();

	private List<Mensagem> mensagens = new ArrayList<>();

	public void enviarMensagem(Aluno origem, Aluno destino, String texto) {

		Mensagem mensagem = new Mensagem();
		mensagem.setDestino(destino);
		mensagem.setOrigem(origem);
		mensagem.setTexto(texto);

		mensagens.add(mensagem);
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public boolean finalizou() {
		return false;
	}

	public void cadastrarAlunosParticipantes(Aluno al, GrupoDiscussao gd) {
		gd.cadastrarAlunosParticipantes(al);

	}

	public List<GrupoDiscussao> getListaDeGruposCadastrados() {
		return this.grupos;
	}

	/*public void cadastrarAula(Aula aula) {
		this.aulas.add(aula);

	}

	public List<Aula> getListaDeAulasCadastradas() {

		return aulas;
	}
*/
	public void cadastrarArquivos(Arquivo arquivo) {
		this.arquivos.add(arquivo);

	}

	/*public List<Aula> getListaDeAulasCadastradasPorGrupo(GrupoDiscussao gd1) {

		return aulas;
	}
*/
	public List<Arquivo> getListaDeArquivos() {

		return arquivos;
	}

	/*public void removerAulaDoGrupoDiscursao(Aula a1, GrupoDiscussao gd1) {
		this.aulas.remove(0).getIdAula();

	}*/

	public void cadastrarGrupoDiscursao(GrupoDiscussao grupod)
			throws GrupoDiscurssaoJaExisteException {
		boolean existe = false;

		for (GrupoDiscussao g : this.grupos) {
			if (g.getiDGrupo().equals(grupod.getiDGrupo())) {
				throw new GrupoDiscurssaoJaExisteException("Grupo Existente");

			}
		}
		if (!existe) {
			this.grupos.add(grupod);
		} else {
			throw new GrupoDiscurssaoJaExisteException("Grupo Existente");
		}
	}

	public GrupoDiscussao pesquisarGrupo(String iDcodigo)
			throws GrupoDiscurssaoJaExisteException {
		for (GrupoDiscussao g : this.grupos) {
			if (g.getiDGrupo().equals(iDcodigo)) {
				return g;
			}
		}
		throw new GrupoDiscurssaoJaExisteException("Grupo Existente");

	}

	public void adicionarAulaAoGrupo(Aula aula, GrupoDiscussao gd) {
		gd.addAula(aula);

	}

	/*public Aula pesquisaAula(String iDAul) {
		for (Aula aa : this.aulas) {
			if (aa.getIdAula().equals(iDAul)) {
				return aa;
			}
		}
		return null;
	}*/

	/*public void removerAula(String iDAula) {
		boolean removeu = false;
		for (Aula a : this.aulas) {
			if (a.getIdAula().equals(iDAula)) {
				this.aulas.remove(a);
				removeu = true;
				break;
			}
		}
		if (!removeu) {
			throw new RuntimeException("ERRO!");
		}
	}
*/
	public void removerArquivo(String iDArquivo)
			throws ArquivoInexistenteException {
		boolean removeu = false;
		for (Arquivo a : this.arquivos) {
			if (a.getIdArquivo().equals(iDArquivo)) {
				this.arquivos.remove(a);
				removeu = true;
				break;
			}
		}
		if (!removeu) {
			throw new ArquivoInexistenteException("");
		}

	}

	public Arquivo removerArquivoPeloNome(String nome) {
		for (Arquivo a : this.arquivos) {
			if (a.getNome().equals(nome)) {
				return a;
			}
		}
		throw new ArquivoInexistenteException("Arquivo Nao Existe");
	}

	public Arquivo pesquisarArquivos(String iDArquivo)
			throws ArquivoInexistenteException {
		for (Arquivo arquivo : this.arquivos) {
			if (arquivo.getIdArquivo().equals(iDArquivo)) {
				return arquivo;
			}
		}
		throw new ArquivoInexistenteException("iDArquivo Inexistente");
	}

}
