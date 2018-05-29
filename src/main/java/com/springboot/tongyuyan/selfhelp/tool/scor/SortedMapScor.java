package com.springboot.tongyuyan.selfhelp.tool.scor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class SortedMapScor {

    public static SortedMap  SortedMap( SortedMap<Object,Object> sort){

        Set es = sort.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext())
        {
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("排序之后:"+entry.getKey()+" 值"+entry.getValue());
        }
        return sort;
}


}
