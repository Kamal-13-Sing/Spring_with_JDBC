package springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;  

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;
  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	//--------------save Employee-----------------
	
	
	  public int saveEmployee(Employee emp) {
	  
	  String query = "insert into springfirst(id, name, address, salary)" +
	  "values('"+emp.getId()+"','"+emp.getName()+"', '"+emp.getAddress()+"', '"+emp
	  .getSalary()+"')";
	  
	  return jdbcTemplate.update(query); 
	  
	  }
	 
	  //---------update Employee----------------
	  public int updateEmployee(Employee emp) {
		  String query = "update springfirst set salary='"+emp.getSalary()+"' where id='"+emp.getId()+"'";
		  
		  return jdbcTemplate.update(query);
	  }
	  
	  //----------view Employee----------------
	  /*
	  public List<Employee> read(){  
		  String query = "select * from springfirst";
		  
		  return jdbcTemplate.query(query,new ResultSetExtractor<List<Employee>>(){  
		     
			  public List<Employee> extractData(ResultSet rs) throws SQLException,DataAccessException {  
		       
		         List<Employee> list = new ArrayList<Employee>();  
		          
		         while(rs.next()){  
		         Employee e = new Employee();  
		         e.setId(rs.getInt(1));  
		         e.setName(rs.getString(2));
		         e.setAddress(rs.getString(3));
		         e.setSalary(rs.getInt(4));  
		         list.add(e);  
		         }  
		         
		         return list;  
		     
		         }
		  
		     });  
	  }
	  */
	  
	  //----------read with RowMapper------------------
	  public List<Employee> getAllEmployeesRowMapper(){  
		  String query = "select * from springfirst";
		  return jdbcTemplate.query(query,new RowMapper<Employee>(){  
		      
		     public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	 
		         Employee e = new Employee();  
		         e.setId(rs.getInt(1));  
		         
		         e.setName(rs.getString(2));  
		         e.setAddress(rs.getString(3));  
		         e.setSalary(rs.getInt(4)); 
		         
		         return e;  
		     }  
		     });  
		 }  
	  
	  
	  //----------------insert with prepared Statement---------------
	  
	  public Boolean saveEmployeeByPreparedStatement( final Employee e){  
		  
		    String query="insert into springfirst values(?,?,?,?)";  
		    
		    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
		    	
		    public Boolean doInPreparedStatement(PreparedStatement ps)  throws SQLException, DataAccessException {  
		              
		        ps.setInt(1,e.getId());  
		        ps.setString(2,e.getName());  
		        ps.setString(3,e.getAddress());  
		        ps.setInt(4,e.getSalary()); 
		              
		        return ps.execute();  
		              
		    }  
		    });  
		}
	  
	  
//-----------------update with simple jdbcTemplate-----------------
	  public int update (Employee e){  
		  
		  String query="update springfirst set name=? where id=?";  
		  
		  return jdbcTemplate.update(query,e.getName(),e.getId());  
		    
		  //String query="update employee set name=?,salary=? where id=?";  
		  //return template.update(query,e.getName(),e.getSalary(),e.getId());  
		  }  
	  
	
}













