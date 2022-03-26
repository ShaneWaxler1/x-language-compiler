package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class ScientificTree extends AST {
    private Symbol symbol;

    public ScientificTree(Token tok){
        this.symbol = tok.getSymbol();
    }

    public Object accept(ASTVisitor v){
        return v.visitScientificTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
