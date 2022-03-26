package com.semi.flix.Visit;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("visitService")
public class VisitServiceImpl implements VisitService{

	@Resource(name="visitDao")
	VisitDao visitDao;

	@Override
	public void insert(VisitDto dto) {
		visitDao.insert(dto);
	}

	@Override
	public int getTotal(VisitDto dto) {
		return visitDao.getTotal(dto);
	}

	@Override
	public void update(VisitDto dto) {
		visitDao.update(dto);
	}

	@Override
	public List<VisitDto> getMonth() {
		return visitDao.getMonth();
	}


		
}



