package io.codeforall.bootcamp.exercise;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ai {

    private String name;
    private String creationDate;

    // Construtor que recebe name e creationDate
    public Ai(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    // Getter para 'name'
    public String getName() {
        return name;
    }

    // Setter para 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter para 'creationDate'
    public String getCreationDate() {
        return creationDate;
    }

    // Setter para 'creationDate'
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    // Método que duplica os valores de um array de inteiros
    public int[] doubleArray(int[] arr) {
        return Arrays.stream(arr).map(elem -> elem * 2).toArray();
    }

    // Método que verifica palíndromos e os substitui por 'palindrome'
    public String palindromeReplace(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String cleanedWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (cleanedWord.equals(new StringBuilder(cleanedWord).reverse().toString())) {
                result.append("palindrome ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }

    // Método iterativo para calcular o fatorial
    public int factorialIterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Método recursivo para calcular o fatorial
    public int factorialRecursive(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    // Método que retorna a expressão regular para validar emails
    public String emailValidator() {
        return "^[\\w#]+@[\\w]+\\.[a-z]{2,}$";
    }
}
