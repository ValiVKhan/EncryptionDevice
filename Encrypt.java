import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Encrypt {
    

    private static File file;


    public static void encryptFile(File givenFile, int level) throws Exception{

        HashMap<Integer, Integer> key = Key.createKey(level);
        file = givenFile;
        BufferedReader br = new BufferedReader(new FileReader(file));
 
        // Declaring a string variable
        String st = br.readLine();
        if (st == null){
            throw new Exception("file cannot be blank");
        }
        try (//String newName = givenFile.getName() + "encoded";
        FileWriter myWriter = createBaseFile(givenFile, key, level)) {
            myWriter.append("\n");
            while (st != null){

                for (int i = 0; i < st.length(); i++){
                    String encoded = key.get((int)st.charAt(i)) + "";
                    CharSequence cs = encoded;
                    myWriter.append(cs);
                }
                myWriter.append("\n");
                st = br.readLine();
            }
        }
    }

    private static FileWriter createBaseFile(File givenFile, HashMap<Integer, Integer> key, int level) throws IOException{
        String curName = givenFile.getName();
        int till = curName.indexOf(".txt");
        StringBuilder newName = new StringBuilder();
        for (int i = 0; i < till; i++){
            newName.append(curName.charAt(i));
        }
        newName.append("_encrypted.txt");
        FileWriter myWriter = new FileWriter(newName.toString());
        myWriter.append(key.toString());
        myWriter.append("\n");
        myWriter.append(level+"");

        return myWriter;
    }
    
    
}
