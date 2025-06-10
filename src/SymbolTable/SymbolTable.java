package SymbolTable;

import java.util.*;

public class SymbolTable {
    private Deque<Map<String, Symbol>> variableScopes;  // for variables only
    private Map<String, List<FunctionSymbol>> functions; // global function registry

    public SymbolTable() {
        variableScopes = new ArrayDeque<>();
        functions = new HashMap<>();
        enterScope();  // start with global scope
    }

    public void enterScope() {
        variableScopes.push(new HashMap<>());
    }

    public void exitScope() {
        variableScopes.pop(); // removes only local variable scope
    }

    // Declare a variable
    public boolean declareVariable(String name, Symbol symbol) {
        Map<String, Symbol> current = variableScopes.peek();
        if (current.containsKey(name)) return false; // already declared in this scope
        current.put(name, symbol);
        return true;
    }

    // Declare a function
    public boolean declareFunction(String name, FunctionSymbol symbol) {
        functions.putIfAbsent(name, new ArrayList<>());
        for (FunctionSymbol existing : functions.get(name)) {
            if (existing.getParamTypes().equals(symbol.getParamTypes())) {
                return false; // duplicate signature
            }
        }
        functions.get(name).add(symbol);
        return true;
    }

    // Resolve a variable
    public Symbol resolveVariable(String name) {
        for (Map<String, Symbol> scope : variableScopes) {
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        return null; // not found
    }

    // Resolve a function by name and param types
    public FunctionSymbol resolveFunction(String name, List<String> paramTypes) {
        if (!functions.containsKey(name)) return null;
        for (FunctionSymbol f : functions.get(name)) {
            if (f.getParamTypes().equals(paramTypes)) return f;
        }
        return null;
    }

    // Resolve all overloaded functions by name
    public List<FunctionSymbol> resolveFunctionsByName(String name) {
        return functions.getOrDefault(name, Collections.emptyList());
    }
}
