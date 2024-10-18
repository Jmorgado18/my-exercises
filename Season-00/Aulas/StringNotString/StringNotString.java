class StringNotString {
public static void main (String[] args){

String word ="notCodeForAll";
String newWord;
String newSubString;
newSubString = word.substring (0,3);
if ( newSubString.equals("not")){

	System.out.println(word);
	
}else{

	System.out.println("not" + word);

}
}



}

