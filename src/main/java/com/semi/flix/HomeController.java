package com.semi.flix;


import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semi.flix.animation.AnimationDto;
import com.semi.flix.animation.AnimationService;
import com.semi.flix.drama.DramaDto;
import com.semi.flix.drama.DramaService;
import com.semi.flix.enter.EnterDto;
import com.semi.flix.enter.EnterService;
import com.semi.flix.movie.MovieDto;
import com.semi.flix.movie.MovieService;
import com.semi.flix.webtoon.WebtoonDto;
import com.semi.flix.webtoon.WebtoonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource(name="dramaService")
	DramaService dramaService;
	
	@Resource(name="movieService")
	MovieService movieService;
	
	@Resource(name="webtoonService")
	WebtoonService webtoonService;
	
	@Resource(name="animationService")
	AnimationService animationService;
	
	@Resource(name="enterService")
	EnterService enterService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//=====================  Drama  ===================//
		DramaDto dramaDto = new DramaDto();
		dramaDto.setPageSize(10);
		dramaDto.setStart(0);
		
		//List<DramaDto> dramaList = dramaService.getList(dramaDto);
		List<DramaDto> dramaList = dramaService.getRank(dramaDto);
		System.out.println("[HomeController---------------]" + dramaList);
		model.addAttribute("dramaList", dramaList);
		
		//=====================  Movie  ===================//
		
		MovieDto movieDto = new MovieDto();
		movieDto.setStart(movieDto.getPg()*10);
		List<MovieDto> movieList = movieService.getRank(movieDto);
		
		System.out.println("[HomeController---------------]" + movieList);
		model.addAttribute("movieList", movieList);
		
		
		//=====================  webtoon  ===================//
		
		WebtoonDto webtoonDto = new WebtoonDto();
		webtoonDto.setStart(webtoonDto.getPg()*10);
		List<WebtoonDto> webtoonList = webtoonService.getRank(webtoonDto);
		
		System.out.println("[HomeController---------------]" + webtoonList);
		model.addAttribute("webtoonList", webtoonList);
		
		//=====================  animation  ===================//
		
		AnimationDto animationDto = new AnimationDto();
		animationDto.setStart(animationDto.getPg()*10);
		List<AnimationDto> aniList = animationService.getRank(animationDto);
		
		System.out.println("[HomeController---------------]" + animationDto);
		model.addAttribute("aniList", aniList);

		
		//=====================  Enter  ===================//
		
		EnterDto enterDto = new EnterDto();
		enterDto.setStart(enterDto.getPg()*10);
		List<EnterDto> enterList = enterService.getRank(enterDto);
		
		System.out.println("[HomeController---------------]" + enterDto);
		model.addAttribute("enterList", enterList);
		
		return "home";
	}
  
}

