//这里有两个方法，第二个是参考java Integer.parseInt来写的
//可以看到的可见好处有：
//1 增加了limit变量，不要long来参与运算，防止溢出
//2 limit 在 循环中，每次运行前都进行比较，可以去掉很多容易比较溢出代码
class MyAtoi {
    public int myAtoi(String str) {
        if (str == null || str.length() ==0){
            return 0;
        }
        str = str.trim();
        boolean negative = false;
        long ans = 0;
        boolean hasNumber = false;
        for (int i=0 ;i < str.length();i++){
            char curC = str.charAt(i);
            if (i==0 && (curC =='+' || curC == '-')){
                if (curC == '-'){
                    negative = true;
                }
                if (str.length()==1){
                    return 0;
                }
                char nextC = str.charAt(i+1);
                //当每次使用新的变量的时候，很容易把新变量和老变量没成搞混，要注意
                if (nextC >'9' || nextC <'0'){
                    return 0;
                }
            } else {
                if (curC >'9' || curC <'0') {
                    if (hasNumber){
                        break;
                    } else {
                        return 0;
                    }
                } else {
                    hasNumber = true;
                    ans = ans *10 -(curC -'0');
                    if ( ans < Integer.MIN_VALUE){
                        return negative ? Integer.MIN_VALUE: Integer.MAX_VALUE;
                    }
                }
                
            } 
        }
        ans = negative ? ans : -ans;
        if ( ans > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if ( ans < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int)ans;
    }

    public int myAtoi2(String str) {
        if (str == null || str.length() ==0){
            return 0;
        }
        str = str.trim();
        boolean negative = false;
        int ans = 0;
        boolean hasNumber = false;
        int limit = -Integer.MAX_VALUE;
        int i =0;
        int len = str.length();

        char firstChar = str.charAt(0);


        if  (firstChar  =='+' || firstChar  == '-'){
            if (firstChar  == '-'){
                negative = true;
                limit = Integer.MIN_VALUE;
            } 
            if (str.length()==1){
                return 0;
            }
            i++;
        }

        while ( i < len){      
            char curC = str.charAt(i++);
            if (curC >'9' || curC <'0') {
                if (hasNumber){
                    break;
                } else {
                    return 0;
                }
            } else {
                hasNumber = true;
                if (ans < limit/10){
                    return negative ? Integer.MIN_VALUE: Integer.MAX_VALUE;
                }
                ans *=10;
                if (ans < limit+(curC -'0')){
                    return negative ? Integer.MIN_VALUE: Integer.MAX_VALUE;
                }
                ans -= (curC -'0');
            }
            
        }
        return negative ? ans : -ans;

    }
}