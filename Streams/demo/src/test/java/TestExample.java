import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExample {
    @Test
    public void test1() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Sam");
        names.add("Anit");
        names.add("Ram");
        names.add("Arun");
        names.add("Akhil");
        int count = 0;
        for (String name : names) {
            if (name.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Sam");
        names.add("Anita");
        names.add("Ram");
        names.add("Aruna");
        names.add("Akhil");
        // There is no life for intermediate operation if there is no terminal operation
        // Terminal operation will execute correctly only if intermediate operation(filter) returns true
        long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);
        // We can create Stream and use filter in stream API
        long d = Stream.of("Samiksha", "Arin", "Arun", "Nita", "Anuj", "Ram").filter(s -> {
            return s.startsWith("A");
        }).count();
        System.out.println(d);

        // Printing names with length > 4
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
        // Limiting names
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Sam");
        names.add("Pat");
        names.add("Ginny");
        // Print names ending with "n"
        Stream.of("Arin", "Adam", "Mohan","Mike", "Dustin", "Aruna").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
        
        // Sorting names 
        Stream.of("Arin", "Adam", "Mohan", "Mike", "Dustin", "Aruna").filter(s->s.endsWith("n")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

         // Merge the two lists into a single Stream
        System.out.println("Merging lists:");
        List<String> names1 = Arrays.asList("Tom", "Neel", "Jack");
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        // newStream.sorted().forEach(s->System.out.println(s)); // stream consumed
        // once a stream is consumed or modified, it cannot be reused.
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("jack"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect() {
        // Create a stream of names, filter those ending with 'n', convert to uppercase, collect the results in a list and print them
        List<String> ls = Stream.of("Arin", "Adam", "Mohan", "Mike", "Dustin", "Aruna").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(2, 7, 7, 11, 9, 11);
        // Print unique number from the array
        //Sort the array
        List<Integer> i = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(i);
        System.out.println(i.get(3));
    }
}