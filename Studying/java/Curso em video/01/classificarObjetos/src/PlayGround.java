import javax.xml.transform.Source;

public class PlayGround {

    public static void main(String[] args) {
        //Classificar dois objetos com propriedades e métodos
            //Manipular as propriedades com os métodos e dar sout na main
        //Classificar dois objetos abstratos
            //Manipular as propriedades com os metodos e dar sout na main


        TV tv1 = new TV();
        Dog dog1=new Dog();
        Estudar estudar  = new Estudar();
        Bennedita Benny = new Bennedita();


        System.out.println("TV1 brand is " + tv1.setBrand("Samsung"));
        System.out.println("----------------------------------");
        System.out.println(dog1.getName() + " é o nome do dog1");
        System.out.println("----------------------------------");
        Benny.setSheSleeping(true);
        Benny.sleep();

        if (Benny.isSheSleeping()){
            System.out.println("She cant be fed, she's sleeping!");
        }else{
            Benny.fed();
            System.out.println("Feeding Baby");
        }
        System.out.println("----------------------------------");
        TV tv2= new TV();
        String marca = tv2.setBrand("NOKIA");
       int channel = tv2.setChannel(4);
       boolean isOn= tv2.setOn(true);
       int size= tv2.setSize(55);

        System.out.println("TV2 is on?" + isOn +". brand = " + marca + ". channel: " + channel + ". Size: " +size);
        System.out.println("----------------------------------");
        Pen pen1= new Pen();
        pen1.setCor("Azul");
        pen1.setModelo("Bic");
        pen1.showStatus();
        pen1.destampar();
        pen1.showDraw();
        System.out.println("----------------------------------");

        Estante estante= new Estante();
        estante.setNrDocs(1);
        estante.showStatus();
        estante.setNrDocs(estante.getNrDocs() + 5);
        estante.showStatus();
        System.out.println("----------------------------------");

        Agua agua=new Agua("Luso");
        agua.beber();
        System.out.println("Agua 1 " + agua.getQtd() + agua.getBrand());
        agua.encher();
        agua.beber();
        System.out.println("Agua 1 " + agua.getQtd());

        Agua agua2 = new Agua("Vitalis");
        System.out.println("Agua 2 " + agua2.getQtd());
        System.out.println("----------------------------------");

        Caneta caneta1 = new Caneta("Bic", 100);
        System.out.println("Caneta 1 da marca " + caneta1.brand + " tem " + caneta1.Carga + " tinta");

    }





}
