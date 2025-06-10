package NotUsed;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class LexerOutput {
    public static void main(String[] args) throws Exception {
        // Read input from the file "fullProgram.txt"

        try {
            String testFileName = "fullProgram.txt";

            String testFilePath = "Testcases\\" + testFileName;
            String tokenFilePath = "Testcases\\Tokens\\" + "tokenizer" + testFileName;

            File tcFile = new File(testFilePath);

            File tokenFile = new File(tokenFilePath);

            tokenFile.createNewFile();

            FileWriter tokenVisualizer = new FileWriter(tokenFilePath);

            ANTLRInputStream input = new ANTLRFileStream(tcFile.toString());

            // Create lexer
            grammar.lexer.TinyLexer lexer = new grammar.lexer.TinyLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

//            System.out.println("Tokens:");
            lexer.reset();  // Reset lexer before reading tokens

            tokenVisualizer.append("Token Text -> Token Type\n");
            for (Token token : lexer.getAllTokens()) {
                tokenVisualizer.append(token.getText())
                         .append(" -> ")
                         .append(lexer.getVocabulary().getSymbolicName(token.getType()))
                         .append('\n');
            }
            tokenVisualizer.close();

            tokens.seek(0);
        }
        catch (IOException e){
            System.err.println("Error: file is not read");
        }

    }
}