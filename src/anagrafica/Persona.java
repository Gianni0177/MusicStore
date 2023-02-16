package anagrafica;

import java.util.Date;

public class Persona {
	private String nome;
	private String cognome;
	private Date dataNascita;
	//https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
	private Sesso sesso; 
	private String nazionalita;
	private String luogoNascita;
	
	public Persona(String nome, String cognome, Date dataNascita, Sesso sesso, String nazionalita,
			String luogoNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.nazionalita = nazionalita;
		this.luogoNascita = luogoNascita;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public Sesso getSesso() {
		return sesso;
	}
	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	
	
	

}
