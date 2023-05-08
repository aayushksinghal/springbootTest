import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MethodReference {

    public int getLength(String str){
        return str.length();
    }

    public static int getStaticLength(String str){
        return str.length();
    }

    public void checkStaticReference(){
        List<String> list = new ArrayList<>();
        list.add("Aayush");
        list.add("Darsh");
        list.add("Taru");
        list.stream().forEach(System.out::println);
        list.stream().mapToInt(MethodReference::getStaticLength).forEach(System.out::println);

    }

    public void checkMethodReference(){
        List<String> list = new ArrayList<>();
        list.add("Aayush");
        list.add("Darsh");
        list.add("Taru");
        // if we have to use streamed object in method of other class we need to create object of other method
        MethodReference mr = new MethodReference();
        list.stream().mapToInt(mr::getLength).forEach(System.out::println);
    }

    public void checkInstanceMethodReference(List<Employee> employeeList){
        int salarySum = employeeList.stream().filter(employee -> employee.getSalary()>0).mapToInt(Employee::getSalary).sum();
        System.out.println("Sum of salaries = " + salarySum);

    }

    public void checkConstructorReference(){
        List<String> list = new ArrayList<>();
        list.add("Aayush");
        list.add("Darsh");
        list.add("Taru");
        List<Employee> employeeList = list.stream().map(Employee::new).collect(Collectors.toList());
        Map<String, Employee>  employeeMap  = list.stream().collect(Collectors.toMap(String::valueOf, Employee::new));
        employeeList.stream().forEach(System.out::println);
        employeeMap.entrySet().stream().forEach(System.out::println);
    }
}
