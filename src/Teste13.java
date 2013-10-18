import java.util.List;

public class Teste13 {
	
	public static void main(String args[]){
		SisalocaIF sistema = new Sisaloca();
		try {
			sistema.cadastraProfessor("Maria", "9999");
			sistema.adicionaDisciplina("Cálculo", "1234");
			sistema.adicionaTurma("1234", 1);
			sistema.cadastraHorarioTurma("1234", 1, Horario.SEGUNDA, 8, 10);
			sistema.cadastraHorarioTurma("1234", 1, Horario.QUARTA, 10, 12);
			sistema.alocaProfessorATurma("1234", 1, "9999");
			List  < Horario >  horariosMaria = sistema.pesquisaHorariosProfessor("9999");
			if (horariosMaria.size() == 2){
				if (horariosMaria.get(0).getDiaDaSemana().equals(Horario.SEGUNDA) && horariosMaria.get(1).getDiaDaSemana().equals(Horario.QUARTA)){
					System.out.println("OK. Achou horários de segunda e quarta de Maria");
				}
			} else {
				System.out.println("ERRO: Maria deveria ter 2 horários");
			}
			
			Turma t = sistema.pesquisaTurma("1234", 1);
			Professor profMaria = sistema.pesquisaProfessorPelaMatricula("9999");
			if (t.getProfessor().equals(profMaria) && t.getHorarios().size()==2){
				System.out.println("OK, turma alocada a Maria e com 2 horários");
			} else {
				System.out.println("ERRO: Erro na pesquisa da turma");
			}
			List  < Disciplina > disciplinasMaria = sistema.pesquisaDisciplinasDoProfessor("9999");
			if (disciplinasMaria.size()==1 && disciplinasMaria.get(0).getNome().equals("Cálculo")){
				System.out.println("OK: Consulta de disciplinas ok");
			} else {
				System.out.println("ERRO: Não achou disciplinas de Maria corretamente");
			}
			sistema.desalocaProfessorDeTurma("1234", 1, "9999");
			horariosMaria = sistema.pesquisaHorariosProfessor("9999");
			if (horariosMaria.size() == 0){
				System.out.println("OK, desalocou a turma de Maria");
			} else {
				System.out.println("ERRO: Desalocação não está funcionando");
			}
			
		} catch (Exception e) {
			System.out.println("Exceção não esperada:"+e.getMessage());
			e.printStackTrace();
		} 
		
	}
}