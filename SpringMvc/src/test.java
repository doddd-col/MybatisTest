import java.util.ArrayList;
import java.util.HashMap;

public class test {

    public static int lengthOfLongestSubstring(String s) {

        //将字符 转成 字符串
            char[] chars=s.toCharArray();
            int  size,i=0,j,k,max=0;
            size=chars.length;
            for(j = 0;j<size;j++){
                for(k = i;k<j;k++)
                    if(chars[j]==chars[k]){//第一个固定为i=1
                        //i为碰到相同字符时 上一个子串长度
                        i = k+1;
                        break;
                    }
                if(j-i+1 > max)
                    max = j-i+1;
            }
            return max;

    }
    public static void main(String[] args) {
        String s="pwwvd";
        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println(s);
    }
}
