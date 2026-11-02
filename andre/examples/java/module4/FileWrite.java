import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {

    public static void fileWrite() throws IOException {
        FileOutputStream file;
        file = new FileOutputStream("output.txt");
        file.write("Hello, world!\n".getBytes());
        file.close();
    }

    public static void main(String[] args) {
        try {
            fileWrite();
        } catch (IOException e) {
            System.err.println("Error!");
        } finally {
            // cleanup?
        }
    }
}