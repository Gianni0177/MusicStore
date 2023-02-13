package catalogo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import store.MusicStore;

// Eccezione di tipo unchecked
public class PostiArrayEsauritiException extends RuntimeException {

	String message = "PAEE [" + LocalDateTime.now() + "] ";

	public PostiArrayEsauritiException(String nomeArray, String nomeFileLog) {
		
		BufferedWriter writer = null;
		// Scrivo un messaggio nel file di log
		// Nota: la registrazione nel file di log, viene fatta sempre
		// perchè tale operazione viene fatta nel costruttore, quindi, quando l'eccezione viene lanciata (throw).
		// Ciò avviene indipendentemente dal fatto che essa poi venga intercettata (try-catch)
		try {	
			// Apro il file di log in modalità append, passando il valore "true" come secondo
			// parametro: https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html
			writer = new BufferedWriter(new FileWriter(nomeFileLog, true));
			this.message += "Errore: i posti nell'array " + nomeArray + " sono esauriti\r\n";
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
