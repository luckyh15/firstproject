package com.semi.flix.admin.mail;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface MailDao {
	List<MailDto> getList(MailDto dto);
	int getTotal(MailDto dto);
	void insert(MailDto dto);
	MailDto getView(String seq);
}
