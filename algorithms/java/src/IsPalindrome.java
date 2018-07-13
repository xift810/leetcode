class IsPalindrome{
    public boolean isPalindrome(int x) {
        String record = Integer.toString(x);
        int start = 0;
        int end = record.length()-1;
        
        while (start < end){
            if (record.charAt(start++)!=record.charAt(end--)){
                return false;
            }
            
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x<0) {
            return false;
        }
       int times = 1;
       while (x/times >=10){
           times*=10;
       }

        //这部分是很容易出错的点，在于times因为多*了一位，所以很可能溢出。
        // int times = 10;
        // while (x/times !=0){
        //     times*=10;
        // }
        // times/=10;
        System.out.println(times);
        while (times>=10){
            int firstC = x/times;
            int lastC = x%10;
            if (firstC !=lastC){
                return false;
            }
            x = x%times/10;
            System.out.println(x+"times: "+times);
            times/=100;
            
        }
        return true;
    }
}

