package com.in28minutes.test.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    /**
     * Filter only "field1","field2"
     * @return MappingJacksonValue
     */
    @GetMapping("/filtering")
    public MappingJacksonValue retieveSomeBean()
    {
        SomeBean someBean =  new SomeBean("value1","value2","value3");

        MappingJacksonValue mapping = getMappingJacksonValue(someBean,"field1","field2");
        return mapping;
    }

    /**
     * Filter only "field2","field3"
     * @return MappingJacksonValue
     */
    @GetMapping("/filtering-list")
    public MappingJacksonValue retieveListSomeBean()
    {
        List<SomeBean> list = Arrays.asList(
                new SomeBean("value1","value2","value3"),
                new SomeBean("value1","value2","value3"));
        MappingJacksonValue mapping = getMappingJacksonValue(list,"field2","field3");
        return mapping;
    }

    @NotNull
    private MappingJacksonValue getMappingJacksonValue(Object list,String... propertyArray) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept(propertyArray);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);
        return mapping;
    }


}
