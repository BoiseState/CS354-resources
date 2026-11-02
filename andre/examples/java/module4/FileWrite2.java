import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite2 {

    public static void fileWrite() {
        FileOutputStream file;

        try {
            file = new FileOutputStream("output.txt");
        } catch (IOException e) {
            System.out.println("Open error: " + e);
            return;
        }

        try {
            file.write("Hello, world!\n".getBytes());
        } catch (IOException e) {
            System.out.println("Write error: " + e);
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                System.out.println("Close error: " + e);
            }
        }

    }
    public static void main(String[] args) {
        fileWrite();
    }
}