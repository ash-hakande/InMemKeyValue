package com.company;

import com.company.Models.Pair;
import com.company.Services.KeyValueService;
import com.company.Services.KeyValueServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        KeyValueService service = new KeyValueServiceImpl();

        service.get("ash");
        List<Pair<String, String>> list = new ArrayList<>();
        list.add(new Pair<>("a", "1"));
        list.add(new Pair<>("b", "2"));
        list.add(new Pair<>("c", "3"));
        service.put("ash", list);
        service.put("rish", list);
        //list.remove(0);
        service.put("din", list);
        System.out.println("Keys:" + service.keys());

        service.delete("din");
        System.out.println("Keys:" + service.keys());

        System.out.println("Searching for attribute:"+service.search("a", "1"));



    }
}
