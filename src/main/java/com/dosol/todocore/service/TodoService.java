package com.dosol.todocore.service;

import com.dosol.todocore.dto.PageRequestDTO;
import com.dosol.todocore.dto.PageResponseDTO;
import com.dosol.todocore.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);
    List<TodoDTO> getAll();
    TodoDTO getOne(int tno);
    void remove(Long tno);
    void modify(TodoDTO todoDTO);

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
