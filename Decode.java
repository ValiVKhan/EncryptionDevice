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

    public static File decodeFile(File givenFile) throws IOException{

        file = givenFile;
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        int level = Integer.parseInt(br.readLine());
        // parse array
        HashMap<String, Character> key = getReverseKey(st, level);

        try (
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

                    char val = (char) key.get(value);
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

        int lenCount = 0;
        int asciiCount = 0;
        while (lenCount < parse.length()){
            if (parse.charAt(lenCount) == '='){

                revKey.put(parse.substring(lenCount+1, lenCount+length+2), ascii[asciiCount]);
                asciiCount++;
            }
            lenCount++;
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
