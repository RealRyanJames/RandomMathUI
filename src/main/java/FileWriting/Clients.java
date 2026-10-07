package FileWriting;

import java.io.File;
import java.io.FileWriter;

public class Clients implements IClientFile {

    public void GetFileCreation(String name, String data) {

        File file = new File(name.toLowerCase());

        try (FileWriter writer = new FileWriter(file.getName())) {
            writer.write(data);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
