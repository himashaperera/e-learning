package com.elearning.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.NoticeDAO;
import com.elearning.model.Notice;
import com.elearning.service.NoticeService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public void createNotice(Notice notice) throws ApplicationException {
		// TODO Auto-generated method stub
		
		Long createNotice = this.noticeDAO.createNotice(notice);
		if(createNotice < 1)
			throw new ApplicationException(Constants.CREATE_ERROR_MESSAGE);
	}

	@Override
	public Notice getNoticeById(Long id) throws ApplicationException {
		// TODO Auto-generated method stub
		
		Notice noticeById = this.noticeDAO.getNoticeById(id);
		if(noticeById == null)
			throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
		return noticeById;
		
	}

	@Override
	public List<Notice> getAllNoices() {
		// TODO Auto-generated method stub
		
		List<Notice> allNotices = this.noticeDAO.getAllNoices();
		return allNotices;
	}

	@Override
	public void updateNotice(Notice notice) throws ApplicationException {
		// TODO Auto-generated method stub
		
		Long updateNotice = this.noticeDAO.updateNotice(notice);
		if(updateNotice == null)
			throw new ApplicationException(Constants.UPDATE_ERROR_MESSAGE);

		
	}

}
