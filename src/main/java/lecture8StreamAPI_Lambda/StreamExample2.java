package lecture8StreamAPI_Lambda;

import com.sun.jdi.request.StepRequest;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample2 {
    public static void main(String[] args) {
       // secondEx();
       // thirdEx();
       //matchEx();
//        findAnyEx();
//        mappingEx();
//        reduceEx();
//        intStreamEx();
//        streamCreation();
//        streamFromFile();
//        simpleStringEx();
        uniqueWords();
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

    private static void mappingEx() {
        Function<String, Integer> _strToLen = String::length;
        Function<String, Integer> strToLen = s-> s.length();
        Predicate<Integer> evenNumberFilter = n -> n % 5 == 0;
        Function<Integer, Integer> cube = n -> n * n * n;
        Stream.of(1,2,3).map(n -> Math.pow(n, 3));

        List<String> list = Arrays.asList("A", "BB", "C", "DDD", "EE", "FFFF");
        List<Integer> wordsLength = list.stream().map(str -> str.length()).collect(Collectors.toList());
//        List<Integer> wordsLength = list.stream().map(strToLen).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(wordsLength);

        list.stream().map(_strToLen).forEach(n -> System.out.print(n));
        list.stream().map(_strToLen).forEach(System.out::println);
    }

    private static void reduceEx() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int sum = 0;
        for (Integer o:list) {
            sum += o;
        }
        int streamSum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum + " " + streamSum);
    }

    private static void intStreamEx() {
        IntStream myIntStream = IntStream.of(10,20,30,40,50);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().mapToInt(v -> v).sum();

        IntStream.rangeClosed(2,10).filter(n -> n % 2 == 0).forEach(System.out::println);

    }

    private static void streamCreation() {
        Arrays.asList("A", "B", "C").stream().forEach(System.out::println);
        Stream.of(1,2,3,4).forEach(System.out::println);
        Arrays.stream(new int[]{4,3,2,1}).forEach(System.out::println);
    }

    private static void streamFromFile() {
        try {
            Files.lines(Paths.get("123.txt")).map(String::length).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simpleStringEx(){
        System.out.println(Arrays.stream("A B CC B C AA A A B CC C".split("\\s")).distinct().count());
    }

    private static void uniqueWords() {
        try {
            Stream.of("A", "B", "A", "C", "A", "B").distinct().forEach(System.out::println);

//            Files.lines(Paths.get("WarAndPeace.txt"))
//                    .map(line -> line.split("\\s"))
//                    .distinct()
//                    .forEach(arr -> System.out.println(Arrays.toString(arr)));
//            System.out.println("****************************");

//            Files.lines(Paths.get("WarAndPeace.txt"))
//                    .map(line -> line.split("\\s"))
//                    .map(Arrays::stream)
//                    .distinct()
//                    .forEach(System.out::println);
//            System.out.println("****************************");
//
            System.out.println(Files.lines(Paths.get("WarAndPeace.txt"))
                    .map(line -> line.split("\\s"))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .collect(Collectors.joining(", ", "Уникальные слова: ", ".")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
