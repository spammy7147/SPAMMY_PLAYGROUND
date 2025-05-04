package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericFilter {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        ArrayList<T> filtered = new ArrayList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                filtered.add(el);
            }
        }
        return filtered;
    }
}
