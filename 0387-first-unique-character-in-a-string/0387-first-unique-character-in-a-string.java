import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            hm.put(ch[i], hm.getOrDefault(ch[i], 0) + 1);
        }
        for (int i = 0; i < ch.length; i++) {
            if (hm.get(ch[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}