package parseJson;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ResultOut {
    
    public void writeResult(String str) throws IOException {
        writeFile("src\\main\\resources\\result.txt", str);
    }

    private static void writeFile(String path, String data)  {
        try {
            FileWriter writer = new FileWriter(path, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(data);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void printCharCode(String code, String nameValute) throws IOException {
        String result = "Code: "+ code + " Наименование: " + nameValute;
        try {
            writeResult(result);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
