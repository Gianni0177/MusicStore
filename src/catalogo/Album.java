/**
 * 
 */
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

	private String titolo;
	private String band;
	private LocalDate dataStampa;
	private String etichetta;
	private double prezzo;
	private Brano brani[];
	private Artista artisti[];
	// L'ID album viene generato come un contatore automatico progressivo
	// TODO: attenzione conflitto con l'attributo il primo token della stringa letta dal file 
	// dei brani 
	private static int contatoreAlbum = 0;
	
public Album(String titolo, String band, String strDataStampa, String etichetta, double prezzo, String nomeFileBrani) {
	
		try {
			this.brani = new Brano[MusicStore.MAX_BRANI];
			this.titolo = titolo;
			this.band = band;
			this.dataStampa = LocalDate.parse(strDataStampa);
			this.etichetta = etichetta;
			this.prezzo = prezzo;
			//incremento di 1
			// TODO: attenzione conflitto con l'attributo il primo token della stringa letta dal file 
			// dei brani 
			this.Album.contatoreAlbum++;
			this.leggiBraniDaFile(nomeFileBrani, this.Album.contatoreAlbum);
		}
		catch (Exception e) {
			// Registra nel file di log la causa dell'errore
			e.printStackTrace();
		}
	}
	private int leggiBraniDaFile(String nomeFileBrani, int idAlbum) {
		String riga;
		int braniInseriti = 0;
		try {		
			BufferedReader reader = new BufferedReader(new FileReader(nomeFileBrani));
			while ((riga = reader.readLine()) != null) {
				// Salto le eventuali righe vuote
				if (!riga.isEmpty()) {
					String riga_split[] = riga.split("[|]");
					// Uso un ciclo for(each), vedi: https://www.w3schools.com/java/java_foreach_loop.asp
					// utile per creare un ciclo for quando non serve conoscere il valore dell'indice
					for (String str : riga_split)
						System.out.println(str);
					// Creo un oggetto di classe Brano
					// TODO: gestire le eccezioni di tipo unchecked: generate dai metodi parseFloat e parse (data)
					Brano brano = new Brano(Integer.parseUnsignedInt(riga_split[1]), riga_split[2], Float.parseFloat(riga_split[3]), LocalDate.parse(riga_split[4]));
					// Aggiungo l'oggetto di classe Brano all'array usando la posizione.
					int numBrano = Integer.parseUnsignedInt(riga_split[1]);
					// TODO: attenzione ida è da gestire (compito per casa), la prima cosa da fare è controllare che l'album non esista
					// già (nel catalogo....)
					int ida = Integer.parseUnsignedInt(riga_split[0]);
					
					if (numBrano >= 0 && numBrano < MusicStore.MAX_BRANI) {
						if (!branoInserito(numBrano)) {
							this.brani[Integer.parseUnsignedInt(riga_split[1])] = brano;
							braniInseriti++;
						}
						else
							// Nel caso in cui il brano esista, lancio una eccezione la quale ha un metodo che
							// scrive un messaggio di errore in un file di log.
							// NOTA: si potrebbe semplicemente scrivere direttamente (senza il tramite dell'eccezione)
							// il messaggio nel file di log, ma creando l'eccezione, essa potrebbe essere utile
							// in altre parti dell'applicazione o in altre applicazioni.
							throw new BranoDuplicatoException(ida, numBrano, MusicStore.NOME_FILE_LOG);
					}
					else ;
					// TODO: creare una apposita eccezione (unchecked) e lanciarla.
					// L'eccezione dovrà aggiungere un messaggio in un file di log (log.csv)
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
		return braniInseriti;
	}
	
	private boolean branoInserito(int numBrano) {
		// Supponendo che numBrano sia anche l'indice dell'array brani, eseguo un semplice controllo.
		// TODO: modificarel'applicazione in modo che numBrano non corrisponda all'indice dellarray brani;
		// quindi, per la ricerca/controllo è necessario scorrere tutto l'array alla ricerca del brano con il corrispondente id.
		return this.brani[numBrano] == null;
	}
	
	public Album(	String titolo, String band, LocalDate DataStampa, String etichetta, double prezzo, Brano[] brani, Artista[] artisti) {
		this.titolo = titolo;
		this.band = band;
		this.dataStampa = dataStampa;
		this.etichetta = etichetta;
		this.prezzo = prezzo;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
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

	/* esempio di utilizzo di metodi statici
	public static void visualizzaProprietario() {
		System.out.println("Music Store Camposampiero");
	}
	public static void cambiaContatore(int valore) {
		contatoreAlbum=valore;
	}
	*/
	@Override
	public String toString() {
		return "Album [titolo=" + titolo + ", band=" + band + ", dataStampa=" + dataStampa + ", etichetta=" + etichetta
				+ ", prezzo=" + prezzo
				+ stampaBrani()
				+ "]";
	}
	private String stampaBrani() {
		String str = "\n\r Brani: {";
		for (Brano brano : this.brani)
			if (brano != null)
				str += "\n\r" + brano.toString();
			
		str += "}\n\r";
		return str;
	}
	public static int getContatoreAlbum() {
		return  contatoreAlbum;
	}
	
	

}
