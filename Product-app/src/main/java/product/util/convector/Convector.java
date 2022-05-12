package product.util.convector;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Convector<T> {
    public List<T> convertArrayToList(T[] array) {
        List<T> items = new ArrayList<>();
        Collections.addAll(items, array);
        return items;
    }
}
