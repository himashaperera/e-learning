package com.elearning.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.LessonDAO;
import com.elearning.model.CourseMaterial;
import com.elearning.model.Lesson;
import com.elearning.service.CourseMaterialService;
import com.elearning.service.LessonService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;

@Service
public class LessonServiceImpl implements LessonService{

	@Autowired
	private LessonDAO lessonDAO;
	
	@Autowired
	private CourseMaterialService courseMaterialService;
	
	@Override
	public void createLesson(Lesson lesson) throws ApplicationException{
		
		//do
		Long generatedId = this.lessonDAO.createLesson(lesson);
		if(generatedId == null)
				throw new ApplicationException(Constants.CREATE_ERROR_MESSAGE);
		lesson.setId(generatedId);
		List<CourseMaterial> courseMaterialList = lesson.getCourseMaterialList();
		for (CourseMaterial courseMaterial : courseMaterialList) {
			courseMaterial.setLesson(lesson);
			this.courseMaterialService.createCourseMaterial(courseMaterial);
		}
	}

	@Override
	public Lesson getLessonById(Long id) throws ApplicationException{
		
		Lesson lessonById = this.lessonDAO.getLessonById(id);
		
		if(lessonById== null)
			throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
		
		List<CourseMaterial> allCourseMaterialByLessonId = this.courseMaterialService.getAllCourseMaterialByLessonId(lessonById.getId());
		lessonById.setCourseMaterialList(allCourseMaterialByLessonId);
		return lessonById;
	}

	@Override
	public List<Lesson> getAllLessons() {
		
		List<Lesson> allLessons = this.lessonDAO.getAllLessons();
		
		for (Lesson lesson : allLessons) {
			List<CourseMaterial> allCourseMaterialByLessonId = this.courseMaterialService.getAllCourseMaterialByLessonId(lesson.getId());
			lesson.setCourseMaterialList(allCourseMaterialByLessonId);
		}
		return allLessons;
	}

	@Override
	public List<Lesson> getLessonByCourseId(Long id) {
		List<Lesson> allLessonsByCourseId = this.lessonDAO.getAllLessonsByCourseId(id);
		
		for (Lesson lesson : allLessonsByCourseId) {
			List<CourseMaterial> allCourseMaterialByLessonId = this.courseMaterialService.getAllCourseMaterialByLessonId(lesson.getId());
			lesson.setCourseMaterialList(allCourseMaterialByLessonId);
		}
		return allLessonsByCourseId;
	}

}
