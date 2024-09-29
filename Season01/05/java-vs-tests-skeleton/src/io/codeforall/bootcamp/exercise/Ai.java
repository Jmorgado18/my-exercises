package io.codeforall.bootcamp.exercise;

public class Ai {
    private String name;
    private String creationDate;


        //Construtor recebe name e creationDate
    public Ai(String name, String creationDate){
        this.creationDate=creationDate;
        this.name=name;
    }
    //Getter para o nome
    public String getName(){
        return this.name;
    }
    //Setter para o nome
    public void setName(String name){
        this.name=name;
    }
    //Getter
    public String getCreationDate(){
        return this.creationDate;
    }
    //Setter
    public void setCreationDate(String creationDate){
        this.creationDate=creationDate;
    }
    //Duplicar array
    public int[] doubleArray(int[] array){
        int[] newArray = new int[array.length];

        for(int i=0 ; i<array.length ; i++){
            newArray[i] = array[i]*2;
        }
        return newArray;
    }

    //Factorial Recursivo
    public int factorialRecursive(int number){
        if (number==0 || number ==1){
            return 1;
        }
        return number * factorialRecursive((number -1));
    }

    //Factorial Iterativo
    public int factorialIterative(int number) {
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;

    }

    // Palindrome
    public String palindromeReplace(String inputword) {

        boolean isPalindrome = true;
        for (int i = 0; i < inputword.length() / 2; i++) {

            if (inputword.charAt(i) != inputword.charAt(inputword.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            return "palindrome";
        } else {
            return inputword;
        }

    }

    public String emailValidator(){
    return "^(.+)@(.+)$";

    }







}

