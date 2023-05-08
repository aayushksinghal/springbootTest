import java.util.List;
import java.util.function.Predicate;

public class SlicingOprations {

    public void checkSkip(List<Employee> employeeList){
        employeeList.stream().skip(1).forEach(System.out::println);
    }

    public void checkDistinct(List<Employee> employeeList) {
        employeeList.stream().distinct().forEach(System.out::println);
    }

    public void checkLimit(List<Employee> employeeList) {
        employeeList.stream().limit(3).forEach(System.out::println);
    }
}
