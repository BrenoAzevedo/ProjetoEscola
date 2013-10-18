import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
	private List<Disciplina> listaDisciplinasP1;
	private List<Disciplina> listaDisciplinasP2;
	private List<Disciplina> listaDisciplinasP3;
	private List<Disciplina> listaDisciplinasNP;
	public static final int PREF_P1 = 1;
	public static final int PREF_P2 = 2;
	public static final int PREF_P3 = 3;
	public static final int PREF_NP = 4;
	List<Turma> turmasAlocado;

	Professor(String n, String m) {
		super(n, m);
		listaDisciplinasP1 = new ArrayList<Disciplina>();
		listaDisciplinasP2 = new ArrayList<Disciplina>();
		listaDisciplinasP3 = new ArrayList<Disciplina>();
		listaDisciplinasNP = new ArrayList<Disciplina>();
		turmasAlocado = new ArrayList<Turma>();
	}

	public void adicionaPreferenciaDisciplina(Disciplina d, int nivelPreferencia)
			throws PreferenciaInvalidaException {
		switch (nivelPreferencia) {
		case 1:
			this.listaDisciplinasP1.add(d);
			break;
		case 2:
			this.listaDisciplinasP2.add(d);
			break;
		case 3:
			this.listaDisciplinasP3.add(d);
			break;
		case 4:
			this.listaDisciplinasNP.add(d);
			break;
		default:
			throw new PreferenciaInvalidaException(
					"Adiciona Preferencia ERRO!!!");
		}
	}

	public List<Disciplina> getDisciplinasPreferidasComNivel(
			int nivelPreferencia) throws PreferenciaInvalidaException {
		switch (nivelPreferencia) {
		case 1:
			return this.listaDisciplinasP1;
		case 2:
			return this.listaDisciplinasP2;
		case 3:
			return this.listaDisciplinasP3;
		case 4:
			return this.listaDisciplinasNP;
		default:
			throw new PreferenciaInvalidaException(
					"Retorna Preferencia ERRO!!!");
		}
	}

	public String getListaNomesDisciplinas(List<Disciplina> lista) {
		String listaNomes = "";
		for (int k = 0; k < lista.size(); k++) {
			Disciplina d = lista.get(k);
			listaNomes += d.getNome();
			if (k != lista.size() - 1) {
				listaNomes += ",";
			}
		}
		return listaNomes;
	}

	public String toString() {
		String txt = getDescricao() + "\n";
		txt += "Disciplinas P1:"
				+ getListaNomesDisciplinas(this.listaDisciplinasP1);
		txt += "\nDisciplinas P2:"
				+ getListaNomesDisciplinas(this.listaDisciplinasP2);
		txt += "\nDisciplinas P3:"
				+ getListaNomesDisciplinas(this.listaDisciplinasP3);
		txt += "\nDisciplinas NP:"
				+ getListaNomesDisciplinas(this.listaDisciplinasNP);
		return txt;
	}

	public String getTextoPreferenciasDisciplinasComCodigo() {
		String r = "";
		r += "P1:" + this.getListaCodigosDisciplinas(listaDisciplinasP1);
		r += "\nP2:" + this.getListaCodigosDisciplinas(listaDisciplinasP2);
		r += "\nP3:" + this.getListaCodigosDisciplinas(listaDisciplinasP3);
		r += "\nNP:" + this.getListaCodigosDisciplinas(listaDisciplinasNP);
		return r;
	}

	public String getListaCodigosDisciplinas(List<Disciplina> lista) {
		String listaCodigo = "";
		for (int k = 0; k < lista.size(); k++) {
			listaCodigo += lista.get(k).getCodigo();
			if (k != lista.size() - 1) {
				listaCodigo += ",";
			}
		}
		return listaCodigo;
	}

	public void alocaTurma(Turma t) {
		this.turmasAlocado.add(t);
	}

	public void desalocaTurma(Turma t) {
		this.turmasAlocado.remove(t);
	}

	public List<Turma> getTurmasAlocado() {
		return this.turmasAlocado;
	}

	public List<Disciplina> getDisciplinasAlocado() {
		List<Disciplina> disciplinasAlocadas = new ArrayList<Disciplina>();
		for (Turma t : this.turmasAlocado) {
			if (!disciplinasAlocadas.contains(t.getDisciplina())) {
				disciplinasAlocadas.add(t.getDisciplina());
			}
		}
		return disciplinasAlocadas;
	}

	public List<Horario> getHorarios() {
		List<Horario> horarioProfessor = new ArrayList<Horario>();
		for (Turma t : this.turmasAlocado) {
			horarioProfessor.addAll(t.getHorarios());
			break;
		}
		System.out.println("Valor do horario do prof: "+horarioProfessor);
		return horarioProfessor;
		
	}
}