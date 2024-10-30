package io.CodeForAll.fanstatics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine();

        MonoOperation<Integer> doubleOperation = operand -> operand*2;
        BiOperation<Integer> sumOperation = ((operand1, operand2) -> operand1+operand2);



        int doubleResult = machine.applyMonoOperation(doubleOperation,5);
        int sumResult = machine.applyBiOperation(sumOperation,5,10);

        System.out.println("Double Result : " + doubleResult);
        System.out.println("Sum Result : " + sumResult);
    }
}
