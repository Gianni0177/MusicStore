package catalogo;

public class CdAlbum extends Album{

    public CdAlbum(int id, String titolo, String band, String strdataPubblicazione, String etichetta, double prezzo) {
        super(id, titolo, band, strdataPubblicazione, etichetta, prezzo);
    }

    @Override
    protected void stampaCopertina() {
        // TODO Auto-generated method stub
        super.stampacopertina();
    }
    
    

}
