import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Dipendente implements Serializable{
    private int idDipendente;
    private String dataNascita;
    private String dataAssunzione;
    private String codiceUfficioAppartenenza;
    private String cognome;
    private String nome;
    private String indirizzo;

    public Dipendente(int idDipendente, String dataNascita, String dataAssunzione, String codiceUfficioAppartenenza, String cognome, String nome, String indirizzo) {
        this.idDipendente = idDipendente;
        this.dataNascita = dataNascita;
        this.dataAssunzione = dataAssunzione;
        this.codiceUfficioAppartenenza = codiceUfficioAppartenenza;
        this.cognome = cognome;
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public Dipendente() {
        this.idDipendente = 0;
        this.dataNascita = "";
        this.dataAssunzione = "";
        this.codiceUfficioAppartenenza = "";
        this.cognome = "";
        this.nome = "";
        this.indirizzo = "";
    }
   
    public void setIdDipendente(int idDipendente) {
        this.idDipendente = idDipendente;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setDataAssunzione(String dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public void setCodiceUfficioAppartenenza(String codiceUfficioAppartenenza) {
        this.codiceUfficioAppartenenza = codiceUfficioAppartenenza;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getIdDipendente() {
        return idDipendente;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public String getDataAssunzione() {
        return dataAssunzione;
    }

    public String getCodiceUfficioAppartenenza() {
        return codiceUfficioAppartenenza;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void serializeDipendente(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this);
    }

    public static Dipendente deserializeDipendente(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Dipendente dipendente = (Dipendente) objectInputStream.readObject();
        return dipendente;
    }

    public void visualizza(){
        System.out.print("Id dipendente: " + this.idDipendente + " Data nascita: " + this.dataNascita + " Data assunzione: " + this.dataAssunzione + " Codice ufficio appartenenza: " + this.codiceUfficioAppartenenza + " Nome: " + this.nome + " Cognome: " + this.cognome + " Indirizzo: " + this.indirizzo);
    }

    public static Dipendente leggiCsv(String linea){
        Dipendente dtmp = new Dipendente();
        String v[] = linea.split(";");
        dtmp.idDipendente = Integer.parseInt(v[0]);
        dtmp.dataNascita = v[1];
        dtmp.dataAssunzione = v[2];
        dtmp.codiceUfficioAppartenenza = v[3];
        dtmp.cognome = v[4];
        dtmp.nome = v[5];
        dtmp.indirizzo = v[6];
        
        return dtmp;
    }
}