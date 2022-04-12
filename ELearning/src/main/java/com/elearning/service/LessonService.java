package com.elearning.service;

import java.util.List;

import com.elearning.model.Lesson;
import com.elearning.util.ApplicationException;

public interface LessonService {

	void createLesson(Lesson lesson) throws ApplicationException;
	Lesson getLessonById(Long id) throws ApplicationException;
	List<Lesson> getAllLessons();
	List<Lesson> getLessonByCourseId(Long id);
}
