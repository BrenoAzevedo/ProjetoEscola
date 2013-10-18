import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Sisaloca implements SisalocaIF {

	private List<Professor> professores;
	private List<Aluno> alunos;
	private List<Disciplina> disciplina;

	Sisaloca() {
		professores = new ArrayList<Professor>();
		alunos = new ArrayList<Aluno>();
		disciplina = new ArrayList<Disciplina>();
	}

	public void cadastraProfessor(String nome, String matricula)
			throws ProfessorJaExisteException {
		boolean teste = false;
		for (Professor e : professores) {
			if (e.getMatricula().equals(matricula)) {
				teste = true;
				break;
			}
		}
		if (teste == false) {
			Professor p = new Professor(nome, matricula);
			professores.add(p);
		} else {
			throw new ProfessorJaExisteException("Professor Já cadastrado");
		}
	}

	public void cadastraAluno(String nome, String matricula)
			throws AlunoJaExisteException {
		boolean teste = false;
		for (Aluno e : alunos) {
			if (e.getMatricula().equals(matricula)) {
				teste = true;
				break;
			}
		}
		if (teste == false) {
			Aluno a = new Aluno(nome, matricula);
			alunos.add(a);
		} else {
			throw new AlunoJaExisteException("Aluno Já cadastrado");
		}
	}

	public List<Professor> pesquisaProfessorPeloNome(String nome) {
		List<Professor> listaNomes = new ArrayList<Professor>();
		for (Professor e : professores) {
			if (e.getNome().indexOf(nome) != -1) {
				listaNomes.add(e);
			}
		}
		return listaNomes;
	}

	public List<Aluno> pesquisaAlunoPeloNome(String nome) {
		List<Aluno> listaNomes = new ArrayList<Aluno>();
		for (Aluno e : alunos) {
			if (e.getNome().indexOf(nome) != -1) {
				listaNomes.add(e);
			}
		}
		return listaNomes;
	}

	public Professor pesquisaProfessorPelaMatricula(String matricula)
			throws ProfessorInexistenteException {
		Professor professorAchado = null;
		for (Professor e : professores) {
			if (e.getMatricula().equals(matricula)) {
				professorAchado = e;
				break;
			}
		}

		if (professorAchado != null) {
			return professorAchado;
		}

		else {
			throw new ProfessorInexistenteException("Professor Inexistente");
		}

	}

	public Aluno pesquisaAlunoPelaMatricula(String matricula)
			throws AlunoInexistenteException {
		Aluno alunoAchado = null;
		for (Aluno e : alunos) {
			if (e.getMatricula().equals(matricula)) {
				alunoAchado = e;
				break;
			}
		}

		if (alunoAchado != null) {
			return alunoAchado;
		} else {
			throw new AlunoInexistenteException("Aluno Inexistente");
		}

	}

	public void removeProfessor(String matricula)
			throws ProfessorInexistenteException {
		boolean teste = false;
		for (Professor e : professores) {
			if (e.getMatricula().equals(matricula)) {
				professores.remove(e);
				teste = true;
				break;
			}
		}
		if (teste == false) {
			throw new ProfessorInexistenteException(
					"Remove Professor Inexistente");
		}
	}

	public void removeAluno(String matricula) throws AlunoInexistenteException {
		boolean teste = false;
		for (Aluno e : alunos) {
			if (e.getMatricula().equals(matricula)) {
				alunos.remove(e);
				teste = true;
				break;
			}
		}
		if (teste == false) {
			throw new AlunoInexistenteException("Remove Aluno Inexistente");
		}
	}

	public void adicionaDisciplina(String nome, String codigo)
			throws DisciplinaJaExisteException {
		boolean teste = false;
		for (Disciplina e : disciplina) {
			if (e.getCodigo().equals(codigo)) {
				teste = true;
				break;
			}
		}
		if (teste == false) {
			Disciplina disc = new Disciplina(nome, codigo);
			disciplina.add(disc);
		} else {
			throw new DisciplinaJaExisteException("Disciplina Já Existente");
		}
	}

	public void removeDisciplina(String codigo)
			throws DisciplinaInexistenteException {
		boolean teste = false;
		for (Disciplina e : disciplina) {
			if (e.getCodigo().equals(codigo)) {
				disciplina.remove(e);
				teste = true;
				break;
			}
		}
		if (teste == false) {
			throw new DisciplinaInexistenteException("Remove Disciplina");
		}

	}

	public Disciplina pesquisaDisciplina(String codigo)
			throws DisciplinaInexistenteException {
		Disciplina listaDisc = null;
		for (Disciplina e : disciplina) {
			if (e.getCodigo().equals(codigo)) {
				listaDisc = e;
				break;
			}
		}
		if (listaDisc == null) {
			throw new DisciplinaInexistenteException("Pesquisa Disciplina");
		} else {
			return listaDisc;
		}
	}

	public void adicionaTurma(String codigoDisciplina, int numTurma)
			throws DisciplinaInexistenteException, TurmaJaExisteException {

		boolean teste = false;

		for (Disciplina e : this.disciplina) {
			if (e.getCodigo().equals(codigoDisciplina)) {
				e.adicionaTurma(numTurma);
				teste = true;
				break;
			}
		}
		if (teste == false) {
			throw new DisciplinaInexistenteException("Adiciona Turma ERRO!!!");
		}
	}

	public void removeTurma(String codigoDisciplina, int numTurma)
			throws DisciplinaInexistenteException {
		boolean teste = false;

		for (Disciplina e : this.disciplina) {
			if (e.getCodigo().equals(codigoDisciplina)) {
				for (Turma t : e.getTurmas()) {
					if (t.getNumero() == numTurma) {
						e.getTurmas().remove(t);
						teste = true;
						break;
					}
				}
			}
		}

		if (teste == false) {
			throw new DisciplinaInexistenteException(
					"Disciplina Inexistente!!!");
		}
	}

	public void cadastraNivelDeInteresseDeProfessorPorDisciplina(
			String matriculaProf, String codDisciplina, int nivelPreferencia)
			throws PreferenciaInvalidaException, ProfessorInexistenteException,
			DisciplinaInexistenteException {

		Professor prof = this.pesquisaProfessorPelaMatricula(matriculaProf);
		Disciplina dis = this.pesquisaDisciplina(codDisciplina);
		prof.adicionaPreferenciaDisciplina(dis, nivelPreferencia);
	}

	public List<Disciplina> consultaDisciplinasPorPreferenciaPorProfessor(
			String matriculaProfessor, int nivelPreferencia)
			throws ProfessorInexistenteException, PreferenciaInvalidaException {

		List<Disciplina> listaRetorno = new ArrayList<Disciplina>();

		for (Professor p : professores) {
			if (p.getMatricula().equals(matriculaProfessor)) {
				listaRetorno = p
						.getDisciplinasPreferidasComNivel(nivelPreferencia);
			}
		}

		return listaRetorno;
	}

	public List<Professor> obterListaDeProfessores() {

		return this.professores;
	}

	public List<Disciplina> obterListaDeDisciplinas() {

		return this.disciplina;
	}

	public void carregarProfessoresDeArquivo(String nomeArquivo)
			throws ProfessorJaExisteException, IOException {
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String nomeProf = null;
			do {
				nomeProf = leitor.readLine(); // lê a próxima linha do arquivo,
												// nome do professor
				if (nomeProf != null) {
					String matriculaProf = leitor.readLine(); // Lê a próxima
																// linha do
																// arquivo,
																// matrícula do
																// professor
					this.cadastraProfessor(nomeProf, matriculaProf);
				}
			} while (nomeProf != null); // vai ser null quando chegar no fim do
										// arquivo
		}

		finally {
			if (leitor != null) {
				leitor.close();
			}
		}
	}

	public void carregarDisciplinasDeArquivo(String nomeArquivo)
			throws DisciplinaJaExisteException, IOException {
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String nomeDisciplina = null;
			do {
				nomeDisciplina = leitor.readLine();
				if (nomeDisciplina != null) {
					String codDisciplina = leitor.readLine();
					this.adicionaDisciplina(nomeDisciplina, codDisciplina);
				}
			} while (nomeDisciplina != null); // vai ser null quando chegar no
												// fim do arquivo
		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}
	}

	public void gravarDisciplinasEmArquivo(String nomeArquivo)
			throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Disciplina disciplina : this.disciplina) {
				gravador.write(disciplina.getNome() + "\n");
				gravador.write(disciplina.getCodigo() + "\n");
			}
		} finally {
			if (gravador != null) {
				gravador.close();
			}
		}
	}

	public void gravarProfessoresEmArquivo(String nomeArquivo)
			throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Professor professores : this.professores) {
				gravador.write(professores.getNome() + "\n");
				gravador.write(professores.getMatricula() + "\n");
			}
		} finally {
			if (gravador != null) {
				gravador.close();
			}
		}
	}

	public void gravarTurmasDeDisciplinasEmArquivo(String nomeArquivo)
			throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Disciplina disciplina : this.disciplina) {
				gravador.write(disciplina.getCodigo() + "\n");
				gravador.write(disciplina.getTurmas().size() + "\n");
				for (int k = 0; k < disciplina.getTurmas().size(); k++) {
					Turma t = disciplina.getTurmas().get(k);
					gravador.write(t.getNumero() + "\n");
				}
			}
		} finally {
			if (gravador != null) {
				gravador.close();
			}
		}
	}

	public void carregarTurmasDeDisciplinasEmArquivo(String nomeArquivo)
			throws IOException, DisciplinaInexistenteException,
			TurmaJaExisteException {

		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String CodDis = leitor.readLine();

			do {

				if (CodDis != null) {
					String qtTurma = leitor.readLine();
					int qtTurmas = Integer.parseInt(qtTurma);
					for (int k = 0; k < qtTurmas; k++) {
						String numeroTurma = leitor.readLine();
						int numTurma = Integer.parseInt(numeroTurma);
						this.adicionaTurma(CodDis, numTurma);
					}
					CodDis = leitor.readLine();
				}
			} while (CodDis != null);
		}

		finally {
			if (leitor != null) {
				leitor.close();
			}
		}
	}

	public void gravaInteressesDeProfessoresPorDisciplinasEmArquivo(
			String nomeArquivo) throws IOException {

		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Professor professores : this.professores) {
				gravador.write(professores.getMatricula() + "\n");
				gravador.write(professores
						.getTextoPreferenciasDisciplinasComCodigo() + "\n");

			}
		} finally {
			if (gravador != null) {
				gravador.close();
			}
		}
	}

	public void carregaInteressesDeProfessoresPorDisciplinasDeArquivo(
			String nomeArquivo) throws PreferenciaInvalidaException,
			ProfessorInexistenteException, DisciplinaInexistenteException,
			IOException {

		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String matriculaPro = "";
			do {
				matriculaPro = leitor.readLine(); // lê a próxima linha do
													// arquivo, disciplina
				if (matriculaPro != null) {

					String disciplinasP1 = leitor.readLine();// Lê a próxima
																// linha do
																// arquivo,
																// disciplina e
																// o nivel de
																// interesse
					for (String codDisciplina : this
							.leListaDeCodigosDeDisciplinasDeLinha(disciplinasP1)) {
						this.cadastraNivelDeInteresseDeProfessorPorDisciplina(
								matriculaPro, codDisciplina, Professor.PREF_P1);
					}
					String disciplinasP2 = leitor.readLine();// Lê a próxima
																// linha do
																// arquivo,
																// disciplina e
																// o nivel de
																// interesse
					for (String codDisciplina : this
							.leListaDeCodigosDeDisciplinasDeLinha(disciplinasP2)) {
						this.cadastraNivelDeInteresseDeProfessorPorDisciplina(
								matriculaPro, codDisciplina, Professor.PREF_P2);
					}
					String disciplinasP3 = leitor.readLine();// Lê a próxima
																// linha do
																// arquivo,
																// disciplina e
																// o nivel de
																// interesse
					for (String codDisciplina : this
							.leListaDeCodigosDeDisciplinasDeLinha(disciplinasP3)) {
						this.cadastraNivelDeInteresseDeProfessorPorDisciplina(
								matriculaPro, codDisciplina, Professor.PREF_P3);
					}
					String disciplinasNP = leitor.readLine();// Lê a próxima
																// linha do
																// arquivo,
																// disciplina e
																// o nivel de
																// interesse
					for (String codDisciplina : this
							.leListaDeCodigosDeDisciplinasDeLinha(disciplinasNP)) {
						this.cadastraNivelDeInteresseDeProfessorPorDisciplina(
								matriculaPro, codDisciplina, Professor.PREF_NP);
					}
				}
			} while (matriculaPro != null); // vai ser null quando chegar no fim
											// do arquivo
		}

		finally {
			if (leitor != null) {
				leitor.close();
			}
		}

	}

	public void imprimeProfessoresEDisciplinas() {
		System.out.println("Professores Cadastrados: ");
		for (Professor p : this.professores) {
			System.out.println(p.toString());
		}
		System.out.println("Disciplinas Cadastradas: ");
		for (Disciplina d : this.disciplina) {
			System.out.println(d.toString());
		}
	}

	private List<String> leListaDeCodigosDeDisciplinasDeLinha(String linha) {
		List<String> codigos = new LinkedList<String>();
		StringTokenizer tokenizer = new StringTokenizer(linha, ":");
		String nivelPreferencia = tokenizer.nextToken();// parte antes dos :
		if (tokenizer.hasMoreTokens()) { // Se tiver algo depois dos :
			String listaCodigos = tokenizer.nextToken(); // parte depois dos :
			System.out.println("listaCodigos:" + listaCodigos);
			StringTokenizer tokenizerVirgula = new StringTokenizer(
					listaCodigos, ",");
			while (tokenizerVirgula.hasMoreTokens()) {
				String codigo = tokenizerVirgula.nextToken();
				codigos.add(codigo);
			}
		}
		return codigos;
	}

	public Turma pesquisaTurma(String codDisciplina, int numTurma)
			throws DisciplinaInexistenteException, TurmaInexistenteException {
		Turma turmaPesquisada = null;

		Disciplina d = this.pesquisaDisciplina(codDisciplina);

		for (Turma t : d.getTurmas()) {
			if (t.getNumero() == numTurma) {
				turmaPesquisada = t;
				break;
			}
		}

		if (turmaPesquisada == null) {
			throw new TurmaInexistenteException("Turma inexistente");
		}
		return turmaPesquisada;
	}

	public void cadastraHorarioTurma(String codDisciplina, int numTurma,
			String dia, int horaInicio, int horaFim)
			throws DisciplinaInexistenteException, TurmaInexistenteException {

		Turma t = this.pesquisaTurma(codDisciplina, numTurma);
		Horario h = new Horario(dia, horaInicio, horaFim);
		t.adicionarHorario(h);

	}

	public void alocaProfessorATurma(String codDisciplina, int numTurma,
			String matriculaProf) throws DisciplinaInexistenteException,
			TurmaInexistenteException, ProfessorInexistenteException {

		Turma turmaAlocada = this.pesquisaTurma(codDisciplina, numTurma);
		Professor professorAlocado = this
				.pesquisaProfessorPelaMatricula(matriculaProf);

		turmaAlocada.setProfessor(professorAlocado);
		professorAlocado.alocaTurma(turmaAlocada);
	}

	public void desalocaProfessorDeTurma(String codDisciplina, int numTurma,
			String matriculaProf) throws DisciplinaInexistenteException,
			TurmaInexistenteException, ProfessorInexistenteException {

		Turma turmaAlocada = this.pesquisaTurma(codDisciplina, numTurma);
		Professor professorAlocado = this
				.pesquisaProfessorPelaMatricula(matriculaProf);

		turmaAlocada.setProfessor(null);
		professorAlocado.desalocaTurma(turmaAlocada);
	}

	public List<Horario> pesquisaHorariosProfessor(String matriculaProf)
			throws ProfessorInexistenteException {
		List<Horario> horarioDoProfessor = new ArrayList<Horario>();
		boolean flag = false;
		for (Professor prof : this.professores) {
			if (prof.getMatricula().equals(matriculaProf)) {
				horarioDoProfessor = prof.getHorarios();
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new ProfessorInexistenteException("Professor Inexistente !!!");
		}
		return horarioDoProfessor;
	}

	public List<Turma> pesquisaTurmasDoProfessor(String matriculaProf)
			throws ProfessorInexistenteException {

		List<Turma> turmasDoProfessor = new ArrayList<Turma>();
		boolean flag = false;

		for (Professor prof : this.professores) {
			if (prof.getMatricula().equals(matriculaProf)) {
				turmasDoProfessor = prof.turmasAlocado;
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new ProfessorInexistenteException("Professor Inexistente !!!");
		}

		return turmasDoProfessor;

	}

	public List<Disciplina> pesquisaDisciplinasDoProfessor(String matriculaProf)
			throws ProfessorInexistenteException {

		List<Disciplina> disciplinasDoProfessor = new ArrayList<Disciplina>();
		boolean flag = false;

		for (Professor prof : this.professores) {
			if (prof.getMatricula().equals(matriculaProf)) {
				disciplinasDoProfessor = prof.getDisciplinasAlocado();
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new ProfessorInexistenteException("Professor Inexistente !!!");
		}

		return disciplinasDoProfessor;

	}

}