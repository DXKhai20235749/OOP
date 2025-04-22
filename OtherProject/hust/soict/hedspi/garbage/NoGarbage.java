package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get("E:\\test.txt"));  // file-name.txt
            StringBuilder content = new StringBuilder();
            for (byte b : inputBytes) {
                content.append((char) b);
            }
            System.out.println("File: OK");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}