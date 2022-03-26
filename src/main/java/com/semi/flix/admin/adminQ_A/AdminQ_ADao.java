package com.semi.flix.admin.adminQ_A;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface AdminQ_ADao {
	List<AdminQ_ADto> getList(AdminQ_ADto dto);
	int getTotal(AdminQ_ADto dto);
	AdminQ_ADto getView(String seq);
	void delete(String seq);
}
