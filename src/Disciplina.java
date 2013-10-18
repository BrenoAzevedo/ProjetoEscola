import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Disciplina {
	
	private String nome;
	private String codigo;
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public Disciplina(String n , String cod){
		this.nome = n;
		this.codigo = cod;
	}
	public Disciplina(){
		this("Sem nome","00");
	}
	public String getNome(){
		return this.nome;
	}
	public void setNome(String n){
		this.nome = n;
	}
	public String getCodigo(){
		return this.codigo;
	}
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	public List<Turma> getTurmas(){
		return this.turmas;
	}
	public void adicionaTurma(int numero) throws TurmaJaExisteException {
		
		for (Turma t: this.turmas){
			if (t.getNumero() == numero){
				throw new TurmaJaExisteException("Já existe a turma de número:"+numero);
			}
		}
			Turma t = new Turma(this, numero);
			this.turmas.add(t);		
	}
	public void removeTurma(int numero){
		for (Turma t: this.turmas){
			if (t.getNumero() == numero){
				this.turmas.remove(t);
					break;
			}
		}
	}
	public String toString(){
		String desDisciplina = "Disciplina: "+getNome()+" cujo codigo é: "+getCodigo()+" E possui as seguintes tumas: "+getTurmas()+"\n";  
		return desDisciplina;
	}
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null){
				return false;
		 	}  else {
		 		return true;
		 	}
		} else if (!codigo.equals(other.codigo)){
		 		return false;
		} else {
		 
		return true;
		}
	}	
}
