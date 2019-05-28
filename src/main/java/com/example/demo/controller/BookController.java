package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.common.ResponseHelper;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class.getName());

    @Autowired
    BookService bookService;

    /**
     * 查询全部
     * @return
     * {
     *       "_id": "5ce78d65865a000084005c90",
     *       "bname": "大数据",
     *       "price": 58,
     *       "author": "John"
     *     },
     */
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/queryAll")
    @ResponseBody//@responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
    public Response<List<Book>> queryAllBooks(){
        LOGGER.info("查询书库列表");
        Response response = new Response();
        List<Book> list = new ArrayList<>();
        try {
            list = bookService.getBookList();
//            LOGGER.info(list.toString());
            response.setCode(200);
            response.setPayload(list);
        }catch (Exception e){
            response.setCode(500);
            response.setDescription("查询书库列表失败");
            LOGGER.error("查询失败",e);
        }
        return ResponseHelper.createSuccessResponse(list);
    }

    @RequestMapping("/showAll")
    public String showAll(){
        return "bookList";
    }


    @RequestMapping("/insertOne")
    public String insertOne(){
        return "insertForm";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Response<String> saveBook(Book book){
        LOGGER.info("插入一条图书信息");
        Response response = new Response();
        String msg = "";
        try{
            msg = bookService.saveBook(book);
            response.setCode(200);
            response.setPayload(msg);
        }catch (Exception e){
            response.setCode(500);
            response.setDescription("插入数据失败");
            LOGGER.error("插入失败",e);
        }
        return ResponseHelper.createSuccessResponse(msg);
    }
}
