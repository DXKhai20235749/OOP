package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

    public static void createGarbage(String filename) throws IOException {
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        String outputString = "";

        inputBytes = Files.readAllBytes(Paths.get(filename));

        startTime = System.currentTimeMillis();

        for (byte b : inputBytes) {
            outputString += (char) b;
        }

        endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }

    public static void main(String[] args) {
        try {
            createGarbage("E:\\test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}