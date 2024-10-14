package com.dosol.todocore.service;

import com.dosol.todocore.dto.TodoDTO;
import com.dosol.todocore.mapper.TodoMapper;
import com.dosol.todocore.vo.TodoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;
    //Auto로 받는게 setter

    @Override
    public void register(TodoDTO todoDTO) {
        log.info("service register"+todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class); //DTO를 VO로 맵핑해서 돌려줌
        log.info(todoVO);
        todoMapper.insert(todoVO); //mapper에 DTO라서 빨간줄. 수정하면 고쳐짐
    }

    @Override
    public List<TodoDTO> getAll() {
        log.info("service getAll");
        //return todoMapper.getList(); - vo로 고치는게 없었다면 이렇게 쓰면 된다.
        List<TodoDTO> dtoList = todoMapper.getList().stream()
                .map(vo->modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toUnmodifiableList());
        return dtoList;
    }

    @Override
    public TodoDTO getOne(int tno) {
        log.info("service getOne");
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        log.info("service remove");
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }
}
