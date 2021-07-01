package lecture8StreamAPI_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample2 {
    public static void main(String[] args) {
       // secondEx();
       // thirdEx();
       //matchEx();
        findAnyEx();

    }

    private static void secondEx() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> out = numbers.stream()                        //преобразуем список в поток данных
                .filter(n -> n % 2 == 0)                            //фильтруем, оставляем только четные числа
                .map((Function<Integer, Integer>) n -> n * n)       //преобразуем каждый элемент потока int->int, умножая на самого себя
                .limit(2)                                           //оставляем в потоке только 2 первых элемента
                .collect(Collectors.toList());                      //собираем элементы потока в лист
        System.out.println(numbers);
        System.out.println(out);
    }
    private static void thirdEx() {
        //получаем поток данных из набора целых чиселб находим среди них только уникальные,
        //и каждое найденное значение выводим в консоль
        System.out.println("Первый вариант: ");
        Arrays.asList(1,2,3,4,4,3,2,3,2,1).stream().distinct().forEach(n -> System.out.println(n));
        //более короткая запись
        System.out.println("Второй вариант: ");
        Arrays.asList(1,2,3,4,4,3,2,3,2,1).stream().distinct().forEach(System.out::println);
    }

    private static void matchEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list.stream().allMatch(n -> n < 10));
        System.out.println(list.stream().anyMatch(n -> n == 4));
        System.out.println(list.stream().noneMatch(n -> n < 2));
    }

    private static void findAnyEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        list.stream().filter(n -> n > 10).findAny().ifPresent(System.out::println);
        Optional<Integer> opt = list.stream().filter(n -> n > 10).findAny();

        if(opt.isPresent()) {
            System.out.println(opt.get());
        }
    }
}

/**
 * 1,24,30
 */
