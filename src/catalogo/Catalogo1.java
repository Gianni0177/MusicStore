package catalogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import store.MusicStore;

public class Catalogo1 {

	private static int numAlbum = 0;
	private String nome;
	private LocalDate dataCreazione;
	private String nomeFileCSV;
	private Album album[];
	
	public Catalogo1() {
		// TODO Auto-generated constructor stub
	}

	public Catalogo1(String nome, LocalDate dataCreazione, String nomeFileCSV) {
		super();
		this.nome = nome;
		this.dataCreazione = dataCreazione;
		this.nomeFileCSV = nomeFileCSV;
		this.album = new Album[MusicStore.NUM_MAX_ALBUM];
		caricaCatalogo(this.nomeFileCSV, false);
	}
	
	public int caricaCatalogo(String nomeFileCSV, boolean rigaIntestazione) {
		String riga;
		int braniInseriti = 0;
		try {		
			BufferedReader reader = new BufferedReader(new FileReader(nomeFileCSV));
			//TODO: aggiungere anche il controllo che verifichi se il file è vuoto prima di
			//leggere l'eventuale intestazione
			if(rigaIntestazione) {
				riga = reader.readLine();
			}
			while ((riga = reader.readLine()) != null) {
				// Salto le eventuali righe vuote
				if (!riga.isEmpty()) {
					String riga_split[] = riga.split("[|]");
					// Uso un ciclo for(each), vedi: https://www.w3schools.com/java/java_foreach_loop.asp
					// utile per creare un ciclo for quando non serve conoscere il valore dell'indice
					/*for (String str : riga_split) {
						//System.out.println(str);
						
					}*/
					//Il codice segue il flusso del diagramma a blocchi caricato in classroom
					int ida = Integer.parseUnsignedInt(riga_split[0]);
					if(cercaAlbum(ida)>=0) {
						//crea il brano e aggiungilo all'array brani dell'album che si trova nella posizione restituita
						
					}
					else {
						//il metodo ritorna -1
						//creo un metodo che restituisce l'indice del primo posto libero (null) nell'array
						//dove inserire il nuovo ogetto Album creato
						cercaPosto(); 
					}
					
					
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
	
	
	
	

}