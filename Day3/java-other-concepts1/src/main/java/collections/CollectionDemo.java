package collections;

import java.util.*;
import java.util.function.Consumer;

public class CollectionDemo
{
    public List<String> listDemo()
    {
        ArrayList<String> names=new ArrayList<>();
        names.add("abc");
        names.add("pqr");
        names.add("lmn");
        names.add("xyz");
        names.add("null");
        names.add("xyz");

        Consumer<String> cls=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("name is="+s);
            }
        }  ;
        names.forEach(cls);
        Consumer<String> fn=(String s) ->System.out.println(s);
        return names;
    }
   public Set<String> setDemo(){
       HashSet<String> set=new HashSet<>();
       set.add("abc");
       set.add("pqr");
       set.add("lmn");
       set.add("xyz");
       set.add("null");
       set.add("xyz");

   set.forEach((s) ->System.out.println(s));
   return set;
   }

   public Queue<String> queueDemo()
   {
       Queue<String> queue=new LinkedList<>();
       queue.add("abc");
       queue.add("pqr");
       queue.add("lmn");
       queue.add("xyz");
       queue.add("null");
       queue.add("xyz");

       queue.forEach(System.out::println);
       return queue;
   }


   public void mapDemo(){
        Map<Integer,String> map=new HashMap<Integer,String>();
        map.put(1,"abc");
       map.put(2,"pqr");
       map.put(3,"lmn");
       map.put(4,"xyz");

       Set<Integer> keys=map.keySet();
       keys.forEach(key ->System.out.println("key="+key));
       map.remove(1,"abc");

       System.out.println("2 available->"+map.containsKey(2));
       System.out.println("lmn available->"+map.containsValue("lmn"));
       System.out.println("element available->"+map.getOrDefault(3,"none"));
        map.forEach((k,v)->System.out.println("key="+k+"value="+v));
   }

    public static void main(String[] args)
    {
        CollectionDemo cdm=new CollectionDemo();
        System.out.println("-----listdemo-----");
        cdm.listDemo();
        System.out.println("-----queuedemo-----");
        cdm.queueDemo();
        System.out.println("-----setdemo-----");
        cdm.setDemo();
    }
}
