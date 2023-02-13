package anagrafica;

import java.util.Date;

public class Artista extends Persona {
private String nomeArte;
//TODO: prevedere la possibilità che un artista abbia più ruoli
private String ruolo; 

	public Artista(String nome, String cognome, Date dataNascita, Sesso sesso, String nazionalita,
			String luogoNascita) {
		super(nome, cognome, dataNascita, sesso, nazionalita, luogoNascita);
		// TODO Auto-generated constructor stub
		
	}

	public String getNomeArte() {
		return nomeArte;
	}

	public void setNomeArte(String nomeArte) {
		this.nomeArte = nomeArte;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}


}
