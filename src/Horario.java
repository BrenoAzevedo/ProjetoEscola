public class Horario {
	
	public static final String SEGUNDA = "SEG";
	public static final String TERCA = "TER";
	public static final String QUARTA = "QUAR";
	public static final String QUINTA = "QUIN";
	public static final String SEXTA = "SEX";
	public static final String SABADO = "SAB";
	public static final String DOMINGO = "DOM";
	
	private String diaDaSemana;
	private int horaInicio;
	private int horaFim;
	
	Horario(String diaS, int hoI, int hoF){
		this.diaDaSemana = diaS;
		this.horaInicio = hoI;
		this.horaFim = hoF;
	}
	Horario(){
		this("Dia", 8, 10);
	}
	public void setDiaDaSemana(String dia){
		this.diaDaSemana = dia;		
	}
	public void setHoraInicio(int hI){
		this.horaInicio = hI;		
	}
	public void setHoraFim(int hF){
		this.horaFim = hF;		
	}
	public String getDiaDaSemana(){
		return this.diaDaSemana;		
	}
	public int getHoraInicio(){
		return this.horaInicio;		
	}
	public int getHoraFim(){
		return this.horaFim;		
	}
	
	public String toString(){
		String desHorario = "A turma possui o horario de "+ getHoraInicio() +" as "+getHoraFim()+" Na: "+getDiaDaSemana();              
		return desHorario;
	}
}
