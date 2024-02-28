package pathclass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClassExample {


    public static void main(String[] args) throws IOException {


        Path path = Paths.get("HelloWorld.txt");
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path path2 = Paths.get("src/pathclass/HelloWorld.text");
        System.out.println(path2.getParent());
        System.out.println(path2.getRoot());
        System.out.println(path2.getFileName());


    }

}
