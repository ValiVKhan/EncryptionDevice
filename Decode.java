import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Decode {

    private static File file;
    private static String s = new String(IntStream.rangeClosed(32, 126).toArray(), 0, 95);
    private static char[] ascii = s.toCharArray();

    public static File decodeFile(File givenFile, int level) throws IOException{

        file = givenFile;
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        // parse array
        HashMap<String, Character> key = getReverseKey(st, level);

        try (//String newName = givenFile.getName() + "encoded";
        FileWriter myWriter = createBaseFile(givenFile)) {
            st = br.readLine();
            myWriter.append("\n");
            while (st != null){
                int begin = 0;
                int end = level+1;
                for (int i = 0; i < st.length(); i+=level-1){
                    if (end > st.length()){
                        break;
                    }
                    String value = st.substring(begin, end);
                    char val = key.get(value);
                    begin += level+1;
                    end += level+1;
                    myWriter.append(val);

                }
                myWriter.append("\n");
                st = br.readLine();
            }
        }


        return null;
    }

    private static HashMap<String, Character> getReverseKey(String parse, int length){

        HashMap<String, Character> revKey = new HashMap<>();
        int begin = 3;
        int end = 4 + length;
        for (int i = 0; i < ascii.length; i++){
            String num = parse.substring(begin, end);
            //System.out.println(num + " " + ascii[i]);
            revKey.put(num, ascii[i]);
            begin += length + 5;
            end += length + 5;
        }

        return revKey;
    }
    
    private static FileWriter createBaseFile(File givenFile) throws IOException{
        String curName = givenFile.getName();
        int till = curName.indexOf("_encrypted");
        StringBuilder newName = new StringBuilder();
        for (int i = 0; i < till; i++){
            newName.append(curName.charAt(i));
        }
        newName.append("_decode.txt");
        FileWriter myWriter = new FileWriter(newName.toString());
        return myWriter;
    }

    
}
