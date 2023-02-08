package catalogo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Catalogo {
    private String nome;
    private Date dataCreazione;
    private int ida;
    private ArrayList<Album> album;

    public Catalogo(String nome, Date dataCreazione, int ida, ArrayList<Album> album) {
        this.nome = nome;
        this.dataCreazione = dataCreazione;
        this.ida = ida;
        this.album = album;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public ArrayList<Album> getAlbum() {
        return album;
    }

    public void setAlbum(ArrayList<Album> album) {
        this.album = album;
    }

public void caricaAlbum(String nomeFileCsv) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nomeFileCsv));
        String riga = br.readLine();
        while (riga != null) {
            String[] fields = riga.split("|");
            String nomeAlbum = fields[0];
            String titolo = fields[1];
            int numeroBrano = Integer.parseInt(fields[2]);
            int durataBrano = Integer.parseInt(fields[3]);
            boolean albumEsisite = false;
            for (Album album : album) {
                if (album.getTitolo().equals(nome)) {
                    albumEsisite = true;
                    boolean branoEsiste = false;
                    for (Brano song : album.getBrani()) {
/*                      if (brano.getNumeroBrano == numero brano) {
                            branoEsiste = true;
                            throw new IllegalArgumentException("Il brano esiste");
                     }
*/                    }
/*                    if (!branoEsiste) {
                        album.getBrani().add(new Brano(titolo, numeroBrano, durataBrano));
                    }
*/                }
            }
/*            if (!albumEsisite) {
                ArrayList<Brano> song = new ArrayList<>();
                songs.add(new Brano(titolo, numeroBrano, durataBrano));
                album.add(new Album(nomeAlbum, songs));
            }
            riga = br.readLine();
*/
        }
    }
}

/** Prof se è arrivato a leggere fino a qua bene altrimenti pace.
 * Se gli è spuntata la domanda : si mi sono fatto aiutare sia nel web che da amici.
 * 
 *  Penso che prima di avanzare nel progetto MusicStore bisogna correggere gli errori già
 *  esistenti, perchè rallentano molto lo sviluppo autonomo(senza il suo supporto) di codice.
 *  
 *  Cordiali saluti Gianni Nacu
 * */ 
 


