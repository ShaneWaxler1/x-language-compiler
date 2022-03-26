package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ByteCodeLoader {
  private BufferedReader source;

  public ByteCodeLoader(String byteCodeFile) throws IOException{
    source = new BufferedReader(new FileReader(byteCodeFile));
  }

  public Program loadCodes() throws IOException{
    Program program = new Program();
    String next = source.readLine();
    String[] tokens;
    
    while(next!=null && next!="\n"){
      tokens = next.split(" ");
      program.addCode(tokens);
      next = source.readLine();
    }
    
    return program;
  }
}