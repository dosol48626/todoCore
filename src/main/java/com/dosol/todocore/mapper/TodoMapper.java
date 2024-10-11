package com.dosol.todocore.mapper;

import com.dosol.todocore.dto.TodoDTO;
import com.dosol.todocore.vo.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVO);
    List<TodoVO> getList();
}
