import java.util.HashMap;
import java.util.stream.IntStream;


public class Key{

    private static HashMap<Integer, Integer> key = new HashMap<>();
    private static String s = new String(IntStream.rangeClosed(32, 126).toArray(), 0, 95);
    private static char[] ascii = s.toCharArray();

    private static int[] given = new int[ascii.length];

    private static int level = 3;
    public static HashMap<Integer, Integer> createKey(int level) throws Exception{

        if (level <= 0){
            throw new Exception("The level cannot be 0, it defaults to 3");
        }
        // create a value possibles
        int minVal = (int) Math.pow(10, level);
        int maxVal = (int) Math.pow(10, level+1)-1;
        for (int i = 0; i < ascii.length; i++){
            int randomKey = (int) (Math.random() *(maxVal - minVal + 1) + minVal);

            for (int j = 0; j < given.length; j++){
                if (randomKey == given[j]){
                    randomKey = (int) (Math.random() *(maxVal - minVal + 1) + minVal);
                    j = 0;
                }
            }

            key.put((int)ascii[i], randomKey);
        }
        return key;
    }

    public static HashMap<Integer, Integer> createKey() throws Exception{
        return createKey(level);
    }
}

