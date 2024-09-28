package bootcamp.CodeForAll.io;

public class PlayGround {
    public static void main(String[] args) {
        String getserialnumber;

        Phone phone1 = new Phone();
        phone1.brand = ("Nokia");
        phone1.color = ("Blue");
        phone1.nrOfButtons = (15);
        phone1.serialNumber = ("aaabbbsss232");
        Phone phone2 = new Phone();
        phone2.brand = ("Apple");
        phone2.color = ("Black");
        phone2.nrOfButtons = (3);
        phone2.serialNumber = ("lkf3");
        Phone phone3 = new Phone();
        phone3.brand = ("Samsung");
        phone3.color = ("Pink");
        phone3.nrOfButtons = (3);
        phone3.serialNumber = ("lkoe");

        Phone phone4 = new Phone();
        phone4.brand = ("Alcatel");
        phone4.color = ("Brown");
        phone4.nrOfButtons = (1);
        phone4.serialNumber = "";


        System.out.println("O temelovel " + phone1.brand + " da cor " + phone1.color + " tem " + phone1.nrOfButtons + " botões");
        System.out.println("O temelovel " + phone2.brand + " da cor " + phone2.color + " tem " + phone2.nrOfButtons + " botões");
        System.out.println("O temelovel " + phone3.brand + " da cor " + phone3.color + " tem " + phone3.nrOfButtons + " botões");
        System.out.println("O telemovel " + phone4.brand + " tem o serial number " + phone4.serialNumber);
        int result = phone1.Add(5,7);
        phone1.Add (result, 5);

        String NewColor2 = phone2.Color("Blue", "White");
        String NewColor3 = phone3.Color("Pink");
        System.out.println(phone2.brand + " " + NewColor2);
        System.out.println(phone3.brand + " " + NewColor3);


    }

}
