package sugar.controller;
/*
 *@auther suger
 *2019
 *21:29
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sugar.bean.Goods;
import sugar.bean.User;
import sugar.service.goodsService;
import sugar.tools.assist.getNowDate;
import sugar.tools.assist.randomString;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("goods")
public class goodsController {
    //状态码
    private final String SUCCESS = "1";
    private final String fail = "0";

    @Autowired
    private goodsService goodsService;

    /**
     * 发布新的商品
     * @param goods
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "good",method = RequestMethod.PUT)
    public String pubNewgoods(@RequestBody Goods goods, HttpSession session){
        JSONObject jsonObject=new JSONObject();
        User user = (User) session.getAttribute("tUser");
        goods.setUsername(user.getUsername());

        System.out.println(goods);
        goodsService.addGoods(goods);
        session.removeAttribute("images");
        return SUCCESS;
    }


    /**
     * 商家获取发布的商品
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "good" ,method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getGoodsList(HttpSession session){
        User user= (User) session.getAttribute("tUser");
        if (user==null)
            return fail;
        List<Goods> goods = goodsService.selectGoods(user.getUsername());
        JSONArray jsonArray=new JSONArray();
        for (Goods key:goods
             ) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("id",key.getId());
            jsonObject.put("price",key.getPrice());
            jsonObject.put("images",key.getImages());
            jsonObject.put("name",key.getName());
            jsonObject.put("sold",key.getSold()==null?0:key.getSold());
            jsonObject.put("type",key.getType());
            jsonObject.put("version",key.getVersion());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();

    }

    @ResponseBody
    @RequestMapping(value = "goods",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getGoodsList(@RequestParam("mode") String mode, @RequestParam("content") String content){
        //mode (home/search)
        List<Goods> goods=null;
        if(mode.equals("home")){
            goods = goodsService.getGoods("$home");
        }else {
            goods=goodsService.getGoods(content);
        }
        JSONArray jsonArray=new JSONArray();
        if(goods!=null)
        for (Goods key:goods
        ) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("id",key.getId());
            jsonObject.put("price",key.getPrice());
            jsonObject.put("images",key.getImages());
            jsonObject.put("name",key.getName());
            jsonObject.put("sold",key.getSold()==null?0:key.getSold());
            jsonObject.put("type",key.getType());
            jsonObject.put("version",key.getVersion());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }

    /**
     * 保存图片png/jpg
     * @param request
     * @return
     */
    @RequestMapping(value = "image", method = RequestMethod.POST)
    @ResponseBody
    public String saveimgUrls(HttpServletRequest request){
        //获取项目根目录
        String rootPath = System.getProperty("crossborder");
        //获取文件流
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = req.getFile("file");
        //获取保存文件的路径
        String realPath = rootPath + "upload/images";
        //获取原文件名
        String originalFilename=multipartFile.getOriginalFilename();
        System.out.println(originalFilename);
        //获取原文件类型
        String contentType = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println(contentType);
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //生成随机文件名
            String filename = randomString.getRandomString(20) + getNowDate.Date();
            filename+=contentType;

            File file = new File(realPath, filename);
            multipartFile.transferTo(file);//写出文件

            return "upload/images/"+filename;//返回给前端

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return fail;
    }

}
