public class Azienda {                                           //SITO PER REALIZZARE SERIALIZE() E DESERIALIZE() OGGETTI IN JAVA: https://www.baeldung.com/java-serialization
    public static void main(String[] args) throws Exception {
        GestioneUffici gu = new GestioneUffici();   
        gu.deserializeGU("file.colz");                         //---------------(1) PARTE CHE CARICA DATI--------------------
       
        gu.visualizza();                                                //---------------(2) PARTE CHE VISUALIZZA DATI----------------
        
        gu.aggiungiDaCsv("dipendenti.csv", "uffici.csv");   //---------------(3) PARTE CHE AGGIUNGE DATI------------------

        gu.serializeGU("file.colz");                           //---------------(4) PARTE CHE SALVA DATI--------------------
    }
}