class StringManipulation{
    public static void main (String[] args){
        String str = "http://www.academiadecodigo.org";
        //String novoUrl = str.substring(7); // www.academiadecodigo.org
        String novoURL = str.replace("http://", "");
       // System.out.println(novoURL);

       String firstWord = novoURL.substring(4,12);
       // System.out.println(firstWord);
        String firstWord2 = firstWord.substring(0,1).toUpperCase()+firstWord.substring(1);;
       // System.out.println(firstWord2);

        String secondWord = novoURL.substring(12,14);
       // System.out.println(secondWord);
        String secondWord2 = secondWord.substring(0,1).toUpperCase()+secondWord.substring(1);;
      //  System.out.println(secondWord2);

        String thirdWord = novoURL.substring(14,20);
      //  System.out.println(thirdWord);
        String thirdWord2 = thirdWord.substring(0,1).toUpperCase()+ thirdWord.substring(1);;
       // System.out.println(thirdWord2);

        System.out.print ("I am a Code Cadet at < " + firstWord2 + secondWord2 + thirdWord2 + "_ >, " + novoURL);

    }

}

// print the following message at the end
// I am a Code Cadet at < Academia de Codigo_ >, www.academiadecodigo.org