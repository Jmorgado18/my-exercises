package io.CodeForAll.fanstatics;

public class Machine {
   public<T> T applyMonoOperation(MonoOperation<T> operation, T operand){
    return operation.execute(operand);
    }

    public<T> T applyBiOperation(BiOperation<T> operation, T operand1, T operand2){
    return operation.execute(operand1, operand2);
    }
}
