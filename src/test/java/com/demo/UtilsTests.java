package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @Author :
 * @Date : created in
 * @Description :
 */

@SpringBootTest
public class UtilsTests {

    @Test
    public void doTest() {
        Info info = new Info();
        info.setTitle("title");

        Optional<Info> optional = Optional.of(info);
        System.out.println(optional.isPresent());


    }
}

class Info {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
