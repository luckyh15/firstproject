package com.semi.flix.admin.board;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface AdminBoardDao {
	AdminBoardDto search (AdminBoardDto dto);
}
