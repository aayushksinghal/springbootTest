import java.util.ArrayList;
import java.util.List;

public class Java8Testing {

    public static void main(String args[]){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Aayush", 34, 200000));
        employeeList.add(new Employee("Aayush", 34, 200000));
        employeeList.add(new Employee("Taru", 34, 250000));
        employeeList.add(new Employee("Darsh", 2, 0));
        employeeList.add(new Employee("Rohit", 35, 350000));
        employeeList.add(new Employee("Manoj", 35, 450000));

        MethodReference mr = new MethodReference();
//        mr.checkStaticReference();
//        mr.checkMethodReference();
//        mr.checkInstanceMethodReference(employeeList);
//        mr.checkConstructorReference();

        SlicingOprations so = new SlicingOprations();
     //   so.checkSkip(employeeList);
      //  so.checkDistinct(employeeList);
        so.checkLimit(employeeList);
    }
}
