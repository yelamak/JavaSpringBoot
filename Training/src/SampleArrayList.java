import java.util.ArrayList;
import java.util.List;

public class SampleArrayList {

	public static void main(String[] args) {
		List<Integer> a=new ArrayList<>();
		a.add(23);
		a.add(43);
		a.add(324);
		System.out.println(a);
		a.remove(new Integer(23));
		System.out.println(a);
		for (Integer integer : a) {
			System.out.println(integer);
		}
	}

}
