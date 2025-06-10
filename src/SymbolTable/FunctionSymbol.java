package SymbolTable;
import java.util.List;
import java.util.Objects;

public class FunctionSymbol extends Symbol {
    private final List<String> paramTypes;

    public FunctionSymbol(String name, String returnType, List<String> paramTypes) {
        super(name, returnType, SymbolKind.FUNCTION);
        this.paramTypes = paramTypes;
    }

    public List<String> getParamTypes() {
        return paramTypes;
    }

    // Optional: override equals & hashCode if needed for comparisons
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FunctionSymbol other)) return false;
        return getName().equals(other.getName()) && paramTypes.equals(other.paramTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), paramTypes);
    }

    @Override
    public String toString() {
        return "FunctionSymbol(" + getName() + ", " + getParamTypes() + " -> " + getType() + ")";
    }
}
