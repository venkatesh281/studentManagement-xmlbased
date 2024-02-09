package com.studentManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentManagement.Teacher;

public class TeacherDao {

	@Autowired
	private JdbcTemplate jdbcTemplateTeacher;

	public JdbcTemplate getJdbcTemplateTeacher() {
		return jdbcTemplateTeacher;
	}

	public void setJdbcTemplateTeacher(JdbcTemplate jdbcTemplateTeacher) {
		this.jdbcTemplateTeacher = jdbcTemplateTeacher;
	}

	// save Teacher
	public int save(Teacher t) {
		String sql = "insert into teacher(Id,Name,Email,MaritalStatus,Gender,Age,State,District,Password) values('"
				+ t.getId() + "','" + t.getName() + "','" + t.getEmail() + "','" + t.getMaritalStatus() + "','"
				+ t.getGender() + "','" + t.getAge() + "','" + t.getState() + "','" + t.getDistrict() + "','"
				+ t.getPassword() + "')";
		return jdbcTemplateTeacher.update(sql);
	}

	public int update(Teacher t) {
		String sql = "update teacher set Name='" + t.getName() + "',Email='" + t.getEmail() + "',MaritalStatus='"
				+ t.getMaritalStatus() + "',Gender='" + t.getGender() + "',Age='" + t.getAge() + "',State='"
				+ t.getState() + "',District='" + t.getDistrict() + "',Password='" + t.getPassword() + "' where Id ="
				+ t.getId() + "";
		return jdbcTemplateTeacher.update(sql);
	}

	public Teacher getTeacherById(int id) {
		String sql = "select * from teacher where id=?";
		return jdbcTemplateTeacher.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Teacher>(Teacher.class));
	}

	public List<Teacher> getAllTeacher() {
		return jdbcTemplateTeacher.query("select * from teacher", new RowMapper<Teacher>() {
			public Teacher mapRow(ResultSet rs, int row) throws SQLException {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setEmail(rs.getString(3));
				teacher.setMaritalStatus(rs.getString(4));
				teacher.setGender(rs.getString(5));
				teacher.setAge(rs.getInt(6));
				teacher.setState(rs.getString(7));
				teacher.setDistrict(rs.getString(8));
				teacher.setPassword(rs.getString(9));
				return teacher;
			}

		});
	}

}
