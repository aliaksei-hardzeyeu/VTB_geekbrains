package lecture8StreamAPI_Lambda;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapExample {
    public static void main(String[] args) {
        Stream.of("AA", "BBB", "C", "DDDD").map(new Function<String, Integer>() {

            public Integer apply (String s){
                return s.length();
            }
        }).forEach(System.out::println);

        Stream.of(1,2,3,4).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 10;
            }
        }).forEach(System.out::println);

        Stream.of("AAAA", "VVV", "QQQQQQQ").map(String::length).collect(Collectors.toList());
        Stream.of("AAAA", "VVV", "QQQQQQQ").map(s1 -> s1.length()).collect(Collectors.toList());


        class User {
            String name;

            public User(String name) {
                this.name = name;
            }
        }
        Stream.of("Bob", "Max", "John").map(User::new).collect(Collectors.toList());
        Stream.of("Bob", "Max", "John").map(s -> new User(s)).collect(Collectors.toList());
    }
}
