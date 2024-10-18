class StringFrontBack {
public static void main (String [] args) {

String word ="CodeForAll";

int tamanho =(word.length - 1) ;
String cutstring = word.substring(1);
String cutstring2 = word.substring(0,tamanho);
String NewString = cutstring + cutstring2;
char firstchar;
char  lastchar;

firstchar.equals(word.charAt(0));
lastchar.equals(word.charAt(tamanho));
NewString.equals((lastchar + (NewString) + firstchar));
System.out.println(NewString);


}


}
