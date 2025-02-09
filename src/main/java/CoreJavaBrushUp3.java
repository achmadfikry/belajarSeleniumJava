public class CoreJavaBrushUp3 {

    public static void main(String[] args) {
        // string is an object

        //string literal
        //jika value nya sama, mau berapapun variable nya hanya akan 1 objek yang dibuat
        String s = "Rahul Shetty Acadmey";
        String s1 = "Rahul Shetty Acadmey";

        //new string
        String s2 = new String("Welcome");

        String[] splittedString = s.split(" ");
        System.out.println(splittedString[0]);
        System.out.println(splittedString[1]);
        System.out.println(splittedString[2]);
        System.out.println("------------------");

        String[] splittedString2 = s.split("Shetty");
        System.out.println(splittedString2[0]);
        System.out.println(splittedString2[1]);
        System.out.println(splittedString2[1].trim());
        System.out.println("------------------");
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
        System.out.println("------------------");
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.println(s.charAt(i));
        }
    }
}
