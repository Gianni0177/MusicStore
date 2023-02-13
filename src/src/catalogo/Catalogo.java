package catalogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import store.Log;
import store.MusicStore;

/**
 * @author gianfranco
 *
 */
public class Catalogo {

	private String nome;
	private LocalDate dataCreazione;
	private String nomeFileCSV;
	private Album album[];
	
	public Catalogo() {
		// TODO Auto-generated constructor stub
	}

	public Catalogo(String nome, LocalDate dataCreazione, String nomeFileCSV, boolean rigaIntestazione) {

		this.nome = nome;
		this.dataCreazione = dataCreazione;
		this.nomeFileCSV = nomeFileCSV;
		this.album = new Album[MusicStore.NUM_MAX_ALBUM];
		this.caricaCatalogo(this.nomeFileCSV, rigaIntestazione);
	}
	
	public int caricaCatalogo(String nomeFileCSV, boolean rigaIntestazione) {
		
		String riga;
		int braniInseriti = 0;
		try {		
			BufferedReader reader = new BufferedReader(new FileReader(nomeFileCSV));
			//TODO: aggiungere anche il controllo che verifichi se il file è vuoto prima di
			//leggere l'eventuale intestazione
			if (rigaIntestazione) {
				riga = reader.readLine();
			}
			while ((riga = reader.readLine()) != null) {
				// Salto le eventuali righe vuote (isEmpty())
				if (!riga.isEmpty()) {
					String riga_split[] = riga.split("[|]");
					// Debug: uso un ciclo for(each), vedi: https://www.w3schools.com/java/java_foreach_loop.asp
					// utile per creare un ciclo for quando non serve conoscere il valore dell'indice
					/*
					 for (String str : riga_split) {
						//System.out.println(str);
						
					}
					*/
					// Il codice segue il flusso del diagramma a blocchi caricato in classroom:
					// https://drive.google.com/file/d/1JdrQ_U226uEl_foflJZvvwKHL59z_UJ5/view?usp=drive_web&authuser=0
					// Estraggo l'id dell'album (primo campo della riga)
					int idAlbum = Integer.parseUnsignedInt(riga_split[0]);
					// Cerco l'album nell'array degli album (-1 se non esiste)
					int indice = cercaAlbum(idAlbum);
					// Album esiste già
					if (indice >= 0) {
						Brano brano = new Brano(Integer.parseUnsignedInt(riga_split[1]), riga_split[2], Float.parseFloat(riga_split[3]), LocalDate.parse(riga_split[4]));
						this.album[indice].inserisciBrano(brano);
						braniInseriti++;
					}
					// Album non esistente, quindi lo creo
					else {
						// Cerco un posto libero nell'array dei brani
						int indicePostoLibero = cercaPosto();
						if (indicePostoLibero > -1) {
							// Creo un album
							Album album = new Album(idAlbum, "TITOLO", "GRUPPO", "2000-01-01", "ETICHETTA", 200.0);
							this.album[indicePostoLibero] = album;
							Brano brano = new Brano(Integer.parseUnsignedInt(riga_split[1]), riga_split[2], Float.parseFloat(riga_split[3]), LocalDate.parse(riga_split[4]));
							// TODO: usare un costruttore di copia
							this.album[indicePostoLibero].inserisciBrano(brano);
							braniInseriti++;
						}
						else
							throw new PostiArrayEsauritiException("ALBUM", MusicStore.NOME_FILE_LOG);
					}
				}
			} 
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		Log.scriviMessaggio("Sono stati inseriti " + braniInseriti + " brani dal file " + MusicStore.NOME_FILE_CSV, MusicStore.NOME_FILE_LOG);
		return braniInseriti;
	
	}
	
	private int cercaPosto() {
		int i = 0;
		while (this.album[i] != null && i < MusicStore.NUM_MAX_ALBUM)
			i++;
		
		if (i == MusicStore.NUM_MAX_ALBUM)
				return -1;
		else
			return i;
	}

	public int cercaAlbum(int id) {

		int i = 0;
		//while (!((this.album[i] != null && this.album[i].getId() == id)) && i < MusicStore.NUM_MAX_ALBUM)
		while (i < MusicStore.NUM_MAX_ALBUM && 
				(this.album[i] == null || (this.album[i] != null &&  this.album[i].getId() != id)))
			i++;
		
		if (i == MusicStore.NUM_MAX_ALBUM)
			return -1;
		else
			return i;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public String getNomeFileCSV() {
		return nomeFileCSV;
	}

	public void setNomeFileCSV(String nomeFileCSV) {
		this.nomeFileCSV = nomeFileCSV;
	}

	public Album getAlbum(int idAlbum) {
		return album[this.cercaAlbum(idAlbum)];
	}

	public int setAlbum(Album album) {
		int i = this.cercaPosto();
		if (i > -1)
			this.album[i] = album;
		return i;
	}
	
	@Override
	public String toString() {
		return "Catalogo [nome=" + nome + ", dataCreazione=" + dataCreazione + stampaAlbums() + "]";
	}
		
	private String stampaAlbums() {
		String str = "\n\rAlbums: {";
		for (Album album : this.album)
			if (album != null)
				str += "\n\r" + album.toString();
			
		str += "}\n\r";
		return str;
	}


}
