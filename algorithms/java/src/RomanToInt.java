class RomanToInt {
    public int romanToInt(String s) {
        if ( s == null || s.length() ==0) {
            return 0;
        }
        HashMap<String,Integer> record = new HashMap<>();
        record.put("M",1000);
        record.put("CM",900);
        record.put("D",500);
        record.put("CD",400);
        record.put("C",100);
        record.put("XC",90);
        record.put("L",50);
        record.put("XL",40);
        record.put("X",10);
        record.put("IX",9);
        record.put("V",5);
        record.put("IV",4);
        record.put("I",1);
        
        int ans = 0;
        int i = 0;

        while (i < s.length()){
            if (i+1 < s.length() && record.containsKey(s.substring(i,i+2))){
                ans += record.get(s.substring(i,i+2));
                i+=2;
            } else {
                ans += record.get(s.substring(i,i+1));
                i++;
            }
        }
        
        return ans;
    }
}