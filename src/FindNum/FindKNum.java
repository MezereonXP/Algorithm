package FindNum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/8.
 */
public class FindKNum {

    //找到k个频率最高的数
    public String find(String line){
        int k = Integer.parseInt(line.split(" ")[1]);
        String[] number = line.split(" ")[0].split(",");
        Map<Integer, Integer> map = new HashMap<>();
        for (String s:number){
            Integer i = Integer.parseInt(s);
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<k;i++){
            int max = 0;
            Integer maxKey = null;
            for (Integer key:map.keySet()){
                Integer integer = map.get(key);
                if (integer>max){
                    max = integer;
                    maxKey = key;
                }
            }
            map.remove(maxKey);
            list.add(maxKey);
        }
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
        for (int i=0;i<list.size()-1;i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i)>list.get(j)){
                    Integer t = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, t);
                }
            }
        }
        String result = "";
        for (int i=0;i<list.size();i++){
            if (i!=list.size()-1){
                result+= list.get(i)+",";
            } else {
                result+=list.get(i);
            }
        }
        return result;
    }
}
