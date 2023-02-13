package store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Log {
	
	public static void scriviMessaggio(String messaggio, String nomeFileLog) {
		
		BufferedWriter writer = null;
		// Scrivo un messaggio nel file di log
		try {	
			// Apro il file di log in modalità append, passando il valore "true" come secondo
			// parametro: https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html
			writer = new BufferedWriter(new FileWriter(nomeFileLog, true));
			writer.write("[" + LocalDateTime.now() + "] " + messaggio + "\r\n");
		}
		catch (IOException e) {
			System.out.println(messaggio + "\r\n" + e.getMessage());
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println(messaggio + "\r\n" + e.getMessage());
			}
		}	
	}
}
