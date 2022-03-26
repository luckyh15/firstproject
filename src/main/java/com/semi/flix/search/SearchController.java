package com.semi.flix.search;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.flix.common.BaseDto;
import com.semi.flix.drama.DramaDto;
import com.semi.flix.drama.DramaService;
import com.semi.flix.movie.MovieDto;
import com.semi.flix.movie.MovieService;

@Controller
public class SearchController {

	
	@Resource(name="dramaService")
	DramaService dramaService;
	
	@Resource(name="movieService")
	MovieService movieService;
	
	@Resource(name="searchService")
	SearchService searchService;

	
	@RequestMapping(value = "/search/search_view", method = RequestMethod.GET)
	public String search(Locale locale, Model model, BaseDto baseDto) {

		
		
		//****************�뱶�씪留�****************
		DramaDto dramaDto = new DramaDto();
		dramaDto.setStart( dramaDto.getPg()*10); 
		dramaDto.setKeyword(baseDto.getKeyword());
		
		List<DramaDto> dramaList = dramaService.getList(dramaDto);
		
		int cnt = dramaService.getTotal(dramaDto);
		
		model.addAttribute("totalCnt", cnt);
		model.addAttribute("dramaList", dramaList);
		
		
		//****************占쎌럲占쎈뙀*****************
		
		MovieDto movieDto = new MovieDto();
		movieDto.setStart( movieDto.getPg()*10); 
		movieDto.setKeyword(baseDto.getKeyword());
//		
//		System.out.println("[HomeController search keyword]" + webtoonDto.getKeyword());
//		
	    List<MovieDto> movieList = movieService.getList(movieDto);
//
//		System.out.println("[HomeController webtoonList]" + webtoonList);
//		
		model.addAttribute("movieList", movieList);
		
		
		return "search/search_list";
	}
	
	
	@RequestMapping(value = "/search/search_list", method = RequestMethod.GET)
	public String search_list(Locale locale, Model model, SearchDto dto) {
		System.out.println("[search_list---------------dto-----]" + dto.getKeyword());
		
		dto.setStart(dto.getPg()*10);
		List<SearchDto> list = searchService.getList(dto);
		
		model.addAttribute("totalCnt", 10);
		model.addAttribute("searchList", list);
		
		System.out.println("[search_list--------------------]" + list);
		
		return "search/search_list";
	
	}
	
	@RequestMapping(value = "/search/keyword_list", method = RequestMethod.GET)
	@ResponseBody
	public List<SearchDto> search_list2(Locale locale, Model model, SearchDto dto) {
		System.out.println("search_list22222222222222222222222222" + dto.getKeyword());
		dto.setStart(dto.getPg()*10);
		List<SearchDto> list = searchService.getList(dto);
		
		model.addAttribute("totalCnt", 10);
		model.addAttribute("searchList", list);
		
		System.out.println("[search_list--------------------]" + list);
		
		
		return list;
	
	}
	
	

}