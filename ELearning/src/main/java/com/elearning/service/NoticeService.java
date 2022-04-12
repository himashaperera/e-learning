package com.elearning.service;

import java.util.List;

import com.elearning.model.Notice;
import com.elearning.util.ApplicationException;
public interface NoticeService {

	public void createNotice(Notice notice) throws ApplicationException;
	public void updateNotice(Notice notice) throws ApplicationException;
	public List<Notice> getAllNoices();
	public Notice getNoticeById(Long id) throws ApplicationException ;

}
