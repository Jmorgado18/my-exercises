public class Tests {

    public static String main(String[] args) {
        //Convert a number to a String
        int num = 5;
        String numString = Integer.toString(num);
        System.out.println(numString);

        //Duplicate Encoder
        String str = "Success";
        String encoded = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (c == str.charAt(j)) {
                    count++;
                }
            }
            if (count > 1) {
                encoded += ")";
            } else {
                encoded += "(";
            }
        }
        System.out.println(encoded);


        //find the odd int
        int[] arr = {20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5};
        int odd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                odd = arr[i];
            }
        }
        System.out.println(odd);

        //find all the odd numbers in an array
        int[] arr2 = {20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5};

        for (int i = 0; i < arr2.length; i++) {

            if (arr2[i] % 2 != 0) {
                System.out.println(arr2[i]);
            }

        }

        //Detect Pangram
        String pangram = "The quick brown fox jumps over the lazy dog";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alphabet.length(); i++) {
            if (!pangram.toLowerCase().contains(alphabet.charAt(i) + "")) {
                System.out.println(alphabet.charAt(i));
            }
        }




        int seconds = 199384309;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        System.out.println(hours + " hours, " + minutes + " minutes, " + seconds + " seconds");


    }
}

