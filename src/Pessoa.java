
public class Pessoa {
	
	private String nome;
	private String matricula;
	
	Pessoa(){
		this("Sem Nome", "00");
	}
	Pessoa(String n, String m){
		nome = n;
		matricula = m;
	}
	
	public String getNome(){
		return this.nome;		
	}
	
	public String getMatricula(){
		return this.matricula;		
	}
	
	public void setNome(String n){
		this.nome = n;
	}
	
	public void setMatricula(String m){
		this.matricula = m;
	}
	
	public String getDescricao(){
		String descricao = "O nome é "+getNome()+" cuja Matricula é "+getMatricula(); 
		return descricao; 
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		 	} else if (!matricula.equals(other.matricula))
		 		return false;
		 
		return true;
	}	
}
