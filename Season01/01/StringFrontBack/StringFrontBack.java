class StringFrontBack{
    public static void main(String[] args){
        String word ="CodeForAll";
        String firstLetter = word.substring(0,1);
       // System.out.println (firstLetter);
        String lastLetter = word.substring((word.length())-1);
        //System.out.println(lastLetter);
        String newWord= word.substring(1,word.length()-1);
        System.out.println(lastLetter + newWord + firstLetter);
    }

}

//lodeForAlC