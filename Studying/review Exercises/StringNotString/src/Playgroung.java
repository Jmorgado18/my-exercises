public class Playgroung {
    public static void main(String[] args) {
        String word = "notsemicolon";

        String Nword = word.substring(0,3);
      //  System.out.println(Nword);

        if (Nword.equals("not")){
            System.out.println(word);
        }else{
            System.out.println("not"+word);
        }

    }
}
