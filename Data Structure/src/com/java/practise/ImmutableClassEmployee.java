package com.java.practise;

import java.util.HashMap;
import java.util.Map;

final class ImmutableClassEmployee {

    private final Integer id;
    private final String name;
    private final Map<String,String> metaData;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ImmutableClassEmployee(Integer id, String name, Map<String, String> address){
        this.id = id;
        this.name = name;
        HashMap<String,String> tempMap = new HashMap<>();
        for(Map.Entry<String,String> entry : address.entrySet()){
            tempMap.put(entry.getKey(),entry.getValue());
        }
        this.metaData = tempMap;
    }

    public Map<String,String> getMetadata(){
        HashMap<String,String> tempMap = new HashMap<>();
        for(Map.Entry<String,String> entry : this.metaData.entrySet()){
            tempMap.put(entry.getKey(),entry.getValue());
        }
        return tempMap;
    }


}
