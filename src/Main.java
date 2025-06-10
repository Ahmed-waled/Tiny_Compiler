import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileToParse = new File("fullProgram.txt");

        ScannerParser.dir = new File("Testcases");

        ScannerParser.scanAndParse(fileToParse, true);

       ScannerParser.ASTCreator();

       ScannerParser.semanticChecker();

       ScannerParser.generateTAC();



    }
}
