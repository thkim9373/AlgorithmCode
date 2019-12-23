import java.io.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write("Hello world!!!");

        reader.close();
        writer.close();
    }
}
