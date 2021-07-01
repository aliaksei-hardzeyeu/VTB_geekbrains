package lecture8StreamAPI_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> out = integers.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).collect(Collectors.toList());

        List<Integer> out2 = integers.stream().filter((n) -> {
            return n % 2 == 0;
        }).collect(Collectors.toList());

        integers.stream().filter((n)-> n % 2 == 1).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println(out);
        System.out.println(out2);
    }
}
