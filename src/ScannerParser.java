import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Semantic_TAC.*;

import grammar.lexer.TinyLexer;

import grammar.parser.TinyParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class ScannerParser {
    public static File dir = null;
    public static TinyLexer lexer;
    public static CommonTokenStream tokens;
    public static TinyParser parser;
    public static ParseTree tree;
    ScannerParser(String testcaseDirPath){
        dir = new File(testcaseDirPath);
    }

    public static void scanAndParse(File file, boolean outputToken){
        try {
            String testFilePath = dir + "\\" + file;

            File tcFile = new File(testFilePath);

            ANTLRInputStream input = new ANTLRFileStream(tcFile.toString());

            // Create lexer
            lexer = new TinyLexer(input);
            tokens = new CommonTokenStream(lexer);

            lexer.reset();  // Reset lexer before reading tokens

            // Create parser
            parser = new TinyParser(tokens);

            // Parse input and get the parse tree
            tree = parser.program();

//            Trees.inspect(tree, parser);
            if(outputToken){
                generateTokenFile(file, lexer);
                generateParserFile(file, tree.toStringTree(parser));
            }
            if(parser.getNumberOfSyntaxErrors() > 0)
                throw new RuntimeException("INVALID SYNTAX");
//            return parser.getNumberOfSyntaxErrors() == 0;
//            return false;


        }catch (IOException e){
            System.err.println("Error: file is not read");
            throw new RuntimeException("NO FILE TO PARSE");
        }

    }

    public static void ASTCreator(){
        ASTVisitor visitor = new ASTVisitor();
        ASTNode root = visitor.visit(tree);
        ASTPrinter.print(root);
        System.out.println(ASTPrinter.AST.toString());

    }

    public static void semanticChecker(){
        ASTNode root = tree.accept(new ASTVisitor());
        Analyzer analyzer = new Analyzer();
        analyzer.analyze(root);


        for(String error: analyzer.getErrors()){
            System.err.println(error);
        }

        if(!analyzer.getErrors().isEmpty()){
            throw new RuntimeException("SEMANTIC ERRORS DETECTED");
        }


//        return analyzer.getErrors().isEmpty();

    }

    public static void generateTAC(){
        ASTNode root = tree.accept(new ASTVisitor());
        TACGenerator gen = new TACGenerator();
        TACGenerator.CodeObject tac = gen.generate(root);

        for (String line : tac.code) {
            System.out.println(line);
        }
    }

    private static void generateParserFile(File file, String stringTree) throws IOException {
        String parseTreeFilePath = dir + "\\" + "ParseTree\\" + file;

        try{
            File fileToParse = new File(parseTreeFilePath);

            if(!fileToParse.exists())
                fileToParse.createNewFile();

            FileWriter parseVisualizer = new FileWriter(fileToParse);

            parseVisualizer.append(formatTree(stringTree));

            parseVisualizer.close();

        }catch (IOException e){
            System.err.printf("Error: File %s couldn't be created", parseTreeFilePath);
        }
    }

    private static void generateTokenFile(File file, grammar.lexer.TinyLexer lexer)throws IOException {
        String tokenFilePath = dir + "\\" + "Tokens\\" + file;

        try {
            File tokenFile = new File(tokenFilePath);

            if(!tokenFile.exists())
                tokenFile.createNewFile();

            FileWriter tokenVisualizer = new FileWriter(tokenFilePath);

            tokenVisualizer.append("Token Text -> Token Type\n");
            for (Token token : lexer.getAllTokens()) {
                tokenVisualizer.append(token.getText())
                        .append(" -> ")
                        .append(lexer.getVocabulary().getSymbolicName(token.getType()))
                        .append('\n');
            }
            tokenVisualizer.close();
        }
        catch (IOException e){
            System.err.printf("Error: File %s couldn't be created", tokenFilePath);
        }
    }

    private static String formatTree(String tree) {
        StringBuilder formatted = new StringBuilder();
        int indent = 0;
        boolean inWord = false;

        for (char c : tree.toCharArray()) {
            if (c == '(') {
                if (inWord) {
                    formatted.append('\n');
                    formatted.append("  ".repeat(indent));
                }
                formatted.append(c).append('\n');
                indent++;
                formatted.append("  ".repeat(indent));
                inWord = false;
            } else if (c == ')') {
                indent--;
                formatted.append('\n');
                formatted.append("  ".repeat(indent)).append(c);
                inWord = false;
            } else if (c == ' ') {
                if (inWord) {
                    formatted.append(c);
                }
            } else {
                formatted.append(c);
                inWord = true;
            }
        }
        return formatted.toString();
    }
}
