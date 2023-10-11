import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ufficio implements Serializable{
    private int idUfficio;
    private String codiceUfficio;
    private int numeroPosti;
    private int idResponsabile;
    private String nomeUfficio;
    private String piano;
    private List<Dipendente> listD = new ArrayList<Dipendente>();

    public Ufficio(int idUfficio, String codiceUfficio, int numeroPosti, int idResponsabile, String nomeUfficio, String piano, List<Dipendente> lista) {
        this.idUfficio = idUfficio;
        this.codiceUfficio = codiceUfficio;
        this.numeroPosti = numeroPosti;
        this.idResponsabile = idResponsabile;
        this.nomeUfficio = nomeUfficio;
        this.piano = piano;
        this.listD = lista;
    }

    public Ufficio() {
        this.idUfficio = 0;
        this.codiceUfficio = "";
        this.numeroPosti = 0;
        this.idResponsabile = 0;
        this.nomeUfficio = "";
        this.piano = "";
        this.listD = new ArrayList<Dipendente>();
    }

    public int getIdUfficio() {
        return idUfficio;
    }

    public String getCodiceUfficio() {
        return codiceUfficio;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public int getIdResponsabile() {
        return idResponsabile;
    }

    public String getNomeUfficio() {
        return nomeUfficio;
    }

    public String getPiano() {
        return piano;
    }

    public List<Dipendente> getListD() {
        return listD;
    }

    public void setIdUfficio(int idUfficio) {
        this.idUfficio = idUfficio;
    }

    public void setCodiceUfficio(String codiceUfficio) {
        this.codiceUfficio = codiceUfficio;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public void setIdResponsabile(int idResponsabile) {
        this.idResponsabile = idResponsabile;
    }

    public void setNomeUfficio(String nomeUfficio) {
        this.nomeUfficio = nomeUfficio;
    }

    public void setPiano(String piano) {
        this.piano = piano;
    }

    public void setListD(List<Dipendente> listD) {
        this.listD = listD;
    }

    public void serializeUfficio(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.idUfficio);
        objectOutputStream.writeObject(this.codiceUfficio);
        objectOutputStream.writeInt(this.numeroPosti);
        objectOutputStream.writeInt(this.idResponsabile);
        objectOutputStream.writeObject(this.nomeUfficio);
        objectOutputStream.writeObject(this.piano);
        objectOutputStream.writeInt(this.listD.size());
        for(int i = 0; i < this.listD.size(); i++){
            this.listD.get(i).serializeDipendente(objectOutputStream);
        }
    }

    public static Ufficio deserializeUfficio(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Ufficio utmp = new Ufficio();
        utmp.idUfficio = objectInputStream.readInt();
        utmp.codiceUfficio = (String) objectInputStream.readObject();
        utmp.numeroPosti = objectInputStream.readInt();
        utmp.idResponsabile = objectInputStream.readInt();
        utmp.nomeUfficio = (String) objectInputStream.readObject();
        utmp.piano = (String) objectInputStream.readObject();
    
        int numDipendenti = objectInputStream.readInt();
    
        for (int i = 0; i < numDipendenti; i++) {
            Dipendente dipendente = Dipendente.deserializeDipendente(objectInputStream);
            utmp.listD.add(dipendente);
        }

        return utmp;
    }

    public void visualizza(){
        System.out.print("Id ufficio: " + this.idUfficio + "\nCodice ufficio: " + this.codiceUfficio + "\nNumero posti: " + this.numeroPosti + "\nId responsabile: " + this.idResponsabile + "\nNome ufficio: " + this.nomeUfficio + "\nPiano: " + this.piano + "\nNum dipendenti " + this.listD.size() + ":");
        for(int i = 0; i < listD.size(); i++){
            System.out.print("\nDipendente " + (i+1) + ": ");
            listD.get(i).visualizza();
        } 
        System.out.println("\n");
    }

    public static Ufficio leggiCsv(String linea){
        Ufficio utmp = new Ufficio();
        String v[] = linea.split(";");
        utmp.idUfficio = Integer.parseInt(v[0]);
        utmp.codiceUfficio = v[0];
        utmp.numeroPosti = Integer.parseInt(v[0]);
        utmp.idResponsabile = Integer.parseInt(v[0]);
        utmp.nomeUfficio = v[0];
        utmp.piano = v[0];
        
        return utmp;
    }
}