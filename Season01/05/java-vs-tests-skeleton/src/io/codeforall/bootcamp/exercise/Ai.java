package io.codeforall.bootcamp.exercise;

public class Ai {
    private String name;
    private String creationDate;

    // Construtor
    public Ai(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    // Getter para o nome
    public String getName() {
        return name;
    }

    // Setter para o nome
    public void setName(String name) {
        this.name = name;
    }

    // Getter para a data de criação
    public String getCreationDate() {
        return creationDate;
    }

    // Setter para a data de criação
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    // Método para duplicar os valores de um array de inteiros
    public int[] doubleArray(int[] arr) {
        int[] doubledArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            doubledArray[i] = arr[i] * 2;
        }
        return doubledArray;
    }

    // Método para substituir palíndromos numa string por "palindrome"
    public String palindromeReplace(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (isPalindrome(word)) {
                result.append("palindrome ");
            } else {
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }

    // Método auxiliar para verificar se uma palavra é um palíndromo
    private boolean isPalindrome(String word) {
        String cleanWord = word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        String reversedWord = new StringBuilder(cleanWord).reverse().toString();
        return cleanWord.equals(reversedWord);
    }

    // Método para calcular o fatorial de forma iterativa
    public int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Método para calcular o fatorial de forma recursiva
    public int factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }


    // Método para retornar uma expressão regular para validar emails
    public String emailValidator() {
        // Expressão regular mais rigorosa para validar emails
        return "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    }


}

