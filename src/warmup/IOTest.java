package warmup;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class IOTest {
    public static void main(String[] args) {
        String line;
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        try {
            System.out.print("λ ");
            while ((line = in.readLine()) != null) {
                System.out.println("Line: \"" + line + "\"");
                System.out.print("λ ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
