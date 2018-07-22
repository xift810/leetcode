//这道题目有多种方法来做
//但是best practise 还是trie tree
//可以参考 208

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length ==0){
            return "";
        }
        String record = "";
        int minLength = Integer.MAX_VALUE;
        for ( String str :strs){
            if (minLength > str.length()){
                minLength = str.length();
                record = str;
            }
        }
        
        int i =0;
        while (i< record.length()){
            char c = record.charAt(i);
            boolean match = true;
            for (String str:strs){
                if (str.charAt(i)!=c){
                    match = false;
                    break;
                }
            }
            if(!match){
                break;
            }
            i++;
        }
        
        if (i ==0 ||record.equals("") ){
            return "";
        }
        return record.substring(0,i);
    }
}