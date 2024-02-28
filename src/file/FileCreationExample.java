package file;

import java.io.File;
import java.io.IOException;

public class FileCreationExample {

    public static void main(String[] args) throws IOException {

        File myFile = new File("/Users/owenhughes/IdeaProjects/SolutionsNeet/src/file/myFile.text");

        try {
            boolean fileCreated = myFile.createNewFile();
            System.out.println(fileCreated);
        } catch (IOException e) {

        }

    }

}
