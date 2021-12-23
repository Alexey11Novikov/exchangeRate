package parseJson;
import java.io.*;


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

    public void printCharCode(String code, String nameValute)  {
        String result = "Code: "+ code + " Наименование: " + nameValute + "\n";
        try {
            writeResult(result);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printTopValute(String valute, int i) {
        String result ="Top 5 valute: " + (i + 1) + ": "+ valute + "\n";
        try {
            writeResult(result);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void printDate(String date) {
        String result ="date: " + date + "\n";
        try {
            writeResult(result);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
