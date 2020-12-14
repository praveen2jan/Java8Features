package Java8Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Unit1Exercise {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("a","b",23),
                new Person("b","c",24),
                new Person("c","a",42)
        );
        //Sort list by lastname
//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getLastname().compareTo(o2.getLastname());
//            }
//        });

        Collections.sort(people,(p1,p2)-> p1.getLastname().compareTo(p2.getLastname()));

        //create method to prnt all elements in the list
        printAll(people);
        //print with first name starting with "c"
        printStartWithC(people, p-> p.getLastname().startsWith("b"));
    }

    private static void printStartWithC(List<Person> people, Predicate<Person> condition) {
        System.out.println("Print Starts With C");
        /*for(Person p : people){
            if(condition.test(p))
                System.out.println(p);
        }*/
        people.stream().filter(condition).forEach(p->System.out.println(p));
    }

    private static void printAll(List<Person> people) {
        System.out.println("Print All");
        /*for(Person person : people){
            System.out.println(person);
        }*/
        people.stream().forEach(p->System.out.println(p));
    }
}

interface Condition{
    boolean test(Person person);
}