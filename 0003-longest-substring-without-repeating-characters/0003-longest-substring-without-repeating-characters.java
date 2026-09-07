class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0;
        int res = 0;
        
        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
           
            if (map.containsKey(ch)) {
                low = Math.max(low, map.get(ch) + 1);
            }
            
            map.put(ch, high); 
            res = Math.max(res, high - low + 1);
        }
        return res;
    }
}