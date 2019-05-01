package sugar.test;
/*
 *@auther suger
 *2019
 *0:30
 */

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class userTest {
    @Test
    public void testJSON(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("key1","value1");
        jsonObject.put("key2","value2");
        System.out.println(jsonObject.toJSONString());
    }
}
