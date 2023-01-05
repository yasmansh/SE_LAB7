package facade;

import codeGenerator.CodeGenerator;
import codeGenerator.Memory;


public class MemoryFacade {
    private static MemoryFacade memoryFacade = null;
    private Memory memory = new Memory();

    private MemoryFacade() {

    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Memory getMemory() {
        return memory;
    }

    public static MemoryFacade getMemoryFacade() {
        return (memoryFacade == null) ? memoryFacade = new MemoryFacade() : memoryFacade;
    }

}
