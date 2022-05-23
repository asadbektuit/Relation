package com.example.relation.controller;


import com.example.relation.dto.BookDto;
import com.example.relation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable ("id") Integer id){
        BookDto result = bookService.get(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid BookDto bookDto){
        BookDto result = bookService.create(bookDto);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") Integer id,@RequestBody @Valid BookDto bookDto){
        BookDto result = bookService.update(id,bookDto);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id")Integer id){
        BookDto result = bookService.delete(id);
        return ResponseEntity.ok(result);
    }

}
