import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class test1 {
    //count number of names starting with alphabet A in list
//    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");
        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");
        int count = 0;

        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);

        //create stream
        Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s->s.startsWith("A")).count();
        // count will be executed if filter retur true, so
        //there is no life for intermediate op if there is no termional op
        //terminal op will execute only if intermediate op (filter) return true
    }
}
