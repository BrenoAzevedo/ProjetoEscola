import java.util.List;
import java.util.ArrayList;

public class Turma{
	
	private int numero;
	private Disciplina disciplina;
	private Professor professor;
	private List<Horario> horarios;
		

	public Turma(Disciplina disc, int num) {
		this.numero = num;
		this.disciplina = disc;
		this.professor = null;
		this.horarios = new ArrayList<Horario>();
	}
	
	public Professor getProfessor(){
		return this.professor;
	}
	public void setProfessor(Professor p){
		this.professor = p;
	}
	
	public List<Horario> getHorarios(){
		return horarios;
	}
	public void setHorario(List<Horario> h){
		horarios = h;
	}
	
	public int getNumero(){
		return this.numero;
	}
	public void setNumero(int num){
		this.numero = num;
	}
	
	public Disciplina getDisciplina(){
		return this.disciplina;
	}
	public void setDisciplina(Disciplina dis){
		this.disciplina = dis;
	}
	
	public void adicionarHorario(Horario h){
		this.horarios.add(h);
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (this.getDisciplina().equals(other.getDisciplina()) ){
			if (this.getNumero() == other.getNumero()){
				return true;
		 	} else{
		 		return false;
		 	}
		} else {
			return false;
		}
		
	}	
	
	public String toString(){
		String desTurma = "A turma possui codigo "+ getNumero() +" e pertence a disciplina "+getDisciplina().getNome()+" \nSeus horarios são: "+getHorarios()+" E professor: "+getProfessor();              
		return desTurma;
	}

}
