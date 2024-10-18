class MissingChar{
public static void main (String[] args) {

	String word = "CodeForAll";
	int chara = 4;
	
	String nword = word.substring (0, chara);
	String cword = word.substring(chara+1);
	System.out.println(nword + cword) ;
}
}

