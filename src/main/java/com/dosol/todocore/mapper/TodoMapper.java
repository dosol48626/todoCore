package com.dosol.todocore.mapper;

import com.dosol.todocore.dto.PageRequestDTO;
import com.dosol.todocore.dto.PageResponseDTO;
import com.dosol.todocore.dto.TodoDTO;
import com.dosol.todocore.vo.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVO);
    List<TodoVO> getList();
    TodoVO selectOne(int tno);
    void delete(Long tno);
    void update(TodoVO todoVO);

    int getCount(PageRequestDTO pageRequestDTO);
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

}
