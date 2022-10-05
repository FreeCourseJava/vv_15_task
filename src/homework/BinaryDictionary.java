package homework;

import java.util.Iterator;
import java.util.List;

public class BinaryDictionary <KEY, VALUE> implements Dictionary <KEY, VALUE>, Filterable<VALUE>, Iterable<VALUE> {
    
    
    @Override
    public VALUE get(KEY key) {
        return null;
    }

    @Override
    public void put(KEY key, VALUE value) {

    }

    @Override
    public List<VALUE> filter(ValueFilter<VALUE> valueValueFilter) {
        return null;
    }

    @Override
    public Iterator<VALUE> iterator() {
        return null;
    }
}
