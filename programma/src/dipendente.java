public class dipendente {
    private String nome;
    private String cognome;
    private String residenza;
    private String assunzione;
    private int oreSettimanali;
    private int ufficio;
    
    public dipendente(String nome, String cognome, String residenza, String assunzione, int oreSettimanali, int ufficio) {
        this.nome = nome;
        this.cognome = cognome;
        this.residenza = residenza;
        this.assunzione = assunzione;
        this.oreSettimanali = oreSettimanali;
        this.ufficio = ufficio;
    }

    public dipendente() {
        this.nome = "";
        this.cognome = "";
        this.residenza = "";
        this.assunzione = "";
        this.oreSettimanali = 0;
        this.ufficio = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getResidenza() {
        return residenza;
    }

    public String getAssunzione() {
        return assunzione;
    }

    public int getOreSettimanali() {
        return oreSettimanali;
    }

    public int getUfficio() {
        return ufficio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    public void setAssunzione(String assunzione) {
        this.assunzione = assunzione;
    }

    public void setOreSettimanali(int oreSettimanali) {
        this.oreSettimanali = oreSettimanali;
    }

    public void setUfficio(int ufficio) {
        this.ufficio = ufficio;
    }

    public String toTesto(){
        return nome + " " + cognome;
    }    
}
