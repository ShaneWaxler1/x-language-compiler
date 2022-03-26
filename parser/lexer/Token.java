package lexer;

/** <pre>
 *  The Token class records the information for a token:
 *  1. The Symbol that describes the characters in the token
 *  2. The starting column in the source file of the token and
 *  3. The ending column in the source file of the token
 *  </pre>
*/
public class Token {
  private int leftPosition,rightPosition, lineno;
  private Symbol symbol;
  private static String columnFormat = (
    "%-11.11s "+
    "left: %-8.8s "+
    "right: %-8.8s "+
    "line: %-8.8s "+
    "%s\n"
  );

  /**
   *  Create a new Token based on the given Symbol
   *  @param leftPosition is the source file column where the Token begins
   *  @param rightPosition is the source file column where the Token ends
   */
  public Token( int leftPosition, int rightPosition, Symbol sym, int lineno ) {
    this.leftPosition = leftPosition;
    this.rightPosition = rightPosition;
    this.symbol = sym;
    this.lineno = lineno;
  }

  public Symbol getSymbol() {
    return symbol;
  }

  public void print() {
    System.out.format(
      columnFormat,
      symbol.toString(),
      leftPosition,
      rightPosition,
      lineno,
      symbol.getKind()
    );
    
    return;
  }

  public String toString() {
    return(
      String.format(columnFormat,
      symbol.toString(),
      leftPosition,
      rightPosition,
      lineno,
      symbol.getKind())
    );
  }

  public int getLeftPosition() {
    return leftPosition;
  }

  public int getRightPosition() {
    return rightPosition;
  }

  public int getLineno() {
    return lineno;
  }

  /**
   *  @return the integer that represents the kind of symbol we have which
   *  is actually the type of token associated with the symbol
   */
  public Tokens getKind() {
    return symbol.getKind();
  }
}

