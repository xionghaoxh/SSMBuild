package xh.utils;

public class GetNowData {
    public static void main(String[] args) {

        System.out.println( getData());
    }
    public static int getData(){
        long nowTime = System.currentTimeMillis()/1000;
        Integer nowTimeInt = new Long(nowTime).intValue();
        return nowTimeInt;
    }
}
