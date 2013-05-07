package com.lady.tools;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapUtil
{
    public static Map<String, Number>
            sortByValue( Map<String, Number> map )
    {
        List<Map.Entry<String, Number>> list =
                new LinkedList<Map.Entry<String, Number>>( map.entrySet() );
        Collections.sort( list, new Comparator<Map.Entry<String, Number>>()
        {
            public int compare( Map.Entry<String, Number> o1, Map.Entry<String, Number> o2 )
            {
                return ( (Integer) o1.getValue() ).compareTo( (Integer) o2.getValue() );
            }
        } );

        Map<String, Number> result = new LinkedHashMap<String, Number>();
        for ( Map.Entry<String, Number> entry : list )
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }
}