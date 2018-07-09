class LongestPalindrome{
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;       
        }
        
        String ans = "";
        int maxLength =0;
        for ( int i = 0 ;i< s.length();i++){
            int start = i;
            int end = i;
            while(start >=0 && end <s.length() && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }
            if (end-start-1 >maxLength) {
                //substring 而不是subString
                ans = s.substring(start+1, end);
                // 最容易被遗忘的部分，比较操作更新，更新的操作不要忘记了，不只是游标，也是原来的基准也要更新
                maxLength = end-start-1;
            }
        }
        
        for (int i=0 ; i+1<s.length(); i++){
                int start = i;
                int end = i+1;
                while(start >=0 && end <s.length() && s.charAt(start) == s.charAt(end)){
                    start--;
                    end++;
                }
                if (end-start-1 >maxLength) {
                    ans = s.substring(start+1, end);
                    maxLength = end-start-1;
                }
        }
        return ans;
    }
}