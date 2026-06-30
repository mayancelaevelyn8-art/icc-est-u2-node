package collections.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import models.Contacto;


public class Maps {
    //Map<K, V>
    //Map<tipoClave, tipoValor>
    //Map<String, Integer>

    public Map<String, Integer> construriHasMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("A", 50);
        System.out.println(map.size());
        System.out.println(map);
        System.out.println(map.values().toArray());

        //Map-> V -> Valores -> Array -> Array[pos]
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.values().toArray()[i]);
        }//50, 20, 30


        //Map-> K -> Keys -> Set -> Valor del Set
        for (String Key : map.keySet()) {
            System.out.println(Key);  
        }//A, B, C

        //T-. Entry<K,V>
        //T-. Entry<S,I>
        //Set<Entry<S,I>>
        //Set<T>
       
       for(Map.Entry<String, Integer> entry : map.entrySet())
        System.out.println(entry);
        return map;    

    }

    public LinkedHashMap<String, Integer> coLinkedHashMap(){
        LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
        lMap.put("A", 2);
        lMap.put("B", 3);
        lMap.put("A", 5);
        lMap.put("C", 50);
        lMap.put("D", 5);
        lMap.put("F", 3);
        lMap.put("G", 8);
        lMap.put("H", 85);
        lMap.put("I", 5);
        System.out.println(lMap);

        return lMap;
    }

    public Map<String, Integer> cTreeMap(){
        LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
        lMap.put("A", 2);
        lMap.put("B", 3);
        lMap.put("A", 5);
        lMap.put("C", 50);
        lMap.put("D", 5);
        lMap.put("F", 3);
        lMap.put("G", 8);
        lMap.put("H", 85);
        lMap.put("I", 5);
        System.out.println(lMap);

        return lMap;
    }
    public void eliminarDuplicadosAndSort(List<Contacto> contactos){
        Set<Contacto> tSet = new TreeSet<>();
        for(Contacto contacto : contactos){
            tSet.add(contacto);
        }
    }
}