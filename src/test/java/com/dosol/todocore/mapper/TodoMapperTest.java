package com.dosol.todocore.mapper;

import com.dosol.todocore.dto.TodoDTO;
import com.dosol.todocore.service.TodoService;
import com.dosol.todocore.vo.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false) //todoMapper가 인터페이스라서 false 적어줘야한다고 함
    private TodoMapper todoMapper;

    @Autowired(required = false)
    private TodoService todoService;

    @Test
    public void testGetTime(){
//        log.info(todoMapper);
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert() throws Exception{
        TodoDTO dto = new TodoDTO();
        dto.setTitle("22");
        dto.setWriter("dosol");
        dto.setDueDate(LocalDate.parse("2024-10-13")); //now??
        //todoService.register(dto);
        //todoMapper.insert(dto);
    }
}

