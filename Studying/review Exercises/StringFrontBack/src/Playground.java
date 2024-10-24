import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class Playground {
    public static void main(String[] args) {
        String word ="CodeForAll";
        String wordWithoutFirstLetter = word.substring(1);
        String lastLetter = word.substring(word.length()-1);
        String wordWithoutLastLetter = wordWithoutFirstLetter.substring(0,word.length()-1);
        String firstLetter = word.substring(0,1);
        System.out.println(wordWithoutFirstLetter);
        System.out.println(lastLetter);
        System.out.println(wordWithoutLastLetter);
        System.out.println(firstLetter);

        System.out.println(lastLetter+wordWithoutLastLetter+firstLetter)x;
    }
}
