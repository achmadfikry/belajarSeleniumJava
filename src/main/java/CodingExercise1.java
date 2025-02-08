public class CodingExercise1 {
     public static void main(String[] args){
         //1
         double[] numbers = {1,2,3,4,5};
         double result = 0;

          //2
         for (int i = 0; i < numbers.length; i++){
             if (i == 0){
                 System.out.println(numbers[i]);
             }
             if (i == numbers.length - 1){
                 System.out.println(numbers[i]);
             }
             result = numbers[i] + result;
         }

         //3
         for (int j = numbers.length - 1; j >= 0; j--){
             System.out.println(numbers[j]);
         }

         //4
         System.out.println(numbers.length);
     }

}
