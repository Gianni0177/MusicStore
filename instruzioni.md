Modificare l'applicazione MusicStore:

https://classroom.google.com/c/NTI3NzA3ODQ1Mjcx/m/NDkxMzc2NzY0NzU3/details

in modo che essa possa gestire più album:

- creare una classe Catalogo, contenente i seguenti attributi/metodi:
    -- nome catalogo
    -- data creazione
    -- numero di album contenuti (da aggiornare correntemente)
    -- array album (massimo numero di album: 1000)

- caricaAlbum(String nomefile): questo metodo deve leggere il file album.csv il cui formato è uguale al formato del file brani.csv con l'aggiunta di un nuovo campo (all'inizio) che rappresenta l'id dell'album a cui il brano si riferisce. Il metodi deve leggere il file (riga per riga) e, per ogni riga letta:
    -- creare un nuovo album se esso non esiste nell'array (il controllo viene fatto tramite l'id), quindi, creare il brano ed inserirlo nell'album; in ultima, inserire l'album nel catalogo.
    -- nel caso in cui l'album esista, prima di creare ed inserire il nuovo brano, controllare che esso non esista già (usare il numero del brano)
    -- dove necessario lanciare una eccezione che visualizzi il messaggio "BRANO GIA' ESISTENTE".
- creare i nuovi oggetti e testarne il corretto funzionamento metodi dei metodi nella classe di test (main).