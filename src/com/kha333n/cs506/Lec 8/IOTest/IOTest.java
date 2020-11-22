import java.io.*;

public class IOTest{

    public static void main(String args[]) {

        try {
            FileReader fileReader = new FileReader(FileDescriptor.in);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int counter = 1;

            do {
                String line = bufferedReader.readLine();
                if (line.equals("")){
                    break;
                }
                String concatenated = counter + " " + line + "\n";
                bufferedWriter.write(concatenated);

                counter++;
            }while (true);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException ioException){
            System.out.println(ioException);
        }
    }
}