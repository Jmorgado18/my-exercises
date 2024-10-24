public class Fighter {
    private String name;
    private String nationality;
    private int age;
    private double height;
    private double weight;
    private int nrwin;
    private int nrloses;
    private int nrdraws;
    private String category;

    public Fighter(String name, String nationality, int age, double height, double weight, int nrwin, int nrloses, int nrdraws) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.nrwin = nrwin;
        this.nrloses = nrloses;
        this.nrdraws = nrdraws;
        setCategory(height); // Define a categoria ao inicializar
    }

    public void setCategory(double height) {
        if (height < 1.65) {
            this.category = "LIGHTWEIGHT";
        } else if (height < 1.85) {
            this.category = "MEDIUMWEIGHT";
        } else {
            this.category = "HEAVYWEIGHT";
        }
    }

    public String getCategory() {
        return category;
    }

    public void displayInfo() {
        System.out.println("Fighter: " + name);
        System.out.println("Nationality: " + nationality);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Wins: " + nrwin);
        System.out.println("Losses: " + nrloses);
        System.out.println("Draws: " + nrdraws);
        System.out.println("Category: " + category);
        System.out.println();
    }

    public void winFight(){
        this.setNrwin(this.getNrwin()+1);
    }
    public void LoseFight(){
        this.setNrloses(this.getNrloses()+1);

    }

    public void DrawFight(){
        this.setNrdraws(this.getNrdraws()+1);
    }

    public int getNrwin() {
        return nrwin;
    }

    public void setNrwin(int nrwin) {
        this.nrwin = nrwin;
    }

    public int getNrloses() {
        return nrloses;
    }

    public void setNrloses(int nrloses) {
        this.nrloses = nrloses;
    }

    public int getNrdraws() {
        return nrdraws;
    }

    public void setNrdraws(int nrdraws) {
        this.nrdraws = nrdraws;
    }

    public String getName() {
        return name;
    }

    protected String getNationality() {
        return nationality;
    }

    protected int getAge() {
        return age;
    }

    protected double getHeight() {
        return height;
    }

    protected double getWeight() {
        return weight;
    }
}
