package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {
    //declar o variabila de tip repository
    private EmployeeMock employeeRepository;
    private DidacticFunction newFunction;
    private EmployeeMock employeeMock;
    private Employee existingEmployee;

    @BeforeEach
    void setUp() {
        //LAB2
        employeeRepository = new EmployeeMock();
        //lab3
        employeeMock = new EmployeeMock();
        newFunction = DidacticFunction.CONFERENTIAR;
        existingEmployee = new Employee("Larson", "Puscas", "1234567890876", DidacticFunction.TEACHER, 2500d);
        employeeMock.addEmployee(existingEmployee);
    }

    //lab2
    @Test
    void addEmployeeT1() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee("diana", "mihalescu", "3849503829384", DidacticFunction.ASSISTENT, 0.0));
        assertEquals(6, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeT2() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee("Moni", "Badiu", "7483923028474", DidacticFunction.TEACHER, -5.0));
        assertEquals(6, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeT3() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee("diana", "mihalescu", "3849503829384", DidacticFunction.ASSISTENT, 439049.0
        ));
        assertEquals(7, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeT4() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee("diana", "mihalescu", "3849503829384", DidacticFunction.ASSISTENT, 43848.0
        ));
        assertEquals(7, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeT5() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee("diana", "pop9", "7483923028474", DidacticFunction.LECTURER, 4884.0
        ));
        assertEquals(6, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeT6() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee("Moni", "37474", "3749402749304", DidacticFunction.TEACHER, 4994.0
        ));
        assertEquals(6, employeeRepository.getEmployeeList().size());
    }

    //lab3
    @Test
    void TC1() {
        employeeMock.modifyEmployeeFunction(null, newFunction);
        assertEquals(DidacticFunction.TEACHER, existingEmployee.getFunction());
    }

    //am apelat functia cu un employee null si am comparat functia angajatului existent cu ce avea el inainte sa ne asiguram ca nu s a mod; nu vrem sa se modifice functia angajatului existent daca i trimit un parametru null
    @Test
    void TC2() {
        employeeMock.modifyEmployeeFunction(existingEmployee, newFunction);
        assertEquals(existingEmployee.getFunction(), newFunction);
    }
//am apelat functia angajatului existent si asteptam sa se modifice functia ang existent
}
