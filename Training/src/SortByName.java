import java.util.Comparator;

public class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		int diff=o1.getName().compareTo(o2.getName());
		return diff;
	}

}
