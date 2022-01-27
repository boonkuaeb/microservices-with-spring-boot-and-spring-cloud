package com.in28minutes.test.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retieveSomeBean()
    {
        return new SomeBean("value1","value2","value3");
    }
    @GetMapping("/filtering-list")
    public List<SomeBean> retieveListSomeBean()
    {
        return Arrays.asList(
                new SomeBean("value1","value2","value3"),
                new SomeBean("value1","value2","value3")
        );
    }
}