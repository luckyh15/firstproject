package com.semi.flix.admin.mail;

import java.util.List;

public interface MailService {
	List<MailDto> getList(MailDto dto);
	void insert(MailDto dto);
	MailDto getView(String seq);
	int getTotal(MailDto dto);
}
