package com.elearning.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.elearning.dao.CourseMaterialDAO;
import com.elearning.model.CourseMaterial;
import com.elearning.repository.CourseMaterialRowMapper;

@Repository
public class CourseMaterialDAOImpl implements CourseMaterialDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CourseMaterial getCourseMaterialById(Long id) {
		String sql = "select * from courseMaterial where materialid = ? ";
		List<CourseMaterial> courseMaterialList = this.jdbcTemplate.query(sql, new CourseMaterialRowMapper(), id);
		
		if(courseMaterialList.isEmpty()) {
			return null;
		}else {
			return courseMaterialList.get(0);
		}
	}

	public List<CourseMaterial> getAllCourseMaterial() {
		String sql = "select * from courseMaterial";
		List<CourseMaterial> courseMaterialList = this.jdbcTemplate.query(sql, new CourseMaterialRowMapper());
		return courseMaterialList;
	}

	public Long createCourseMaterial(CourseMaterial courseMaterial) {
		String sql = 
				"insert into courseMaterial(materialid, name, createdAt, updatedAt, lesnMaterialid) values(?, ?, ?, ?, ?)";
	    KeyHolder keyHolder = new GeneratedKeyHolder();
	    this.jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(sql, new String[] {"materialid"});
	          if(courseMaterial.getId() == null )
	        	  ps.setNull(1, Types.NULL);
	          else
	        	  ps.setLong(1, courseMaterial.getId());
	          
	          ps.setString(2, courseMaterial.getName());
	          ps.setDate(3, new Date(courseMaterial.getCreatedAt().getTime()));
	          ps.setDate(4, new Date(courseMaterial.getUpdatedAt().getTime()));
	          if(courseMaterial.getLesson() == null)
	        	  ps.setNull(5, Types.NULL);
	          else
	        	  ps.setLong(5, courseMaterial.getLesson().getId());
	          
	          return ps;
	        }, keyHolder);
	    
	    	System.out.println(keyHolder.getKey());
	    	System.out.println(keyHolder.getKey().longValue());
	        return keyHolder.getKey().longValue();
	        
	}

	public Integer updateteCourseMaterial(CourseMaterial courseMaterial) {
		String sql = 
				"update courseMaterial set name=?, createdAt=?, updatedAt=?, lesnMaterialid=? where materialid=?";
		int updateCount = this.jdbcTemplate.update(sql,courseMaterial.getName(), courseMaterial.getCreatedAt(),
				courseMaterial.getUpdatedAt(), courseMaterial.getLesson().getId(), courseMaterial.getId());
		return updateCount;
	}

	@Override
	public List<CourseMaterial> getAllCourseMaterialByLessonId(Long id) {
		String sql = "select * from courseMaterial where lesnMaterialid = ? ";
		List<CourseMaterial> courseMaterialList = this.jdbcTemplate.query(sql, new CourseMaterialRowMapper(), id);
		return courseMaterialList;
	}

}
