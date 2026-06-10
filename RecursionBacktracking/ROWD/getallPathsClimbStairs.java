import java.util.*;
public class getallPathsClimbStairs{
    public static List<String> getPaths(int n){
        if(n==0){
            List<String> bArr = new ArrayList<>();
            bArr.add("");
            return bArr;
        }
        if(n<0){
            List<String> bArr = new ArrayList<>();
            return bArr;
        }
        List<String> after1path = getPaths(n-1);
        List<String> after2path = getPaths(n-2);
        List<String> after3path = getPaths(n-3);
        List<String> res = new ArrayList<>();
        for(String e:after1path){
            res.add("1"+e);
        }
        for(String e:after2path){
            res.add("2"+e);
        }
        for(String e:after3path){
            res.add("3"+e);
        }
        return res;
    }
    public static void main(String[] args){
            System.out.println(getPaths(3));
            //[111, 12, 21, 3]
            System.out.println(getPaths(4));
            //[1111, 112, 121, 13, 211, 22, 31]
    }
}