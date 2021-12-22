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

    public void printCharCode(String code, String nameValute){
        String result = "Code: "+ code + " Наименование: " + nameValute;
        try {
            writeResult(result);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
