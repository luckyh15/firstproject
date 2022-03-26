package com.semi.flix.search;

import java.util.List;

public interface SearchService {
	List<SearchDto> getList(SearchDto dto);
}