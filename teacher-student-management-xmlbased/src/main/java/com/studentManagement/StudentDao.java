package com.studentManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.studentManagement.Student;


public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
	
	//save student
	public int save(Student s) {
		String sql = "insert into student(RollNum,Name,Mobile,Age,std,Gender,Place) values('" + s.getRollnum() + "','"
				+ s.getName() + "','" + s.getMobile() + "','" + s.getAge() + "','" + s.getStd() + "','" + s.getGender()
				+ "','" + s.getPlace() + "')";
		return jdbcTemplate.update(sql);
	}
    
	// update student
	public int update(Student s) {
		String sql = "update student set Name='" + s.getName() + "', Mobile='" + s.getMobile() + "',Age='" + s.getAge()
				+ "',std='" + s.getStd() + "',Gender='" + s.getGender() + "',Place='" +s.getPlace()+"' where RollNum="
				+ s.getRollnum() + "";
		return jdbcTemplate.update(sql);
	}
    
	//delete student
	public int delete(int rollNum) {
		String sql = "delete from student where RollNum=" + rollNum + "";
		return jdbcTemplate.update(sql);
	}

	public Student getStudentByRollNum(int rollNum) {
		String sql = "select * from student where RollNum=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { rollNum },
				new BeanPropertyRowMapper<Student>(Student.class));
	}

	public List<Student> getStudents() {
		return jdbcTemplate.query("select * from student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student e = new Student();
				e.setRollnum(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setMobile(rs.getString(3));
				e.setAge(rs.getInt(4));
				e.setStd(rs.getInt(5));
				e.setGender(rs.getString(6));
				e.setPlace(rs.getString(7));

				return e;
			}

		});

	}
}
