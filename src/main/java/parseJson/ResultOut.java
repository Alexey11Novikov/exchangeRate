package parseJson;
import java.io.*;

public class ResultOut {
    
    public void writeResult(String str) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(
                new File(this.getClass().getResource("result.txt").getPath()));
        writer.write(str);
        writer.flush();
        writer.close();
    }
}
