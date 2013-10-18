import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FrontEnd {
	private static final int TAM_MINIMO = 1;
	private Sisaloca sistemaFrontEnd = new Sisaloca();
	public static FrontEnd front = new FrontEnd();

	public void exibirMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public String lerString(String msg) {
		String valor = "";
		do {
			valor = JOptionPane.showInputDialog(null, msg);
			if (valor.length() < TAM_MINIMO)
				exibirMsg("Valor deve ter no minimo ");

		} while (valor.length() < TAM_MINIMO);
		return valor;
	}

	public Integer lerInteiro(String msg) {
		return Integer.parseInt(lerString(msg));
	}

	public void carregaArquivos() {
		try {
			sistemaFrontEnd.carregarProfessoresDeArquivo("professores.txt");
		} catch (ProfessorJaExisteException e3) {
			e3.printStackTrace();
		} catch (IOException e3) {
			front.exibirMsg("Não foi possivel carregar professores de arquivo");
		}

		// carregar disciplinas de arquivo
		try {
			sistemaFrontEnd.carregarDisciplinasDeArquivo("disciplinas.txt");
		} catch (DisciplinaJaExisteException e3) {
			e3.printStackTrace();
		} catch (IOException e3) {
			front.exibirMsg("Não foi possivel carregar disciplinas de arquivo");
		}

		// Carregar
		try {
			sistemaFrontEnd.carregarTurmasDeDisciplinasEmArquivo("turmas2.txt");
		} catch (IOException e3) {
			front.exibirMsg("Não foi possivel carregar turmas de arquivo");
		} catch (DisciplinaInexistenteException e3) {
			e3.printStackTrace();
		} catch (TurmaJaExisteException e3) {
			front.exibirMsg("Turma Já Existente");
		}
		
		try{
			sistemaFrontEnd.carregaInteressesDeProfessoresPorDisciplinasDeArquivo("preferencias2.txt");
		} catch (PreferenciaInvalidaException e) {
			e.printStackTrace();
		} catch (ProfessorInexistenteException e) {
			e.printStackTrace();
		} catch (DisciplinaInexistenteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			front.exibirMsg("Carregar interesses com problema");
			e.printStackTrace();
		}
	}

	public void gravarEmArquivos() {
		try {
			sistemaFrontEnd
					.gravaInteressesDeProfessoresPorDisciplinasEmArquivo("preferencias2.txt");
			sistemaFrontEnd.gravarDisciplinasEmArquivo("disciplinas.txt");
			sistemaFrontEnd.gravarProfessoresEmArquivo("professores.txt");
			sistemaFrontEnd.gravarTurmasDeDisciplinasEmArquivo("turmas2.txt");
		} catch (Exception erro) {
			front.exibirMsg(erro.getMessage());
		}

	}

	public void menuCadastrarProfessor(String nomeProfessor, String matProfessor) {
		try {
			sistemaFrontEnd.cadastraProfessor(nomeProfessor, matProfessor);
			front.exibirMsg("Professor " + nomeProfessor
					+ " Cadastrado com Sucesso!!");
		} catch (ProfessorJaExisteException e) {
			front.exibirMsg("Professor já Cadastrado!!");
		}

		try {
			sistemaFrontEnd.gravarProfessoresEmArquivo("professores.txt");
			front.exibirMsg("Professor gravado em arquivo");
		} catch (IOException e2) {
			front.exibirMsg("Problemas em gravar arquivo de Professor");
		}
	}

	public void pesquisaProfessorPorMatricula(String matProfessor) {
		try {
			JOptionPane.showMessageDialog(null, sistemaFrontEnd
					.pesquisaProfessorPelaMatricula(matProfessor));
		} catch (ProfessorInexistenteException e1) {
			front.exibirMsg("Professor inexistente!!");
		}
	}

	public void pesquisaProfessorPorNome(String nomeProfessor) {
		JOptionPane.showMessageDialog(null,"Professores com o nome pesquisado:"+
				sistemaFrontEnd.pesquisaProfessorPeloNome(nomeProfessor));
	}
	
	public void pesquisaHorarioDoProfessor(String matProfessor){
		try {
			JOptionPane.showMessageDialog(null,"Horarios do professor pesquisado: "+
					sistemaFrontEnd.pesquisaHorariosProfessor(matProfessor));
		} catch (ProfessorInexistenteException e) {
			JOptionPane.showMessageDialog(null,"Professor inexistente");
			e.printStackTrace();
		}
	}

	public void pesquisaAlunoPorMatricula(String matAluno) {
		try {
			JOptionPane.showMessageDialog(null,
					sistemaFrontEnd.pesquisaAlunoPelaMatricula(matAluno));
		} catch (AlunoInexistenteException e1) {
			front.exibirMsg("Aluno inexistente!!");
		}
	}

	public void pesquisaAlunoPorNome(String nomeAluno) {
		JOptionPane.showMessageDialog(null,"Alunos com o nome pesquisado: "+
				sistemaFrontEnd.pesquisaAlunoPeloNome(nomeAluno));
	}

	public void pesquisaDisciplina(String codDisciplina) {
		try {
			JOptionPane.showMessageDialog(null,
					sistemaFrontEnd.pesquisaDisciplina(codDisciplina));
		} catch (DisciplinaInexistenteException e) {
			front.exibirMsg("Disciplina inexistente!!");
		}
	}

	public void pesquisaTurma(String disc, int num) {
		try {
			Disciplina dis = sistemaFrontEnd.pesquisaDisciplina(disc);

			try {
				JOptionPane.showMessageDialog(null,
						sistemaFrontEnd.pesquisaTurma(disc, num));
			} catch (TurmaInexistenteException e) {
				front.exibirMsg("Turma Inexistente!!");
			}
		} catch (DisciplinaInexistenteException e1) {
			front.exibirMsg("Disciplina Inexistente!!");
		}
	}

	public void menuCadastrarAluno(String nomeAluno, String matAluno) {
		try {
			sistemaFrontEnd.cadastraAluno(nomeAluno, matAluno);
			front.exibirMsg("Aluno " + nomeAluno + " Cadastrado com Sucesso!!");
		} catch (AlunoJaExisteException e) {
			front.exibirMsg("Aluno já Cadastrado!!");
		}
	}

	public void menuCadastrarDisciplina(String nomeDisc, String codDisc) {
		try {
			sistemaFrontEnd.adicionaDisciplina(nomeDisc, codDisc);
			front.exibirMsg("Disciplina " + nomeDisc
					+ " Cadastrado com Sucesso!!");
		} catch (DisciplinaJaExisteException e) {
			front.exibirMsg("Disciplina já Cadastrada!!");
		}

		try {
			sistemaFrontEnd.gravarDisciplinasEmArquivo("disciplinas.txt");
			front.exibirMsg("Disciplina gravada em arquivo");
		} catch (IOException e2) {
			front.exibirMsg("Problemas em gravar arquivo de Disciplinas");
		}

	}

	public void menuCadastrarTurma(String disc, int num) {
		try {
			Disciplina dis = sistemaFrontEnd.pesquisaDisciplina(disc);

			try {
				dis.adicionaTurma(num);
				front.exibirMsg("Turma Cadastrada");
			} catch (TurmaJaExisteException e) {
				front.exibirMsg("Essa turma já está cadastrada!");
			}
		} catch (DisciplinaInexistenteException e) {
			front.exibirMsg("Essa disciplina não está cadastrada!");
		}

		try {
			sistemaFrontEnd.gravarTurmasDeDisciplinasEmArquivo("turmas2.txt");
		} catch (IOException e2) {
			front.exibirMsg("Problemas em gravar arquivo de Professor");
		}

	}

	public void menuCadastrarHorario(String disci, String dia, int numero,
			int hI, int hF) {
		try {
			Disciplina disciplina = sistemaFrontEnd.pesquisaDisciplina(disci);
			try {
				sistemaFrontEnd.pesquisaTurma(disci, numero);
				sistemaFrontEnd
						.cadastraHorarioTurma(disci, numero, dia, hI, hF);
			} catch (TurmaInexistenteException e) {
				front.exibirMsg("Turma Inexistente!!");
			}

		} catch (DisciplinaInexistenteException e) {
			front.exibirMsg("Disciplina Inexistente!!");
		}
	}

	public void menucadastrarInteressesProfessor(String matricula,
			String codigoDisc, int nivelI) {
		try {
			sistemaFrontEnd.cadastraNivelDeInteresseDeProfessorPorDisciplina(
					matricula, codigoDisc, nivelI);
			front.exibirMsg("Preferencia cadastrada com sucesso!!");
		} catch (PreferenciaInvalidaException e2) {
			front.exibirMsg("Preferencia Invalida!!");
			e2.printStackTrace();
		} catch (ProfessorInexistenteException e2) {
			front.exibirMsg("Professor Inexistente!!");
			e2.printStackTrace();
		} catch (DisciplinaInexistenteException e2) {
			front.exibirMsg("Disciplina Inexistente!!");
			e2.printStackTrace();
		}
	}

	public void removerProfessor(String matriculaProfessor) {
		try {
			sistemaFrontEnd.removeProfessor(matriculaProfessor);
			front.exibirMsg("Professor Removido com Sucesso");
		} catch (ProfessorInexistenteException e1) {
			front.exibirMsg("Professor inexistente!!");
		}
	}

	public void removerAluno(String matAluno) {
		try {
			sistemaFrontEnd.pesquisaAlunoPelaMatricula(matAluno);
		} catch (AlunoInexistenteException e1) {
			front.exibirMsg("Aluno inexistente!!");
		}
	}

	public void removerDisciplina(String codDisciplina) {
		try {
			sistemaFrontEnd.removeDisciplina(codDisciplina);
			front.exibirMsg("Disciplina removida com sucesso!!");
		} catch (DisciplinaInexistenteException e) {
			front.exibirMsg("Disciplina inexistente!!");
		}
	}

	public void removerTurma(String disc, int num) {
		try {
			sistemaFrontEnd.removeTurma(disc, num);
			front.exibirMsg("Turma removida com sucesso!!");
		} catch (DisciplinaInexistenteException e) {
			front.exibirMsg("Turma inexistente!!");
		}
	}

	public void alocarProfessorTurma(String codDisciplina, int numTurma,
			String matriculaProf) {
		try {
			sistemaFrontEnd.alocaProfessorATurma(codDisciplina, numTurma,
					matriculaProf);
			front.exibirMsg("Professor alocado com sucesso");
		} catch (DisciplinaInexistenteException e) {
			front.exibirMsg("A disciplina informada não existe");
			e.printStackTrace();
		} catch (TurmaInexistenteException e) {
			front.exibirMsg("A turma informada não existe");
			e.printStackTrace();
		} catch (ProfessorInexistenteException e) {
			front.exibirMsg("O Professor informado não existe");
			e.printStackTrace();
		}
	}

	public void desalocarProfessorTurma(String codDisciplina, int numTurma,
			String matriculaProf) {
		try {
			sistemaFrontEnd.desalocaProfessorDeTurma(codDisciplina, numTurma,
					matriculaProf);
			front.exibirMsg("Professor desalocado com sucesso");
		} catch (DisciplinaInexistenteException e) {
			front.exibirMsg("A disciplina informada não existe");
			e.printStackTrace();
		} catch (TurmaInexistenteException e) {
			front.exibirMsg("A turma informada não existe");
			e.printStackTrace();
		} catch (ProfessorInexistenteException e) {
			front.exibirMsg("O Professor informado não existe");
			e.printStackTrace();
		}
	}

	public void obtemListaDeTodosOsProfessores() {
		JOptionPane.showMessageDialog(null,
				sistemaFrontEnd.obterListaDeProfessores());
	}

	public void obtemListaDeTodasAsDisciplinas() {
		JOptionPane.showMessageDialog(null,
				sistemaFrontEnd.obterListaDeDisciplinas());
	}

}
