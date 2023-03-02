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
public abstract class Album {

	private int id;
	private String titolo;
	private String band;
	private LocalDate dataPubblicazione;
	private String etichetta;
	private double prezzo;
	private Brano brani[];
	private Artista artisti[];

	public Album(int id, String titolo, String band, String strdataPubblicazione, String etichetta, double prezzo) {

		this.id = id;
		this.brani = new Brano[MusicStore.NUM_MAX_BRANI];
		this.titolo = titolo;
		this.band = band;
		this.dataPubblicazione = LocalDate.parse(strdataPubblicazione);
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

				try{
					throw new BranoDuplicatoException(this.id, brano.getNumero(), MusicStore.NOME_FILE_LOG);
				}catch(BranoDuplicatoException e){
					System.out.println("                                      ");
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println(" E'stato rilevato un brano duplicato! ");
					System.out.println("      Controlla il file di LOG!       ");
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("                                      ");
				}
		else
			try{
				throw new PostiArrayEsauritiException("BRANI", MusicStore.NOME_FILE_LOG);
			}catch(PostiArrayEsauritiException e){
				System.out.println("                                      ");
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println(" I posti  dell'array si sono esauriti ");
					System.out.println("      Controlla il file di LOG!       ");
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("                                      ");
			}
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

	public LocalDate getdataPubblicazione() {
		return dataPubblicazione;
	}

	public void setdataPubblicazione(LocalDate dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
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
		return "Album [titolo=" + titolo + ", band=" + band + ", dataPubblicazione=" + dataPubblicazione + ", etichetta=" + etichetta
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

	protected void stampaCopertina(){
		//metodo utilizzato dai varii tipi di Album
	}
}
	