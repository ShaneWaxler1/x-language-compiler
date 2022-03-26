package visitor;

import java.util.Hashtable;

import ast.AST;

public class OffsetVisitor extends ASTVisitor{
    private Hashtable<AST, int[]> nodeInfoTable = new Hashtable<>();
    private int[] nextOffset = new int[100];
    private int depth = -1;
    private int offset;
    private int maxDepth = 0;
    private int maxOffset = 0;
    private int[] nodeInfo;

    private void update(AST t){
        depth++;
        visitKids(t);
        if(t.kidCount()==0){
            nodeInfo = new int[]{nextOffset[depth], depth};
            nodeInfoTable.put(t, nodeInfo);
            nextOffset[depth] += 2;
        }else{
            offset = calculateOffset(t);
            if(offset < nextOffset[depth]){
                updateNextAvailable(t);

                offset = nextOffset[depth];
            }
            nodeInfo = new int[]{offset, depth};
            nodeInfoTable.put(t, nodeInfo);
            nextOffset[depth] = 2 + offset;
        }

        if(depth > maxDepth){
            maxDepth = depth;
        }
        // if(nextOffset[depth] - 2 > maxOffset){
        //     maxOffset = nextOffset[depth] - 2;
        // }
        depth--;
    }

    public void updateNextAvailable(AST t){
        if(t.kidCount() == 0){
            return;
        }

        for(AST c: t.getKids()){
            updateNextAvailable(c);
            nodeInfoTable.get(c)[0] += (nextOffset[depth] - offset);
            nextOffset[nodeInfoTable.get(c)[1]] = nodeInfoTable.get(c)[0] + 2;
        }
    }

    public int getMaxOffset(){
        nodeInfoTable.forEach((k,v) ->{
          if(v[0] > maxOffset){
            maxOffset = v[0];
          }
        });
        return maxOffset;
    }

    public int getMaxDepth(){
        return maxDepth;
    }

    public Hashtable<AST, int[]> getNodeInfoTable() {
        return nodeInfoTable;
    }

    public void printCount() {
        nodeInfoTable.forEach((k,v) ->{
            System.out.println(k.getLabel() + "\nDepth: " + v[1] + " Offset: " + v[0] + "\n");
        });
      }

    private int calculateOffset(AST t){
        int rOffset = nodeInfoTable.get(t.getKid(t.kidCount()))[0];
        int lOffset = nodeInfoTable.get(t.getKid(1))[0];
        return (lOffset + rOffset)/2;
    }

    public Object visitProgramTree(AST t) {
        t.setLabel("Program");
        update(t);
return null;
      }
    
      public Object visitBlockTree(AST t) {
        t.setLabel("Block");
        update(t);
return null;
      }
    
      public Object visitFunctionDeclTree(AST t) {
        t.setLabel("FunctionDecl");
        update(t);
return null;
      }
    
      public Object visitCallTree(AST t) {
        t.setLabel("Call");
        update(t);
return null;
      }
    
      public Object visitDeclTree(AST t) {
        t.setLabel("Decl");
        update(t);
return null;
      }
    
      public Object visitIntTypeTree(AST t) {
        t.setLabel("IntType");
        update(t);
return null;
      }
    
      public Object visitBoolTypeTree(AST t) {
        t.setLabel("BoolType");
        update(t);
return null;
      }
    
      public Object visitFloatTypeTree(AST t) {
        t.setLabel("FloatType");
        update(t);
return null;
      }
    
      public Object visitVoidTypeTree(AST t) {
        t.setLabel("VoidType");
        update(t);
return null;
      }
    
      public Object visitFormalsTree(AST t) {
        t.setLabel("Formals");
        update(t);
return null;
      }
    
      public Object visitActualArgsTree(AST t) {
        t.setLabel("ActualArgs");
        update(t);
return null;
      }
    
      public Object visitIfTree(AST t) {
        t.setLabel("If");
        update(t);
return null;
      }
    
      public Object visitUnlessTree(AST t) {
        t.setLabel("Unless");
        update(t);
return null;
      }
    
      public Object visitWhileTree(AST t) {
        t.setLabel("While");
        update(t);
return null;
      }
    
      public Object visitForTree(AST t) {
        t.setLabel("For");
        update(t);
return null;
      }
    
      public Object visitReturnTree(AST t) {
        t.setLabel("Return");
        update(t);
return null;
      }
    
      public Object visitAssignTree(AST t) {
        t.setLabel("Assign");
        update(t);
return null;
      }
    
      public Object visitIntTree(AST t) {
        t.setLabel("Int: ");
        update(t);
return null;
      }
    
      public Object visitIdTree(AST t) {
        t.setLabel("Id: ");
        update(t);
return null;
      }
    
      public Object visitRelOpTree(AST t) {
        t.setLabel("RelOp: " );
        update(t);
return null;
      }
    
      public Object visitAddOpTree(AST t) {
        t.setLabel("AddOp: ");
        update(t);
return null;
      }
    
      public Object visitMultOpTree(AST t) {
        t.setLabel("MultOp: " );
        update(t);
return null;
      }
    
      public Object visitStringTypeTree(AST t) {
        t.setLabel("StringType");
        update(t);
return null;
      }
    
      public Object visitCharTypeTree(AST t) {
        t.setLabel("CharType");
        update(t);
return null;
      }
    
      public Object visitSwitchTree(AST t) {
        t.setLabel("Switch");
        update(t);
return null;
      }
    
      public Object visitSwitchBlockTree(AST t) {
        t.setLabel("SwitchBlock");
        update(t);
return null;
      }
    
      public Object visitCaseTree(AST t) {
        t.setLabel("Case");
        update(t);
return null;
      }
    
      public Object visitDefaultTree(AST t) {
        t.setLabel("Default");
        update(t);
return null;
      }
    
      public Object visitScientificTree(AST t) {
        t.setLabel("Scientific");
        update(t);
return null;
      }
    
      public Object visitCharTree(AST t) {
        t.setLabel("Char");
        update(t);
return null;
      }
    
      public Object visitScientificTypeTree(AST t){
        t.setLabel("ScientificType");
        update(t);
return null;
      }
}
