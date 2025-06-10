package SymbolTable;

public class Symbol {
    private final String name;
    private final String type;
    private final SymbolKind kind; // VAR, FUNC, PARAM

    public Symbol(String name, String type, SymbolKind kind) {
        this.name = name;
        this.type = type;
        this.kind = kind;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public SymbolKind getKind() { return kind; }
}