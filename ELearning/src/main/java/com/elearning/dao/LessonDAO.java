package com.elearning.dao;

import java.util.List;

import com.elearning.model.Lesson;

public interface LessonDAO {

	Long createLesson(Lesson lesson);
	Integer updateLesson(Lesson lesson);
	List<Lesson> getAllLessons();
	List<Lesson> getAllLessonsByCourseId(Long id);
	Lesson getLessonById(Long id);
}
