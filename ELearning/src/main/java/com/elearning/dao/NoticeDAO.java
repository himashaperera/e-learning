package com.elearning.dao;

import java.util.List;

import com.elearning.model.Notice;

public interface NoticeDAO {
	
	Notice getNoticeById(Long id);
	List<Notice> getAllNoices();
	Long createNotice(Notice notice);
	Long updateNotice(Notice notice);
}
