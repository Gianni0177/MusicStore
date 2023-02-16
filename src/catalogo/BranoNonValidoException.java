package catalogo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import store.MusicStore;

// Eccezione di tipo unchecked
public class BranoNonValidoException extends RuntimeException {

	String message = "BNVE [" + LocalDateTime.now() + "] ";

	public BranoNonValidoException(int ida, int numBrano, String nomeFileLog) {
		BufferedWriter writer = null;
		// Scrivo un messaggio nel file di log
		// Nota: la registrazione nel file di log, viene fatta sempre
		// perchè tale operazione viene fatta nel costruttore, quindi, quando l'eccezione viene lanciata (throw).
		// Ciò avviene indipendentemente dal fatto che essa poi venga intercettata (try-catch)		
		try {	
			// Apro il file di log in modalità append, passando il valore "true" come secondo
			// parametro: https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html
			writer = new BufferedWriter(new FileWriter(nomeFileLog, true));
			this.message += "Errore: il brano " + numBrano + " dell\'album " + ida + " ha un numero non valido\r\n";
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
