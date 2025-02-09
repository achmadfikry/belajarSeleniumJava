public class MethodsDemo {
    public static void main(String[] args) {
        MethodsDemo d = new MethodsDemo(); //harus diinitiate agar MethodsDemo bisa mengontrol method yang ada di MethodsDemo()
        d.getData();
        System.out.println("------------------");

        String name = d.getDataString();
        System.out.println(name);

        System.out.println("------------------");
        MethodsDemo2 d1 = new MethodsDemo2();
        d1.getUserData();

        System.out.println("------------------");
        String d2 = getDataStatic();

        System.out.println("------------------");
        getDataStatic();
    }

    public void getData(){
        System.out.println("Hello World");
    }
    public String getDataString(){
        System.out.println("Hello World");
        return "Rahul Shetty";
    }

    //saat memakai static maka method ini jadi milik kelas bukan sebagai objek, jadi ini bisa dipanggil tanpa membuat objek
    public static String getDataStatic(){
        System.out.println("Hello World");
        return "Rahul Shetty";

    }
}
