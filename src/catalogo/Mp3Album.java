package catalogo;

public class Mp3Album extends Album{

    public Mp3Album(int id, String titolo, String band, String strdataPubblicazione, String etichetta, double prezzo) {
        super(id, titolo, band, strdataPubblicazione, etichetta, prezzo);
    }

    @Override
    protected void stampacopertina() {
        System.out.println("Album [titolo=" + this.getTitolo() + ", band=" + this.getArtisti() + ", dataPubblicazione=" + this.getdataPubblicazione() + ", etichetta=" + getEtichetta()
        + ", prezzo=" + this.getPrezzo() + this.stampaBrani() + "]");
    }
    
    

}