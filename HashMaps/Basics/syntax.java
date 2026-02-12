package HashMaps.Basics;

import java.util.HashMap;

public class syntax {
  public static void main(String[] args) {
     HashMap<String,Integer> map = new HashMap<>();
     map.put("India",91);
     System.out.println(map.get("India"));
     map.remove("India");
     System.out.println(map.size());
     System.out.println(map.containsKey("India"));
  }   
}
