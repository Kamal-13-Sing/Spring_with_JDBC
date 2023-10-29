package springjdbc;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc/config.xml");
		System.out.println(context);
		 
		EmployeeDao ed = context.getBean("edao",EmployeeDao.class);
		/* Employee e = new Employee(101,"kamal Thapa","Butwal",50000); */
		/*
		 * Employee e = new Employee(102,"Rabin Hood","Palpa",90000);
		 * 
		 * System.out.println("name: "+e.getName() ); 
		 * int status = ed.saveEmployee(e);
		 * System.out.println(status);
		 */
		
		//---------------Update Employee-------------
		/*
		 * Employee e = new Employee(101,"kamal Thapa","Butwal",150000);
		 * System.out.println("name: "+e.getName() ); int status = ed.updateEmployee(e);
		 * System.out.println(status);
		 */
		//-------------View Employee-----------------
		/*
		List<Employee> list = ed.read();
		for(Employee e:list) {
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getAddress());
			System.out.println(e.getSalary());
			System.out.println("--------------");
		}
		*/
		
		//-------------view Employee with RowMapper---------------
		List<Employee> list = ed.getAllEmployeesRowMapper(); 
		
		for(Employee e: list) {
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getAddress());
			System.out.println(e.getSalary());
			System.out.println("--------------");
		}
		
		
		//------------insert with prepared Statement----------------
		/*
		 Employee e = new Employee(105,"pratik Achrya","Haraiya",45000);
		  
		  System.out.println("name: "+e.getName() ); 
		  boolean status = ed.saveEmployeeByPreparedStatement(e);
		  System.out.println(status);
		*/
		  
//-----------------update with simple jdbcTemplate-----------------
		/*
		  Employee e = new Employee(101,"kamala pun magar","Butwal",150000);
		  System.out.println("name: "+e.getName() );
		  int status = ed.update(e);
		  System.out.println(status);		  
		  */
		  
	}
	


}
