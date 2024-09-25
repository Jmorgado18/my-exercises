public class ClosestNeighbours {
    public static void main(String[] args) {
        int[] numbers = {0, 5, 1209, 6, 2, 111, 112, 33};
        int dif = Math.abs(numbers[0]-numbers[1]);
        int calc;
        //System.out.println(dif);

    for (int i=0; i<numbers.length - 1; i++){
        calc = Math.abs(numbers[i]-numbers[i+1]);
        if (calc < dif){
            dif = calc;
        }
    }
    System.out.println("A menor diferença entre numeros vizinhos presentes no array é " + dif);
}
}
