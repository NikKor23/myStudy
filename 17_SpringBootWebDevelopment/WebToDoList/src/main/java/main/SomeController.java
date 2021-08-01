package main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class SomeController {

    @RequestMapping("/")
    public String index(){
        String str = "Всем ку. Вот дата: " + new SimpleDateFormat("dd.MM.yy HH:mm").format(new Date()) +
                "  А вот случайное число: " + (int) (Math.random() * 1000);
      return str;
    }

}
