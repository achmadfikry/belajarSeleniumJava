import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

//    @Test
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
        //Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s->s.startsWith("A")).count();
        // count will be executed if filter retur true, so
        //there is no life for intermediate op if there is no termional op
        //terminal op will execute only if intermediate op (filter) return true


        //if it is more than one action, thank we can write like this
        long d = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s->{
            s.startsWith("A");
            return false; //because the return is false, then count will not be executed
        }).count();
        System.out.println(d);


        //print all the names of array list which has length more than 4 words
        names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
    }

    @Test
    public void streamMap(){

        ArrayList<String> names = new ArrayList<String>();
        names.add("man");
        names.add("Don");
        names.add("woman");

        //print names which has last letter as "a" with uppercase
        // "Abhijeet", "Don", "Alekhya", "Adam", "Rama" is array
//        Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

        //print names which start letter as "a" with uppercase and sorted
        //convert array to array list
        List<String> names1 = Arrays.asList("Azbhijeet", "Don", "Alekhya", "Adam", "Rama");
//        names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

        //merge two array list
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
//        newStream.sorted().forEach(s->System.out.println(s));

        //match: check wether Adam is in the list or not, if present return true, if it is not return false
         boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);

    }
}
