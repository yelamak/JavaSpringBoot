import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> l=new ArrayList<>();
		l.add(new Employee(1,"aaa",5000));
		l.add(new Employee(2,"aba",5000));
		l.add(new Employee(3,"vaa",5000));
		Collections.sort(l,new SortByName());
		for (Employee employee : l) {
			System.out.println(employee.getName());
		}
		
		
	}

}
