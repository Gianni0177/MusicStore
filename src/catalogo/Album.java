package catalogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import anagrafica.Artista;
import anagrafica.Persona;
import store.MusicStore;

/**
 * @author gianfranco
 *
 */
public class Album {

	private int id;
	private String titolo;
	private String band;
	private LocalDate dataStampa;
	private String etichetta;
	private double prezzo;
	private Brano brani[];
	private Artista artisti[];

	public Album(int id, String titolo, String band, String strDataStampa, String etichetta, double prezzo) {

		this.id = id;
		this.brani = new Brano[MusicStore.NUM_MAX_BRANI];
		this.titolo = titolo;
		this.band = band;
		this.dataStampa = LocalDate.parse(strDataStampa);
		this.etichetta = etichetta;
		this.prezzo = prezzo;
	}

	public void inserisciBrano(Brano brano) {

		// A differenza della posizione dell'album nel catalogo, dove IdAlbum non
		// coincide con l'indice (array album),
		// nel caso del brano si è scelto che numBrano e indice (array brani) coincidano
		if (brano.getNumero() >= 0 && brano.getNumero() < MusicStore.NUM_MAX_BRANI)
			if (this.brani[brano.getNumero()] == null)
				// TODO: usare un costruttore di copia (più sicuro per via del riferimento)
				this.brani[brano.getNumero()] = brano;
			else
				// Nel caso in cui il brano esista, lancio una eccezione la quale ha un metodo
				// che
				// scrive un messaggio di errore in un file di log.
				// NOTA: si potrebbe semplicemente scrivere direttamente (senza il tramite
				// dell'eccezione)
				// il messaggio nel file di log, ma creando l'eccezione, essa potrebbe essere
				// utile
				// in altre parti dell'applicazione o in altre applicazioni.
				throw new BranoDuplicatoException(this.id, brano.getNumero(), MusicStore.NOME_FILE_LOG);
		else
			throw new PostiArrayEsauritiException("BRANI", MusicStore.NOME_FILE_LOG);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getId() {
		return this.id;
	}

	public LocalDate getDataStampa() {
		return dataStampa;
	}

	public void setDataStampa(LocalDate dataStampa) {
		this.dataStampa = dataStampa;
	}

	public String getEtichetta() {
		return etichetta;
	}

	public void setEtichetta(String etichetta) {
		this.etichetta = etichetta;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Brano[] getBrani() {
		return brani;
	}

	public void setBrani(Brano brani[]) {
		this.brani = brani;
	}

	public Persona[] getArtisti() {
		return artisti;
	}

	public void setArtisti(Artista artisti[]) {
		this.artisti = artisti;
	}

	@Override
	public String toString() {
		return "Album [titolo=" + titolo + ", band=" + band + ", dataStampa=" + dataStampa + ", etichetta=" + etichetta
				+ ", prezzo=" + prezzo + stampaBrani() + "]";
	}

	private String stampaBrani() {
		String str = "\n\rBrani: {";
		for (Brano brano : this.brani)
			if (brano != null)
				str += "\n\r" + brano.toString();

		str += "}\n\r";
		return str;
	}

}
