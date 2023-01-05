package facade;

import codeGenerator.CodeGenerator;
import scanner.token.Token;
import Log.Log;

public class CodeGeneratorFacade {
    private static CodeGeneratorFacade codeGeneratorFacade = null;
    private final CodeGenerator codeGenerator = new CodeGenerator();

    private CodeGeneratorFacade() {

    }

    public static CodeGeneratorFacade getCodeGeneratorFacade() {
        return (codeGeneratorFacade == null) ? codeGeneratorFacade = new CodeGeneratorFacade() : codeGeneratorFacade;
    }

    public void printMemory(){
        codeGenerator.printMemory();
    }

    public void createSemantic(int semanticAction, Token lookAhead){
        try {
            codeGenerator.semanticFunction(semanticAction, lookAhead);
        }catch (Exception e){
            Log.print("Code Generator Error");
        }
    }

}
