package FileWriting;


public class FileWriterSync {
    public static void FileWriter(String name, String data) {
        try {
            Clients c = new Clients();
            c.GetFileCreation(name, data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

