package stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Java8StreamTest {

    /**
     * 在 java8 中，可以使用 forEach + lambda 表达式循环 Map。
     */
    @Test
    public void foreachTest() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
            if ("E".equals(k)) {
                System.out.println("Hello E");
            }
        });
    }

    /**
     * 1.collect(toList()) 终止操作
     * <p>
     * 由Stream中的值生成一个List列表，也可用collect(toSet())生成一个Set集合。
     * <p>
     * 例：取 Stream 中每个字符串并放入一个新的列表，
     */
    @Test
    public void collectToList() {
        String[] testStrings = {"java", "react", "angular", "vue"};
        List<String> list = Stream.of(testStrings).collect(Collectors.toList());

        //list.forEach(item -> System.out.println(item));
        list.forEach(System.out::println);
    }

    /**
     * 2.map 中间操作
     * <p>
     * 将一种类型的值映射为另一种类型的值，
     * 可以将 Stream 中的每个值都映射为一个新的值，最终转换为一个新的 Stream 流。
     * <p>
     * 例：把 Stream 中每个字符串都转换为大写的形式，
     */
    @Test
    public void mapTest() {
        String[] testStrings = {"java", "react", "angular", "vue"};

        List<String> list = Stream.of(testStrings)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    /**
     * 3.filter 中间操作
     * 遍历并筛选出满足条件的元素形成一个新的 Stream 流。
     * <p>
     * 例：筛选出以 j 字母开头的元素个数，
     * 此例中的count方法也是终止操作，是为了计算出 Stream 中的元素个数，
     */
    @Test
    public void filterTest() {
        List<String> list = Arrays.asList("java", "react", "angular", "javascript", "vue");

        long count = list.stream().filter(p -> p.startsWith("j")).count();

        System.out.println(count);
    }

    /**
     * 4.flatMap 中间操作
     * 可用 Stream 替换值，并将多个 Stream 流合并成一个 Stream 流。
     * <p>
     * 例：将含有一串数字的两个流合并为一个流，
     */
    @Test
    public void flapMapTest() {
        List<Integer> list = Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(8, 9, 10, 11, 12)
        ).flatMap(test -> test.stream()).collect(Collectors.toList());

        for (int i = 0, length = list.size(); i < length; i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 5.max 、min 终止操作
     * 求 Stream 中的最大值、最小值。
     * <p>
     * 例：取出 Stream 中最长的字符串
     */
    @Test
    public void maxTest() {
        String[] testStrings = {"java", "react", "angular", "javascript", "vue"};

        //Optional<String> max = Stream.of(testStrings).max((p1, p2) -> Integer.compare(p1.length(), p2.length()));
        Optional<String> max = Stream.of(testStrings).max(Comparator.comparingInt(String::length));

        System.out.println(max);
    }

    /**
     * 6.reduce 终止操作
     * 从 Stream 的一组值中生成另一个值。
     * <p>
     * 例：上述的max、min、count 实际上都是 reduce 操作，求出 Stream 元素数值的总和，
     */
    @Test
    public void reduceSumTest() {
        //int sum = Stream.of(5, 6, 7, 8).reduce(0, (accumulator, element) -> accumulator + element);
        int sum = Stream.of(5, 6, 7, 8).reduce(0, Integer::sum);

        System.out.println(sum);
    }

    /**
     * 将list集合转Map
     */
    @Test
    public void listToMap() {
        List<Man> manList = new ArrayList<>();
        manList.add(new Man("1", "人"));
        manList.add(new Man("1", "我"));

        //list to map 无重复key的时候
        // Map<String, Man> map1 = manList.stream().collect(Collectors.toMap(Man::getId, test->test));
        //System.out.println(map1.get("1").getName());

        //list to map 有重复key的时候
        Map<String, Man> map = manList.stream().collect(Collectors.toMap(Man::getId, Function.identity(), (test1, test2) -> test1));
        System.out.println(map.get("1").getName());

        //list to map value值取单个字段时
        Map<String, String> mapname1 = manList.stream().collect(Collectors.toMap(Man::getId, Man::getName, (man1, man2) -> man1));
        System.out.println(mapname1.get("1"));

        //list to map value值拼接
        Map<String, String> mapcomb = manList.stream().collect(Collectors.toMap(Man::getId, Man::getName, (key1, key2) -> key1 + "," + key2));
        System.out.println(mapcomb.get("1"));

        // list转map， 重复时将重复key的数据组成集合
        Map<String, List<String>> maplist = manList.stream().collect(Collectors.toMap(Man::getId, p -> {
            List<String> list = new ArrayList<>();
            list.add(p.getName());
            return list;
        }, (List<String> value1, List<String> value2) -> {
            value1.addAll(value2);
            return value1;
        }));
        System.out.println(maplist.get("1").toString());
    }

}