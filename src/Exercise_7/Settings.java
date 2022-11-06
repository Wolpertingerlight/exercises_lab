package Exercise_7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Settings {
    private HashMap <String, Integer> MyMap;

    public Settings() {
        MyMap = new HashMap<>();
    }

    public void put(String string, int number) {
        MyMap.put(string, number);
    }

    public int get(String string){
        return MyMap.get(string);
    }

    public void delete(String string) {
        MyMap.remove(string);
    }

    public void saveFromBinaryFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        byte[] buffer;
        for(Map.Entry i : MyMap.entrySet()) {
            String string = i.getKey()+ " " + i.getValue() + '\n';
            buffer = string.getBytes();
            fos.write(buffer);
        }
        fos.close();
    }

    public void loadFromBinaryFile(String filename) throws  IOException{
        FileInputStream fis = new FileInputStream(filename);

        byte[] buffer = new byte[fis.available()];
        fis.read(buffer, 0, fis.available());

        int count  = 0;
        String sKey = "";
        String sValue = "";
        int val;
        for(int i=0; i < buffer.length; i++) {
            if ((char) buffer[i] == '\n') {
                count = 0;
                val = Integer.parseInt(sValue);
                MyMap.put(sKey, val);
                sKey = "";
                sValue = "";
                val = 0;
                continue;
            }
            if ((char) buffer[i] == ' ') {
                count = 1;
                continue;
            }
            if (count == 0) {
                sKey = sKey + (char) buffer[i];
                continue;
            }
            if (count == 1) {
                sValue = sValue + (char) buffer[i];
            }
        }
    }

    public void loadFromTextFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);

        int count  = 0;
        String sKey = "";
        String sValue = "";
        int val = 0;

        int i;
        while((i=fr.read())!=-1) {
            if (i == '\n') {
                count = 0;
                val = Integer.parseInt(sValue);
                MyMap.put(sKey, val);
                sKey = "";
                sValue = "";
                val = 0;
                continue;
            }
            if (i == ' ') {
                count = 1;
                continue;
            }
            if (count == 0) {
                sKey = sKey + (char)i;
                continue;
            }
            if (count == 1) {
                sValue = sValue + (char)i;
            }
        }
    }

    public void saveToTextFile(String filename) throws  IOException{
        FileWriter fw = new FileWriter(filename, false);
        for(Map.Entry i : MyMap.entrySet()) {
            String s = i.getKey()+ " " + i.getValue() + '\n';
            fw.write(s);
        }
        fw.close();
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Map.Entry i : MyMap.entrySet()){
            str.append(i.getKey() + ":   " + i.getValue() + "\n");
        }
        return str.toString();
    }

    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(this == null)
            return false;
        if(!(o instanceof Settings))   //this.getClass() != o.getClass()
            return false;

        Settings obj = (Settings) o;
        if(MyMap.size() != obj.MyMap.size())
            return false;

        for(Map.Entry i : MyMap.entrySet()) {
            int count  = 0;
            for(Map.Entry j : obj.MyMap.entrySet()) {
                if(i.getKey() == j.getKey() && i.getValue() == j.getValue()){
                    count = 1;
                    break;
                }
            }
            if(count == 0)
                return false;
        }
        return true;
    }
}
