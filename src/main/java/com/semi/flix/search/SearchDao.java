package com.semi.flix.search;

import java.util.List;

public interface SearchDao {
	List<SearchDto> getList(SearchDto dto);

}