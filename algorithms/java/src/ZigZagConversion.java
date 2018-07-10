
//题目的思路还是需要自己重新思考
class ZigZagConversion {
    public String convert(String s, int numRows) {
        if ( s == null || s.length() == 0 || numRows ==1){
            return s;
        }
        
        //用ArrayList因为不清楚会有多少row
        ArrayList<StringBuilder> rows = new ArrayList<>();
        // 确定有多少row
        for ( int i= 0; i< Math.min(numRows, s.length());i++){
            rows.add(new StringBuilder());
        }
        
        // 这个是关键，从字面的意思来想到代码的逻辑需要有个方向
        Boolean goingDown = false;
        int curRow = 0;
        
        // toCharArray() 这个方法需要多次使用
        for (char c: s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1){
                goingDown = !goingDown;
            }
            //方向的意义就在这里，可以确定了row是增加还是减少
            curRow+=goingDown? 1:-1;
        }
        
        StringBuilder ans = new StringBuilder();
        for(StringBuilder row: rows){
            ans.append(row);
        }
        return ans.toString();
    }
}