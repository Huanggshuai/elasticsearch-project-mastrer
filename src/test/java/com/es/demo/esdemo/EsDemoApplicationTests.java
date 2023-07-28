package com.es.demo.esdemo;

import com.es.demo.esdemo.domain.User;
import com.es.demo.esdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootTest
class EsDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void save() {
        User user = new User();
        user.setId(3345);
        user.setName("张三");
        user.setType("1234");
        user.setDescription("123441");
        try {
            userService.save(user);
        } catch (Exception e) {
            if (!(e.getMessage().contains("200 OK"))) {
                System.out.println("error");
            }
            System.out.println("插入成功");
        }
    }

    @Test
    void getAll() {
        List<User> list = StreamSupport.stream(userService.findAll().spliterator(), false).collect(Collectors.toList());
        list.forEach(item -> System.err.println(item));
    }

    @Test
    void del() {
        try{
            userService.del(3345);
        }catch (Exception e){
            if (!(e.getMessage().contains("200 OK"))) {
                System.out.println(e.getMessage());
            }
        }
    }

//    @BeforeEach
//    void setUp() {
//        HttpHost host = HttpHost.create("http://localhost:9200");
//        RestClientBuilder builder = RestClient.builder(host);
//        client = new RestHighLevelClient(builder);
//    }
//
//    private RestHighLevelClient client;
//
//    @Test
//    void testCreateIndex() throws IOException {
//        CreateIndexRequest request = new CreateIndexRequest("book");
//        client.indices().create(request, RequestOptions.DEFAULT);
//    }
//
//    @AfterEach
//    void tearDown() throws IOException {
//        client.close();
//    }

}
