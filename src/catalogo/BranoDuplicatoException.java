package catalogo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import store.MusicStore;

// Eccezione di tipo unchecked
public class BranoDuplicatoException extends RuntimeException {

	String message = "";

	public BranoDuplicatoException(int ida, int numBrano, String nomeFileLog) {
		BufferedWriter writer = null;
		// Scrivo un messaggio nel file di log
		try {	
			// Apro il file di log in modalità append, passando il valore "true" come secondo
			// parametro: https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html
			writer = new BufferedWriter(new FileWriter(nomeFileLog, true));
			this.message = "[" + LocalDateTime.now() + "] " + "Errore: il brano " + numBrano + " dell\'album " + ida + " esiste già";
			writer.write(message);
		}
		catch (IOException e) {
			this.message += "\r\n" + e.getMessage();
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				this.message += "\r\n" + e.getMessage();
			}
		}	
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}


}
