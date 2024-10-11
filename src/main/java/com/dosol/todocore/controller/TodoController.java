package com.dosol.todocore.controller;

import com.dosol.todocore.dto.TodoDTO;
import com.dosol.todocore.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
//    @Autowired
    private final TodoService todoService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list"); //  todo/list
        List<TodoDTO> todoList = todoService.getAll();
        model.addAttribute("todoList", todoList);
    }
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register.......");
    }
    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO, RedirectAttributes redirectAttributes) {
        log.info("POST todo register.......");
        log.info(todoDTO);

        todoService.register(todoDTO);

        redirectAttributes.addFlashAttribute("Message", "등록완료!");

        return "redirect:/todo/list";
    }
}
