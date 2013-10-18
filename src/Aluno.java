public class Aluno extends Pessoa{
	
	Aluno(String n, String m){
		super(n , m);
	}
	public String toString(){
		String descricao = "O aluno é "+ getNome()+" cuja matricula é "+getMatricula();
		return descricao;
	}
}
