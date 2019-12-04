package model;

import java.util.Comparator;
import java.util.List;

public class ShortestPathComparator implements Comparator<List<IVertex>> {

    @Override
    public int compare(List<IVertex> o1, List<IVertex> o2) {
    	// compare weights instead of size
    	return o1.size() - o2.size();
    }
}
