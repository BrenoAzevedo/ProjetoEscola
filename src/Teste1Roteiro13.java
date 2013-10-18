import java.io.IOException;
import java.nio.IntBuffer;
import java.util.List;

import javax.swing.JOptionPane;

public class Teste1Roteiro13 {

	public static void main(String[] args) {
		FrontEnd frontEnd = new FrontEnd();

		frontEnd.carregaArquivos();

		boolean flag = false;

		// Carregar os professores de arquivo

		while (flag == false) {

			int opcao = frontEnd
					.lerInteiro("Seja Bem Vindo ao Sistema de Controle Escolar - SCE \n"
							+ "\nPara melhor utilizar o nosso SCE fique atento as informações solicitadas\n"
							+ "\n(1) Cadastrar"
							+ "\n(2) Pesquisar"
							+ "\n(3) Remover"
							+ "\n(4) Alocações"
							+ "\n(5) Para Sair");
			switch (opcao) {

			// Opção 1 do menu - Cadastrar
			case 1:
				int opcaoCadastrar = frontEnd
						.lerInteiro("Ambiente de Cadastro - SCE \n"
								+ "\nCadastros:\n"
								+ "\n(1) Cadastrar Professor"
								+ "\n(2) Cadastrar Aluno"
								+ "\n(3) Cadastrar Disciplina"
								+ "\n(4) Cadastrar Turma"
								+ "\n(5) Cadastrar Horario"
								+ "\n(6) Cadastrar Nivel de Interesses de Disciplinas de Professor"
								+ "\n(7) Voltar para o Menu Principal");
				switch (opcaoCadastrar) {

				case 1:
					frontEnd.exibirMsg("Você irá informar os seguintes dados para cadastrar o Professor:"
							+ "\nNome" + "\nMatricula");
					String nomeProfessor = frontEnd
							.lerString("Informe o nome do Professor");
					String matProfessor = frontEnd
							.lerString("Informe a matricula do Professor");
					frontEnd.menuCadastrarProfessor(nomeProfessor, matProfessor);
					break;
				case 2:
					frontEnd.exibirMsg("Você irá informar os seguintes dados para cadastrar o Aluno:"
							+ "\nNome" + "\nMatricula");
					frontEnd.exibirMsg("Aviso!!"
							+ "\nO aluno não será gravado no data base desse sistema,"
							+ "essa função foi atribuida apenas para posterior implementação!!");
					String nomeAluno = JOptionPane.showInputDialog(null,
							"Informe o nome do Aluno");
					String matAluno = JOptionPane.showInputDialog(null,
							"Informe a matricula do Aluno");
					frontEnd.menuCadastrarAluno(nomeAluno, matAluno);
					break;

				case 3:
					frontEnd.exibirMsg("Você irá informar os seguintes dados para cadastrar a Disciplina:"
							+ "\nNome" + "\nCódigo");
					String nomeDisc = frontEnd
							.lerString("Informe o nome da Disciplina");
					String codDisc = frontEnd
							.lerString("Informe o código da disciplina");
					frontEnd.menuCadastrarDisciplina(nomeDisc, codDisc);
					break;

				case 4:
					frontEnd.exibirMsg("Você irá informar os seguintes dados para cadastrar a Turma:"
							+ "\nO Código da Disciplina"
							+ "\nNumero da Turma"
							+ "\nProfessor da Disciplina");
					String disc = frontEnd
							.lerString("Informe o código da disciplina");
					int num = frontEnd.lerInteiro("Informe o numero da turma");
					frontEnd.menuCadastrarTurma(disc, num);
					break;

				case 5:
					frontEnd.exibirMsg("Você irá informar os seguintes dados para cadastrar o Horario:"
							+ "\nO codigo da disciplina"
							+ "\nA Turma"
							+ "\nO dia da semana"
							+ "\nHora de inicio da aula"
							+ "\nHora do termino da aula");
					String disci = frontEnd
							.lerString("Informe o código da disciplina");
					int numero = frontEnd
							.lerInteiro("Informe o numero da turma");
					String dia = frontEnd.lerString("Informe o dia da semana");
					int hI = frontEnd
							.lerInteiro("Informe a hora de início da aula");
					int hF = frontEnd
							.lerInteiro("Informe a hora de término da aula");
					frontEnd.menuCadastrarHorario(disci, dia, numero, hI, hF);
					break;

				case 6:
					frontEnd.exibirMsg("Grava Interesses de disciplinas de professor!!\n"
							+ "\nVocê irá informar os seguintes dados:\n"
							+ "A matricula do professor\n"
							+ "O codigo da disciplina\n"
							+ "O nivel de interesse que funciona da seguinte maneira:\n"
							+ "\n"
							+ "(1) - Para disciplina favorita\n"
							+ "(2 e 3) - Para disciplinas intermediárias\n"
							+ "(4) - Para nenhum interesse\n"
							+ "\n"
							+ "Forneça os dados:");

					String matricula = frontEnd
							.lerString("Informe a matricula do professor");
					String codigoDisc = frontEnd
							.lerString("Informe o codigo da disciplina");
					int nivelI = frontEnd
							.lerInteiro("Informe o nivel de interesse do professor para essa disciplina\n"
									+ "Lembrando que:\n"
									+ "(1) - Para disciplina favorita\n"
									+ "(2 e 3) - Para disciplinas intermediárias\n"
									+ "(4) - Para nenhum interesse\n");
					frontEnd.menucadastrarInteressesProfessor(matricula,
							codigoDisc, nivelI);
					break;

				case 7:
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida!");
				}
				break;

			// Opção 2 do menu - Pesquisar
			case 2:
				int opcao2 = frontEnd
						.lerInteiro("Ambiente de Pesquisa - SCE \n"
								+ "\nPesquisas:" + "\n(1) Pesquisar Professor"
								+ "\n(2) Pesquisar Aluno"
								+ "\n(3) Pesquisar Disciplina"
								+ "\n(4) Pesquisar Turma"
								+ "\n(5) Pesquisar Horarios de Professor"
								+ "\n(6) Obter lista de Professores"
								+ "\n(7) Obter lista de Disciplinas"
								+ "\n(8) Voltar para o Menu Principal");
				switch (opcao2) {

				//
				case 1:
					int pesquisaP = frontEnd
							.lerInteiro("Você irá pesquisar o Professor por:"
									+ "\n(1) Nome" + "\n(2) Matricula");
					switch (pesquisaP) {

					case 1:
						String nomeProfessor = frontEnd
								.lerString("Informe o nome do Professor");
						frontEnd.pesquisaProfessorPorNome(nomeProfessor);
						break;
					case 2:
						String matProfessor = frontEnd
								.lerString("Informe a matricula do Professor");
						frontEnd.pesquisaProfessorPorMatricula(matProfessor);
						break;
					}
					break;

				//
				case 2:
					int pesquisaA = frontEnd
							.lerInteiro("Você irá pesquisar o Aluno por:"
									+ "\n(1) Nome" + "\n(2) Matricula");
					switch (pesquisaA) {

					case 1:
						String nomeAluno = frontEnd
								.lerString("Informe o nome do Aluno");
						frontEnd.pesquisaAlunoPorNome(nomeAluno);
						break;
					case 2:
						String matAluno = JOptionPane.showInputDialog(null,
								"Informe a matricula do Aluno");
						frontEnd.pesquisaAlunoPorMatricula(matAluno);
						break;
					}
					break;

				//
				case 3:
					frontEnd.exibirMsg("Você irá informar o codigo para pesquisar a Disciplina:");

					String codDisciplina = frontEnd
							.lerString("Informe o código da disciplina");
					frontEnd.pesquisaDisciplina(codDisciplina);
					break;

				//
				case 4:
					frontEnd.exibirMsg("Você irá informar os seguintes dados para pesquisar a Turma:"
							+ "\nO Código da Disciplina" + "\nNumero da Turma");
					String disc = frontEnd
							.lerString("Informe o código da disciplina");
					int num = frontEnd.lerInteiro("Informe o numero da turma");
					frontEnd.pesquisaTurma(disc, num);
					break;
				case 5:
					String matProfessor = frontEnd
							.lerString("Informe a matricula do Professor");
					frontEnd.pesquisaHorarioDoProfessor(matProfessor);
					break;
				case 6:
					frontEnd.obtemListaDeTodosOsProfessores();
					break;
				case 7:
					frontEnd.obtemListaDeTodasAsDisciplinas();
					break;
				case 8:
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida!");
				}
				break;

			// Opção 3 do menu - Remover
			case 3:
				int opcao3 = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Ambiente de Remoção - SCE \n" + "\nRemoção:"
								+ "\n(1) Remover Professor"
								+ "\n(2) Remover Aluno"
								+ "\n(3) Remover Disciplina"
								+ "\n(4) Remover Turma"
								+ "\n(5) Voltar para o Menu Principal"));
				switch (opcao3) {

				case 1:
					String matriculaProfessor = frontEnd
							.lerString("Informe a matricula do Professor");
					frontEnd.removerProfessor(matriculaProfessor);
					break;

				case 2:
					String matAluno = frontEnd
							.lerString("Informe a matricula do Aluno");
					frontEnd.removerAluno(matAluno);
					break;

				case 3:
					String codDisciplina = frontEnd
							.lerString("Informe o código da disciplina");
					frontEnd.removerDisciplina(codDisciplina);
					break;

				case 4:
					String disc = frontEnd
							.lerString("Informe o código da disciplina");
					int num = frontEnd.lerInteiro("Informe o numero da turma");
					frontEnd.removerTurma(disc, num);
					break;
				case 5:
					break;
				}
				break;

			// Opção 4 do Menu - Alocações
			case 4:
				int opcaoAlocar = frontEnd.lerInteiro("Menu de Alocação\n"
						+ "\nInforme a sua opção\n"
						+ "\n(1) Alocar professor em turma\n"
						+ "(2) Desalocar professor de turma\n"
						+ "(3) Voltar para o Menu Principal");

				if ((opcaoAlocar == 1) || (opcaoAlocar == 2)) {
					frontEnd.exibirMsg("Para Alocar ou Desalocar você irá informar:\n"
							+ "O Codigo da disciplina da turma\n"
							+ "O numero da turma\n"
							+ "A matricula do professor");

					String codDisciplina = frontEnd
							.lerString("Informe o codigo da disciplina");
					int numTurma = frontEnd
							.lerInteiro("Informe o numero da turma");
					String matriculaProf = frontEnd
							.lerString("Informe a matricula do professor");

					switch (opcaoAlocar) {

					case 1:
						frontEnd.alocarProfessorTurma(codDisciplina, numTurma,
								matriculaProf);
						break;
					case 2:
						frontEnd.desalocarProfessorTurma(codDisciplina,
								numTurma, matriculaProf);
						break;
					case 3:
						break;
					}

				} else if (opcaoAlocar == 3) {
					break;
				} else {
					frontEnd.exibirMsg("Opção Invalida");
				}
				break;

			case 5:
				frontEnd.exibirMsg("Você está encerrando o SCE\n" + "\n"
						+ "Obrigado por utilizar o nosso Sistema\n");
				System.exit(0);

				break;

			// O default não está funcionando para o ""
			default:
				frontEnd.exibirMsg("Opção Invalida, Tente novamente !!!\n");
				break;
			}
			// Metodo para gravar em arquivos apos cada execução
			frontEnd.gravarEmArquivos();
		}
	}
}
