package sp;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.DoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SecondPartTasks {

    private SecondPartTasks() {}

    // Найти строки из переданных файлов, в которых встречается указанная подстрока.
    public static List<String> findQuotes(List<String> paths, CharSequence sequence) {
        return paths
                .stream()
                .flatMap(path -> {
                    try(FileReader reader = new FileReader(path)) {
                        BufferedReader in = new BufferedReader(reader);

                        return in
                                .lines()
                                .filter(line -> line.contains(sequence))
                                .collect(Collectors.toList())
                                .stream();
                    } catch(IOException e) {
                        return Stream
                                .empty();
                    }
                })
                .collect(Collectors.toList());
    }

    // В квадрат с длиной стороны 1 вписана мишень.
    // Стрелок атакует мишень и каждый раз попадает в произвольную точку квадрата.
    // Надо промоделировать этот процесс с помощью класса java.util.Random и посчитать, какова вероятность попасть в мишень.
    public static double piDividedBy4() {
        final int LIMIT = 1048576;

        return (double) (new Random())
                .doubles()
                .mapToObj(new DoubleFunction<Pair<Double, Double>>(){
                    boolean isFull = true;
                    double prev = 0;

                    @Override
                    public Pair<Double, Double> apply(double value) {
                        isFull = !isFull;

                        if (isFull) {
                            return new Pair(value, prev);
                        }

                        prev = value;
                        return null;
                    }
                })
                .filter(pair -> pair != null)
                .limit(LIMIT)
                .filter(pair -> Math.pow(pair.getKey() - 0.5, 2) + Math.pow(pair.getValue() - 0.5, 2) < 0.25)
                .count() / LIMIT;
    }

    // Дано отображение из имени автора в список с содержанием его произведений.
    // Надо вычислить, чья общая длина произведений наибольшая.
    public static String findPrinter(Map<String, List<String>> compositions) {
        return compositions
                .entrySet()
                .stream()
                .map(compositor -> new Pair<>(compositor.getKey(), compositor
                                .getValue()
                                .stream()
                                .mapToLong(composition -> composition.length())
                                .sum()))
                .max((firstCompositor, secondCompositor) -> firstCompositor.getValue().compareTo(secondCompositor.getValue()))
                .map(compositor -> compositor.getKey())
                .get();
    }

    // Вы крупный поставщик продуктов. Каждая торговая сеть делает вам заказ в виде Map<Товар, Количество>.
    // Необходимо вычислить, какой товар и в каком количестве надо поставить.
    public static Map<String, Integer> calculateGlobalOrder(List<Map<String, Integer>> orders) {
        return orders
                .stream()
                .flatMap(order -> order.entrySet().stream())
                .map(order -> new Pair<>(order.getKey(), order.getValue()))
                .collect(Collectors.groupingBy(order -> order.getKey(),
                        Collectors.collectingAndThen(Collectors.toList(),
                                values -> values
                                        .stream()
                                        .mapToInt(value -> value.getValue())
                                        .sum())));
    }
}
