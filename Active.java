
import java.io.File;
import java.util.Scanner;


public class Active {
    public static void main(String[] args) throws Exception {
        Scanner thiss = new Scanner(System.in);
        while (true){
            ask(thiss);
            int val = thiss.nextInt();
            if (val == 1){
                thiss = new Scanner(System.in);
                System.out.println("Enter file path: ");
                String givenFile = thiss.nextLine();
                File file = new File(givenFile);
                System.out.println("Enter level of encryption: ");
                int level = thiss.nextInt();
                Encrypt.encryptFile(file, level);
                break;
            } else if (val == 2){
                thiss = new Scanner(System.in);
                System.out.println("Enter encrypted file path: ");
                String givenFile = thiss.nextLine();
                File files = new File(givenFile);
                Decode.decodeFile(files);
                break;
            } else{
                break;
            }
        }
        
        
    }

    private static String getName(String path){

        for (int i = path.length()-1; i > 0; i--){
            if (path.charAt(i) == '/'){
                return path.substring(i+1, path.length()-4);
            }
        }
        return null;
    }

    private static void ask(Scanner thiss){
        System.out.println("Select one of the following options: ");
        System.out.println("1. Ecrypt File");
        System.out.println("2. Decode encrypted file");
        System.out.println("3. Quit system");
    }
}
