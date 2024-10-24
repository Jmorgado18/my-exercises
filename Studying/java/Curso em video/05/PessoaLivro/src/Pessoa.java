public class Pessoa {
    private String name;
    private int age;
    private Sexo sexo;

    public Pessoa(String name, int age, Sexo sexo) {
        this.name = name;
        this.age = age;
        this.sexo= sexo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void birthday(){

         this.age++;
        System.out.println(this.name + " fez anos, tem agora " + this.age);
    }
    public boolean status(){
        System.out.println("Nome: " + this.getName());
        System.out.println("Age: " + this.getAge() );
        System.out.println("Sexo: " + this.sexo);
        System.out.println("________------------________");
        return true;
    }
    @Override
    public String toString() {
        return "Nome: " + name + ", Idade: " + age + ", Sexo: " + sexo;
    }

}
