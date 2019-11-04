package com.boot.demo.controller;

import com.boot.demo.entity.Book;
import com.boot.demo.entity.User;
import com.boot.demo.services.BookRepository;
import com.boot.demo.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("demo")
public class HelloWorldController {


    @RequestMapping("/hello")
    public String helloWorld() {
        return "HelloWorld";
    }


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/getRedis")
    public String getRedis() {
        User user = (User) redisService.get("user");
        return "user" + user.toString();
    }

    /**
     * http://localhost:8081/demo/setRedis?id=123&userName=Heel&passWord=123
     */
    @RequestMapping("/setRedis")
    public String setRedis(int id, String userName, String passWord) {
        User user = new User(id, userName, passWord);
        redisService.set("user" + "", user);
        redisService.set("test", "hello world");
        return "success";
    }

    @RequestMapping("/getES")
    public String getES() {
        List<Book> list = bookRepository.findByAuthorLike("明");
        for (Book book : list) {
            System.out.println(book);
        }

        return list.toString();
    }

    @RequestMapping("/insertES")
    public String insertES() {
        Book book = new Book();
        book.setAuthor("小明");
        book.setId(2);
        book.setBookName("你不知道的我");
        bookRepository.index(book);
        return "OK";
    }
}
