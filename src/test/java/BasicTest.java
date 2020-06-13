import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicTest {

    /**
     * Java编程思想
     */

    @Test
    public void helloTest() {
        System.out.println("hello");
        System.out.println(new Date());
        Properties p = System.getProperties();
        p.list(System.out);

        System.out.println("--- Memory Usage:");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total Memory = "+ rt.totalMemory() / 1024 /1024 + " Free Memory = " + rt.freeMemory()/ 1024 /1024);

        int[] a1 = { 1, 2, 3, 4, 5 };

    }

    @Test
    public void regExpTest() {
        String str = "成都市(成华区)(武侯区)(高新区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
        Integer a = 1;
    }


    @Test
    public void translate() {
        String tempStr = "";
        String str = "JSHDSS";
        try {
            tempStr = new String(str.getBytes("ISO-8859-1"), "GBK");
            tempStr = tempStr.trim();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.err.println(tempStr);
    }

    @Test
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> numToIndice = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndice.put(nums[i], i);
        }
        for (int j = 0;j < nums.length; j++) {
            if (numToIndice.containsKey(target - nums[j])) {
                res[0] = j;
                res[1] = numToIndice.get(target - nums[j]);
            }
        }

        return res;
    }



/**
    @Test
    public void XXX() {

    }
 */

}
