import java.io.*;

public class MultiCatch {

    public static void main(String args[]) {

        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
        }
        catch (IOException ioEx) {
            System.out.println(ioEx);
        }catch (Exception Ex) {
            System.out.println(Ex);
        }
    }
}