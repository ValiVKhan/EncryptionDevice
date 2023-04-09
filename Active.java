
import java.io.File;


public class Active {
    public static void main(String[] args) throws Exception {

        int level = 8;
        File file = new File("./samples/raw/test.txt");
        Encrypt.encryptFile(file, level);

        File files = new File("test_encrypted.txt");
        Decode.decodeFile(files, level);
        
    }
}
