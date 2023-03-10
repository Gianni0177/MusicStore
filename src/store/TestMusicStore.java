package store;
import java.time.LocalDate;

import anagrafica.Persona;
import catalogo.Album;
import catalogo.Brano;
import catalogo.Catalogo;

/**
 * @author Aula Lim
 *
 */
public class TestMusicStore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TEST CREAZIONE Album
		System.out.println("-------- TEST CREAZIONE Album");
		Album alb1=new Album(1, "still","joy division", "1979-01-01", "emi", 12.0);
		//Album alb2=new Album( "still","joy division", "1979-01-01", "emi",12.0);
		//Album alb3=new Album( "still","joy division", "1979-01-01", "emi",12.0);
		System.out.println(alb1.toString());
		/*
		Album.cambiaContatore(-10);
		System.out.println(alb1.getContatoreAlbum());
		Album.visualizzaProprietario();
		alb1.visualizzaProprietario();
		*/
		
		// TEST CREAZIONE Catalogo
		System.out.println("-------- TEST CREAZIONE Catalogo (caricamento da file)");
		// TODO: prevedere la possibilit√† che il nome del catalogo venga costruito in base al nome 
		// del file
		Catalogo c1 = new Catalogo("Catalogo 1", LocalDate.parse("2023-01-19"), MusicStore.NOME_FILE_CSV, true);
		Catalogo c2 = new Catalogo("Catalogo 2", LocalDate.parse("2023-01-19"), MusicStore.NOME_FILE_CSV, true);
		System.out.println(c1.toString());	
	}

}
