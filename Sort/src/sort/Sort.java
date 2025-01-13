package sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Sort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final Double[][] doubles = new Double[][]{{5.0, 4.0}, {1.0, 1.0}, {4.0, 6.0}};
	    final Comparator<Double[]> arrayComparator = new Comparator<Double[]>() {
	        @Override
	        public int compare(Double[] o1, Double[] o2) {
	            return o1[0].compareTo(o2[0]);
	        }
	    };
	    Arrays.sort(doubles, arrayComparator);
	    for (final Double[] arr : doubles) {
	        System.out.println(Arrays.toString(arr));
	    }
	}

}
