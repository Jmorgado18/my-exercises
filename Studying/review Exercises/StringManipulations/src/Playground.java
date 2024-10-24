public class Playground {
    public static void main(String[] args) {

        String str = "http://www.academiadecodigo.org";

        String domain = str.substring(7,str.length());
        System.out.println(domain);// www.academiadecodigo.org
        String name = "< " + str.substring(11,12).toUpperCase();   // < Academia de Codigo_ >
        System.out.println(name );
// print the following message at the end
// I am a Code Cadet at < Academia de Codigo_ >, www.academiadecodigo.org


    }
}
