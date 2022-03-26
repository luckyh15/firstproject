package com.semi.flix.admin.mail;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("mailService")
public class MailServiceImpl implements MailService{
	
	//@Autowired
	@Resource(name="mailDao")
	MailDao mailDao;
	
	@Override
	public List<MailDto> getList(MailDto dto) {
		return mailDao.getList(dto);
	}

	@Override
	public void insert(MailDto dto) {
		mailDao.insert(dto);
	}

	@Override
	public MailDto getView(String seq) {
		return mailDao.getView(seq);
	}

	@Override
	public int getTotal(MailDto dto) {
		return mailDao.getTotal(dto);
	}

}
