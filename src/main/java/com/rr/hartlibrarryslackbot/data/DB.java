package com.rr.hartlibrarryslackbot.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Rewati Raman(rewati.raman@gmail.com).
 */
public abstract class DB<T extends InMemoDbObject> {

    private Map<String,T> map = new HashMap<String, T>();
    private ObjectMapper mapper = new ObjectMapper();

    public DB(String location) throws IOException {
        List<String> list = new ArrayList<>();
        String path = location+"/"+getEntityClass().toString().replaceAll(" ",".")+".db";
        try (Stream<String> streams = Files.lines(Paths.get(path))) {
            list = streams
                    .collect(Collectors.toList());
        }
        for (String s: list) {
            try {
                T b = mapper.readValue(s, getEntityClass());
                map.put(b.getId(),b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public List<T> getList(){
        List<T> list = new ArrayList<>();
        for (String id: map.keySet()) {
            list.add(map.get(id));
        }
        return list;
    }

    public void insert(T object) {
        map.put(object.getId(),object);
    }

    public T search(String id) {
        return map.get(id);
    }

    public Class<T> getEntityClass() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }
}
