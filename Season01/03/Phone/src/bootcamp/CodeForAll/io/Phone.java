package bootcamp.CodeForAll.io;

public class Phone {
    public String color;
    public String brand;
    public String serialNumber;
    public int nrOfButtons;

    public Phone(String serialNumber){

        if (serialNumber == null || serialNumber.isEmpty()) {
            this.serialNumber = "SN INVÁLIDO"; // Define como SN INVÁLIDO
        } else {
            this.serialNumber = serialNumber; // Define o número de série válido
        }

    }
    public Phone(){
        this.serialNumber = "SN INVÁLIDO"; // Inicializa como SN INVÁLIDO
    };

    public int Add(int n1,int n2) {
        int add2 = n1+n2;
        System.out.println(n1+n2);
        return add2;
    }

    public String Color ( String c1, String c2){

        this.color = (c1 + " and " + c2);
        return color;
    }

public String Color (String c1){

    this.color = c1;
    return color;
}

    }



