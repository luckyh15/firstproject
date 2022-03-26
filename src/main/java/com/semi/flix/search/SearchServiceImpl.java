package com.semi.flix.search;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



@Service("searchService")
public class SearchServiceImpl implements SearchService {
	
	@Resource(name="searchDao")
	SearchDao searchDao;
	
	@Override
	public List<SearchDto> getList(SearchDto dto) {
		return searchDao.getList(dto);
	}

	
	
	
}