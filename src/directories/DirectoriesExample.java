package directories;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoriesExample {

    public static void main(String[] args) {

        FilenameFilter filter = (file, fileName) -> fileName.contains(".");

        String[] contents = new File(".").list(filter);

        for (String file : contents) {
            System.out.println(file);
        }

        new File("MyDirectory").mkdir();


    }
}
