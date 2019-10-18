import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;


public class Clients implements Serializable {

    File file = new File("./data/clients.dat");

    private List < Client > lista;

    public Clients() {
        lista = new ArrayList < > ();
        this.load();
    }

    public void add(Client s) {
        lista.add(s);
    }

    public void remove(Client s) {
        lista.remove(s);
    }


    public Client getFromList(int i) {
        return lista.get(i);
    }

    public Client pobierz(Client s) {
        Client poj = null;
        int l = lista.size();
        for (int i = 0; i < l; i++) {
            if (lista.get(i).equals(s))
                return (Client) lista.get(i);
        }
        return poj;
    }

    public List < Client > pobierzliste() {
        return lista;
    }


    public void save() throws IOException {
        ObjectOutputStream bufferOut = null;
        try {
            bufferOut = new ObjectOutputStream(new FileOutputStream(file));
            bufferOut.writeObject(this);

        } finally {
            bufferOut.close();
        }
    }


    public void addAndSave(Client s){
        s.update();
        this.lista.add(s);
        this.saveAll();
    }


    public void saveAll(){
        
        try {
        int l = this.lista.size();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < l; i++) {
                
                oos.writeObject(lista.get(i));

            }

            oos.flush();
            oos.close();

        } catch (IOException ex) {
            
        }
    }


    public void load() {
        ObjectInputStream bufferIn = null;

        try {
            bufferIn = new ObjectInputStream(new FileInputStream(file));
            Object obj = null;

            while ((obj = bufferIn.readObject()) != null) {
                
                if (obj instanceof Client) {
                    this.add(((Client) obj));
                   // System.out.println("test " + obj.toString());
                }
            }

            bufferIn.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }


        }



    }