class IntToRoman {
    public String intToRoman(int num) {
        if ( num < 1 || num > 3999) {
            return null;
        }
        // 这里很容易携程 new int[13]{...},这样编译是通不过的
        int[] record = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] alph = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        int i=0;
        StringBuilder ans = new StringBuilder();
        while (num !=0){
            int div = record[i++];
            if (num/div !=0){
                int count = num/div;
                //这里很容易携程 for each的形式，记住只有完成了ITERABLE的接口的类才可以用
                while (count!=0){
                	count--;
                    ans.append(alph[i-1]);
                }
                num %=div;
            }
        }
        
        return ans.toString();
    }
}