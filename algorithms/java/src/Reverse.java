//这道题目可以算作 data type相关的基础了
// 并且完成了3个思路的做法

class Reverse{
    //第一个做法，饶了圈子，但是对于数据的转换和截断有参考意义
    public static int reverse(int x) {
        Boolean minus = x < 0?true:false;
            // 不需要特意long后面加L
           long record = 0L;
           long times =1;
           
           // 算最初的times，不需要把x减到最低
           while (x/times !=0){
               times*=10;
           }
           
           long curX = minus ? -x:x;
           times/=10;
           //这里最容易忘记的是 要把每次times都变小，然后pop变大。
           int n =1;
     
           while(times !=0){
               //long和int之间互相加减，只会往最大的转换（long）。
               //因为特意往小的转换，可能会有数据丢失。所以才会有cast。
               //cast只会把数据从大往小转换，才要多考虑。
               record +=  curX/times*n;
               curX %= times;
               times /= 10;
               n*=10;
               
           }
           
           record = minus ? -record : record;
           record = record > Integer.MAX_VALUE|| record < Integer.MIN_VALUE ? 0 :record;
           return (int)record;
       }
       
       //这是真正简单好的答案，考虑答案中不需要用到long。并且pop和push的点也是按照正确的逻辑来
       public int reverse2(int x) {
           int ans = 0;
           while (x!=0){
               int pop = x%10;
               x/=10;
               if (ans> Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && pop > 7) ){
                   return 0;
               }
               if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)){
                   return 0;
               }
               
               ans = ans*10 +pop;
           }
       return ans;
   }
       
       //所以刚刚开始的问题，都考虑是否可以用原有library的函数去完成
       public int reverse3(int x) {
           if(x ==Integer.MIN_VALUE){
               return 0;
           }
           boolean plus = x>0 ?true:false;
           x = plus ? x:-x;
           //reverse只有StringBuilder才有，所以从String的角度去考虑。
           //负数就需要优先处理
           
           String record = new StringBuilder((Integer.toString(x))).reverse().toString();
           // 考虑越界的问题
           Long testAns = Long.parseLong(record);
           if (testAns > Integer.MAX_VALUE || testAns < Integer.MIN_VALUE){
               return 0;
           }
           x = Integer.parseInt(record);
           x = plus? x:-x;
           return x;
         }
}