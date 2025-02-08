public class CoreJavaBrushUp1 {
    public static void main(String[] args) {
        int myNum = 5;
        String website = "Rahul Shetty Academy";
        char letter = 'r';
        double dec = 5.99;
        boolean bool = true;

        System.out.println(myNum + " is the value stored in the myNum variable");
        System.out.println(website);

        //Arrays
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(arr2[2]);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr2[i]);
        }

        String[] name = {"rahul", "shetty", "academy"};
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }

        for(String s: name){
            System.out.println(s);
        }
    }
}
