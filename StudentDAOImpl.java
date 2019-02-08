package com.rm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.rm.bo.StudentBO;

public  class StudentDAOImpl implements StudentDAO {
private final static String spring_insert_student="INSERT INTO SPRING_STUDENT(SNAME,TOTAL,AVG,RESULT)VALUES(?,?,?,?)";
  private DataSource datasource;
  
	public StudentDAOImpl(DataSource datasource) {
	this.datasource = datasource;
}

	@Override
	public int insert(StudentBO studentbo) throws Exception {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		//get jdbc con obj from pooled connection
		connection=datasource.getConnection();
		//create PreparedStatement obj
		preparedStatement=connection.prepareStatement(spring_insert_student);
		//set BO data as the query param values
		preparedStatement.setString(1,studentbo.getSname());
		preparedStatement.setInt(2,studentbo.getTotal());
		preparedStatement.setFloat(3,studentbo.getAvg());
		preparedStatement.setString(4,studentbo.getResult());
		//execute the query
		count=preparedStatement.executeUpdate();
		//close jdbc objs
		preparedStatement.close();
		connection.close();
		return count;
	}

}
