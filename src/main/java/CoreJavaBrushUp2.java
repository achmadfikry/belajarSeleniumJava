public class CoreJavaBrushUp2 {
    public static void main(String[] args) {
        double[] arr2 = {1,2,3.5,4,5,6,7,8,9,10,122};
        double result = 0;
        //2,4,6,8,10,12,14,16,18,20,244
        //check if array has multiple of 2
        for (int i = 0; i < arr2.length; i++){
            if(arr2[i]%2 == 0){
                System.out.println(arr2[i]);
//                break;
            }else{
                System.out.println(arr2[i] + " is not multiple of 2");
            }
            result = arr2[i] + result;

        }
        System.out.println(result);
    }
}
