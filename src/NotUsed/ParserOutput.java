package NotUsed;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class ParserOutput {
    public static void main(String[] args) throws IOException {
        // Read input from the file "fullProgram.txt"
        ANTLRInputStream input = new ANTLRFileStream("Testcases\\elseifWithoutIf.txt");

        // Create lexer
        grammar.lexer.TinyLexer lexer = new grammar.lexer.TinyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create parser
        grammar.parser.TinyParser parser = new grammar.parser.TinyParser(tokens);

        // Parse input and get the parse tree
        ParseTree tree = parser.program();

        System.out.println(tree.toStringTree(parser));

        // Display parse tree GUI
        Trees.inspect(tree, parser);

    }
}
