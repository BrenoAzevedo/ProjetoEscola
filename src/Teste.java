
public class Teste {
	public static void main(String[] args) {
		Sisaloca sis = new Sisaloca();
		
		try {
			sis.cadastraProfessor("Breno", "111");
			System.out.println("Funcionou cadas. prof");
		} catch (ProfessorJaExisteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			sis.adicionaDisciplina("TESTE", "01");
			System.out.println("Funcionou add disc");
		} catch (DisciplinaJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sis.adicionaTurma("01", 1);
			System.out.println("Funcionou add turma");
		} catch (DisciplinaInexistenteException | TurmaJaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sis.alocaProfessorATurma("01", 1, "111");
			System.out.println("Funcionou alocar prof");
		} catch (DisciplinaInexistenteException | TurmaInexistenteException
				| ProfessorInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sis.cadastraHorarioTurma("01", 1, "seg", 8, 10);
			System.out.println("Funcionou cadas. horario");
		} catch (DisciplinaInexistenteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TurmaInexistenteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println("Pesquisar o professor: "+sis.pesquisaProfessorPelaMatricula("111"));
		} catch (ProfessorInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("Pesquisar disciplina: "+sis.pesquisaDisciplina("01"));
		} catch (DisciplinaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sis.pesquisaHorariosProfessor("111");
			System.out.println("Funcionou OK");
		} catch (ProfessorInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}