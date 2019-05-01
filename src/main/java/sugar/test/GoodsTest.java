package sugar.test;
/*
 *@auther suger
 *2019
 *20:58
 */

import org.junit.Test;
import sugar.bean.Goods;
import sugar.service.goodsService;
import sugar.service.goodsServiceImpl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodsTest {

    @Test
    public void getInset(){
        Goods goods=new Goods();
//        测试数据
        Date date=new Date();
        String username="test1";
        String name="商品名称";
        String type="数码残品";
        BigDecimal bigDecimal=new BigDecimal("998.99");
        String detail="产品介绍";
        int sold=999;
        goods.setDate(date);
        goods.setUsername(username);
        goods.setDetail(detail);
        goods.setName(name);
        goods.setType(type);
        goods.setPrice(bigDecimal);
        goods.setSold(sold);
//        打印时间
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(format.format(date));
        goodsService goodsService=new goodsServiceImpl();
        goodsService.addGoods(goods);
    }
}
