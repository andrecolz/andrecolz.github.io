import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GestioneUffici{
    private List<Ufficio> lista = new ArrayList<Ufficio>();

    public GestioneUffici() {
        this.lista = new ArrayList<Ufficio>();
    }

    public void serializeGU(String filename) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeInt(this.lista.size());
        for(int i = 0; i < this.lista.size(); i++){
            this.lista.get(i).serializeUfficio(objectOutputStream);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.println("dati serializzati");
    }

    public void deserializeGU(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        int numUffici = objectInputStream.readInt();

        for (int i = 0; i < numUffici; i++) {
            Ufficio ufficio = Ufficio.deserializeUfficio(objectInputStream);
            this.lista.add(ufficio);
        }
        objectInputStream.close();
    }

    public void push(Ufficio u){
        lista.add(u);
    }

    public void visualizza(){
        for(int i = 0; i < this.lista.size(); i++){
            System.out.println("\nUfficio " + (i+1) + ":");
            this.lista.get(i).visualizza();
        }
    }

    public void aggiungiDaCsv(String fileD, String fileU) throws IOException{
        BufferedReader readerD = new BufferedReader(new FileReader(fileD));
        BufferedReader readerU = new BufferedReader(new FileReader(fileU));
        String linea = "";


        while((linea = readerU.readLine()) != null){
            Ufficio ufficio = Ufficio.leggiCsv(linea);
            this.lista.add(ufficio);
        }

        while((linea = readerD.readLine()) != null){
            Dipendente dipendente = Dipendente.leggiCsv(linea);
            for(int i = 0; i < this.lista.size(); i++){
                if(this.lista.get(i).getIdUfficio() == Integer.parseInt(dipendente.getCodiceUfficioAppartenenza())){
                    this.lista.get(i).getListD().add(dipendente);
                }
            } 
        }

        readerD.close();
        readerU.close();

        System.out.println("dati dei file " + fileD + " e " + fileU + " aggiunti");
    }
}