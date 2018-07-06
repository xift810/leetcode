


import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException("No String");
        }
        
        int ans = 0;
        int currentLength = 0;
        //startpoint是容易被遗忘的一部分，因为使用的是map，所以对于过期的重复字符怎么判断需要有个基准。
        //如果使用array，就不需要使用这个方式了
        int startIndex = 0;
        HashMap<Character,Integer> record = new HashMap<>();
        for (int i =0 ; i< s.length() ; i++){
            char currentChar = s.charAt(i);
            if (!record.containsKey(currentChar)) {
                currentLength++;
            } else {
                int oldIndex = record.get(currentChar);
                // 基准的判断，过期字符不影响目前的长度
                if (oldIndex < startIndex) {
                    currentLength++;
                } else{
                    currentLength = i-oldIndex;
                    //一旦有更新字符，基准字符也要更新
                    startIndex = oldIndex+1;
                }
            }
            record.put(currentChar,i);
            if (currentLength > ans){
                ans = currentLength;
            }
        }
        
        return ans;
    }
}