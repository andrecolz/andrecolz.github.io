import java.util.ArrayList;
import java.util.List;

public class ufficio {
    int id;
    private String nomeUfficio;
    private int piano;
    private String siglaLocale;
    private int numeroPostazioni;
    private String nomeResponsabile;
    List<dipendente> listD = new ArrayList<dipendente>();  

    public ufficio(int id, String nomeUfficio, int piano, String siglaLocale, int numeroPostazioni, String nomeResponsabile, List<dipendente> lista) {
        this.id = id;
        this.nomeUfficio = nomeUfficio;
        this.piano = piano;
        this.siglaLocale = siglaLocale;
        this.numeroPostazioni = numeroPostazioni;
        this.nomeResponsabile = nomeResponsabile;
        this.listD = lista;
    }

    public ufficio() {
        this.id = 0;
        this.nomeUfficio = "";
        this.piano = 0;
        this.siglaLocale = "";
        this.numeroPostazioni = 0;
        this.nomeResponsabile = "";
        this.listD = new ArrayList<dipendente>();
    }

    public String getNomeUfficio() {
        return nomeUfficio;
    }

    public int getPiano() {
        return piano;
    }

    public String getSiglaLocale() {
        return siglaLocale;
    }

    public int getNumeroPostazioni() {
        return numeroPostazioni;
    }

    public String getNomeResponsabile() {
        return nomeResponsabile;
    }

    public List<dipendente> getListD() {
        return listD;
    }

    public void setNomeUfficio(String nomeUfficio) {
        this.nomeUfficio = nomeUfficio;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public void setSiglaLocale(String siglaLocale) {
        this.siglaLocale = siglaLocale;
    }

    public void setNumeroPostazioni(int numeroPostazioni) {
        this.numeroPostazioni = numeroPostazioni;
    }

    public void setNomeResponsabile(String nomeResponsabile) {
        this.nomeResponsabile = nomeResponsabile;
    }

    public void setListD(List<dipendente> listD) {
        this.listD = listD;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toTesto(){
        return "ID ufficio: " + id + "\nNome ufficio: " + nomeUfficio + "\nPiano: " + piano + "\nSigla ufficio: " + siglaLocale + "\nNumero postazioni: " + numeroPostazioni + "\nNome responsabile: " + nomeResponsabile;
    }

    
}
