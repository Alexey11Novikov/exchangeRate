import java.io.FileNotFoundException;

import parseJson.ParseJson;

public class MainFunction {
    public static void main(String[] args) throws FileNotFoundException {
        ParseJson parseJson =new ParseJson();
        parseJson.findBestValute();
    }
}
