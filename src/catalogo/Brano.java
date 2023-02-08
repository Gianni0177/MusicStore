/**
 * 
 */
package catalogo;
import java.time.LocalDate;

/**
 * @author Aula Lim
 *
 */
public class Brano {
	int posizione;
	private String titolo;
	private float durata;
	// TODO: prevedere la possibilità che un brano sia eseguito da un sottoinsieme degli artisti del brano
	private LocalDate dataIncisione;
	
public Brano(int posizione, String titolo, float durata, LocalDate dataIncisione) {
	
	this.posizione = posizione;
	this.titolo = titolo;
	this.durata = durata;
	this.dataIncisione = dataIncisione;
}

public String getTitolo() {
	return titolo;
}

public void setTitolo(String titolo) {
	this.titolo = titolo;
}

public float getDurata() {
	return durata;
}

public void setDurata(float durata) {
	this.durata = durata;
}

public LocalDate getDataIncisione() {
	return dataIncisione;
}

public void setDataIncisione(LocalDate dataIncisione) {
	this.dataIncisione = dataIncisione;
}

@Override
public String toString() {
	return "[posizione=" + posizione + ", titolo=" + titolo + ", durata=" + durata + ", dataIncisione="
			+ dataIncisione + "]";
}



	

}
