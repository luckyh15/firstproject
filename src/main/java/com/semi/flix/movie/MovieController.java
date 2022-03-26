package com.semi.flix.movie;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.semi.flix.comment.CommentDto;

@Controller
public class MovieController {
	@Resource(name = "movieService")
	MovieService service;

	@RequestMapping("/movie/list")
	String movie_list(Model model, MovieDto dto) {

		dto.setPageSize(12);
		dto.setStart(dto.getPg() * dto.getPageSize());

		List<MovieDto> list = service.getList(dto);
		int cnt = service.getTotal(dto);

		model.addAttribute("movieList", list);
		model.addAttribute("totalCnt", cnt);

		return "movie/movie_list";
	}

	@RequestMapping("/movie/view")
	String webtoon_view(MovieDto dto,CommentDto Cdto, Model model) {

		Cdto.setPageSize(4);
		Cdto.setStart(Cdto.getPg() * Cdto.getPageSize());
		
		List<CommentDto> list = service.commentList(Cdto);
		MovieDto resultDto = service.getView(dto);
		int commentCnt = service.commentTotal(Cdto);
		model.addAttribute("movieDTO", resultDto);
		model.addAttribute("commentList", list);
		model.addAttribute("commentTotalCnt", commentCnt);
		return "movie/movie_view";
	}

}
