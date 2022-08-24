import java.util.Arrays;
import java.util.Comparator;

public class UsoComparator {

    public static void main(String[] args) {
        Integer[] array = {4, 1, 7, 2, 5 };

        print(array, (value1, value2) -> value1 - value2);

        // boa pratica
        print(array, Comparator.comparingInt(value -> value));
    }

    public static void print(Integer[] array, Comparator<Integer> comparator) {
        Arrays.sort(array, comparator);
        System.out.println(Arrays.toString(array));
    }
}
