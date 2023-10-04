import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

//LIBRERIA DI GOOGLE PER GESTIRE JSON, LINK SITO DOVE SPIEGA COME USARLA: https://www.html.it/articoli/parsing-json-semplice-con-google-gson/
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class App {
    public static void main(String[] args) throws Exception {
        //---------------PARTE CHE SCRIVE ARCHIVIO-----------------
        File file = new File("uffici.json");
        List<ufficio> uffici = new ArrayList<ufficio>();  
        if(!file.exists()){ //parte che scrive il file se non esiste
            List<dipendente> dl1 = new ArrayList<dipendente>();  
            List<dipendente> dl2 = new ArrayList<dipendente>();  
            List<dipendente> dl3 = new ArrayList<dipendente>();  
            dipendente d1 = new dipendente("Fasuto", "Gervasoni", "via gino 3, 22066", "04/10/2023", 32, 1);
            dipendente d2 = new dipendente("Huber", "Canton", "via pina 5, 22066", "04/10/2023", 36, 2);
            dipendente d3 = new dipendente("Marina", "Massironi", "via morandi 27, 22066", "04/10/2023", 30, 3);
            dipendente d4 = new dipendente("Pino", "Napolitano", "via napoli 13, 22066", "04/10/2023", 22, 1);
            dipendente d5 = new dipendente("Luca", "Zaia", "via veneto 6, 22066", "04/10/2023", 41, 1);
            dipendente d6 = new dipendente("Andrea", "Obama", "via america 9, 22066", "04/10/2023", 38, 1);
            dipendente d7 = new dipendente("Luca", "Backett", "via milano 7, 22066", "04/10/2023", 37, 2);
            dipendente d8 = new dipendente("Fabrizio", "Corona", "via pechino 28, 22066", "04/10/2023", 30, 3);
            dl1.add(d1);
            dl1.add(d4);
            dl1.add(d5);
            dl1.add(d6);
            dl2.add(d2);
            dl2.add(d7);
            dl3.add(d3);
            dl3.add(d8);
            ufficio u1 = new ufficio(1, "ricerca e sviluppo", 2, "RES", 3, "Fausto Gervasoni", dl1);
            ufficio u2 = new ufficio(2, "magazzino", 0, "MG", 2, "Huber Canton", dl2);
            ufficio u3 = new ufficio(3, "segreteria", 1, "STR", 2, "Marina Massironi", dl3);
            uffici.add(u1);
            uffici.add(u2);
            uffici.add(u3);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter fileWriter = new FileWriter("uffici.json");
            gson.toJson(uffici, fileWriter);
            fileWriter.close();
        } else {    //parte che legge il file se esiste
            FileReader fileReader = new FileReader("uffici.json");
            Gson gson = new Gson();
            Type ufficiListType = new TypeToken<List<ufficio>>() {}.getType();  //essendo una lista serve dichiarare che tipi di oggetti sono presenti dentro la lista
            uffici = gson.fromJson(fileReader, ufficiListType);
        }
        //---------------------------------------------------------



        //------------------PARTE CHE VISUALIZZA-------------------
        System.out.println("Numero di uffici: " + uffici.size());
        for(int i = 0; i < uffici.size(); i++){
            System.out.println(uffici.get(i).toTesto());
            System.out.print("Dipendenti: ");

            for(int j = 0; j < uffici.get(i).getListD().size(); j++){
                System.out.print((j+1) + ")" + uffici.get(i).getListD().get(j).toTesto() + "   ");
            }
            System.out.println("\n");
        }
        //---------------------------------------------------------



        //--------PARTE CHE AGGIUNGE DATI E LI SALVA---------------
        List<dipendente> dl4 = new ArrayList<dipendente>();  
        dipendente d1 = new dipendente("Lorenzo", "Fontana", "via lombardia 14, 22066", "04/10/2023", 32, 4);
        dipendente d2 = new dipendente("Letizia", "Moratti", "via lombardia 14, 22066", "04/10/2023", 36, 4);
        dl4.add(d1);
        dl4.add(d2);
        ufficio u4 = new ufficio(4, "marketing", 1, "MRK", 2, "Lorenzo Fontana", dl4);
        uffici.add(u4);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("uffici.json");
        gson.toJson(uffici, fileWriter);
        fileWriter.close();
        System.out.println("Sono stati aggiunti altri dati e sono stati salvati");
        //---------------------------------------------------------
    }
}