import java.util.*;
import java.util.stream.*;
import java.util.function.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<String> fruit = Arrays.asList("cherry","banana","berry","apple","cherry","kiwi","fig","date","lemon","honeydew","cherry","elderberry","apple","banana","grape");

        // Collect elements into a Set
        Set<String> fruits = fruit.stream().collect(Collectors.toSet());

        // Collect the fruit into groups based on their first character
        Map<String, List<String>> groupedByFirstLetter = fruits.stream().collect(Collectors.groupingBy(str -> str.substring(0, 1)));
        System.out.println(groupedByFirstLetter);

        // Group fruit by the length of the name
        Map<Integer, List<String>> groupByLength = fruits.stream().collect(Collectors.groupingBy((str) -> str.length()));
        System.out.println(groupByLength);

        //Collect the fruit that has erry in it
        Predicate<String> hasErry = (str) -> str.indexOf("erry") != -1;
        Set<String> fruitsWithErry = fruits.stream().filter(hasErry).collect(Collectors.toSet());
        System.out.println(fruitsWithErry);

        //Create a partition of fruit based on if it contains erry
        Map<Boolean, List<String>> partition = fruits.stream().collect(Collectors.partitioningBy(hasErry));
        System.out.println(partition);

        //collect/ the fruit that has 5 or less symbols
        Predicate<String> lessThanFiveSymbols = (str) -> str.length() <= 5;
        Set<String> setWithLessThanFiveSymbols = fruits.stream().filter(lessThanFiveSymbols).collect(Collectors.toSet());
        System.out.println(setWithLessThanFiveSymbols);

        //find the total number of symbols in all the fruit stored
        int total = fruits.stream().collect(Collectors.summingInt((str) -> str.length()));
        System.out.println(total);

        List<Integer> data = Arrays.asList(87, 23, 45, 100, 6, 78, 92, 44, 13, 56, 34, 99, 82, 19, 1012, 78, 45, 90, 23, 56, 78, 100, 3, 43, 67, 89, 21, 34, 10);

        // Partition data based on if >=50
        Predicate<Integer> greaterThanFifty = (x) -> x >= 50;
        Map<Boolean, List<Integer>> greaterThanFiftyPartition = data.stream().collect(Collectors.partitioningBy(greaterThanFifty));
        System.out.println(greaterThanFiftyPartition);

        //divide data into groups based on the remainder when divided by 7
        Map<Integer, List<Integer>> divBy7 = data.stream().collect(Collectors.groupingBy((x) -> x % 7));
        System.out.println(divBy7);

        //find the sum of the data
        int sum = data.stream().collect(Collectors.summingInt((x) -> x));
        System.out.println(sum);

        //collect the unique values
        Set<Integer> unique = data.stream().distinct().collect(Collectors.toSet());
        System.out.println(unique);

        //compute the cube of each values
        Function<Integer, Integer> cubeInt = (x) -> (int) Math.pow(x, 3);
        Set<Integer> cubedValues = data.stream().map(cubeInt).collect(Collectors.toSet());
        System.out.println(cubedValues);

        //find the sum of the cubes of each value
        int sumOfCubedValues = data.stream().map(cubeInt).collect(Collectors.summingInt((x) -> x));
        System.out.println(sumOfCubedValues);

        //increase the value of each element by 5
        Function<Integer, Integer> increaseByFive = (x) -> x + 5;
        Set<Integer> valuesIncreasedByFive = data.stream().map(increaseByFive).collect(Collectors.toSet());
        System.out.println(valuesIncreasedByFive);

        //compute the cube of the even values
        Function<Integer, Integer> cubeIfEven = (x) -> x % 2 == 0 ? (int) Math.pow(x, 3) : x;
        Set<Integer> valuesWithEvenCubed = data.stream().map(cubeIfEven).collect(Collectors.toSet());
        System.out.println(valuesWithEvenCubed);
    }
}