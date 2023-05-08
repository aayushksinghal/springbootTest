public class Employee {
    String name;
    int age;
    int salary;

    Employee(String name) {
        this.name = name;
    }

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object emp) {
        Employee employee = (Employee) emp;
        return name.equals(employee.getName()) && salary == employee.salary && age == employee.age;
    }

    @Override
    public int hashCode() {
        return getName().hashCode() * Integer.hashCode(salary) * Integer.hashCode(age);
    }

}

