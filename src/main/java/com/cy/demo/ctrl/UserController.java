package com.cy.demo.ctrl;

import com.cy.demo.base.Constant;
import com.cy.demo.dto.RestResponse;
import com.cy.demo.dto.power.LoginDto;
import com.cy.demo.dto.power.ModifyPassword;
import com.cy.demo.dto.power.UserPositionDto;
import com.cy.demo.dto.power.UserRegisterDto;
import com.cy.demo.service.IUserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by zhoudachao on 2019/4/23.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static String seperator = System.getProperty("file.separator");
    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "用户注册")
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public RestResponse register(@RequestBody UserRegisterDto userRegisterDto){
        System.out.println(userRegisterDto.getImg());
        return iUserService.register(userRegisterDto);
    }
    @ApiOperation(value = "用户登录")
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RestResponse login(@RequestBody LoginDto loginDto){
        //iUserService.login(loginDto);
        return iUserService.login(loginDto);
    }

    @ApiOperation(value = "修改密码")
    @ResponseBody
    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST)
    public RestResponse modifyPassword(@RequestBody ModifyPassword modifyPassword){

        return iUserService.updatePass(modifyPassword);
    }

    @ApiOperation(value = "保存登录用户当前位置")
    @ResponseBody
    @RequestMapping(value = "/saveLocation",method = RequestMethod.POST)
    public RestResponse saveLocation(@RequestBody UserPositionDto userPositionDto){

        return iUserService.saveLocation(userPositionDto);
    }

    @ApiOperation(value = "获得登录用户当前位置")
    @ResponseBody
    @RequestMapping(value = "/getLocation",method = RequestMethod.POST)
    public RestResponse getLocation(){

        return iUserService.getLocation();
    }

    @ApiOperation(value = "获得用户当前管理队伍")
    @ResponseBody
    @RequestMapping(value = "/currentManageTeam",method = RequestMethod.POST)
    public RestResponse currentManageTeam(){

        return iUserService.currentManageTeam();
    }


    @ApiOperation(value = "获得用户当前所属队伍")
    @ResponseBody
    @RequestMapping(value = "/currentTeam",method = RequestMethod.POST)
    public RestResponse currentTeam(){

        return iUserService.currentTeam();
    }

    @ApiOperation(value = "获得用户历史所属队伍")
    @ResponseBody
    @RequestMapping(value = "/historyTeam",method = RequestMethod.POST)
    public RestResponse historyTeam(){

        return iUserService.historyTeam();
    }

    /*@ApiOperation(value = "图片上传")
    @ResponseBody
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    public RestResponse uploadImg(){

        return iUserService.historyTeam();
    }*/

    //获取当前日期时间的string类型用于文件名防重复
    public String dates(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    @ApiOperation(value = "图片上传")
    @ResponseBody
    @RequestMapping("/uploadImg")
    public RestResponse uploadPicture(HttpServletRequest request) throws Exception {
        System.out.println("进入get方法！");
        //获取从前台传过来得图片
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile = req.getFile("file");
        //获取图片的文件类型
        String houzhu=multipartFile.getContentType();
        int one = houzhu.lastIndexOf("/");
        System.out.println(houzhu.substring((one+1),houzhu.length()));
        System.out.println(multipartFile.getName());
        //根据获取到的文件类型截取出图片后缀
        String type=houzhu.substring((one+1),houzhu.length());
        System.out.println(multipartFile.getContentType());

        String realPath = "";

        String os = System.getProperty("os.name");
        //String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            //   basePath = "E:/electronicImages/image/";
            //basePath="E:/soft/nginx-1.15.2/html/xgdesign/WebsiteHome/";
            realPath="E:/soft/nginx-1.15.2/html/upload/wximg/";
        }else {
            realPath = "/home/dachao/image/";
        }
        realPath = realPath.replace("/",seperator);


        String filename;
        // request.getRealPath获取我们项目的根地址在加上我们要保存的地址
        //String realPath = request.getRealPath("E:/soft/nginx-1.15.2/html/upload/wximg/");
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //获取到当前的日期时间用户生成文件名防止文件名重复
            String filedata=this.dates();
            //生成一个随机数来防止文件名重复
            int x=(int)(Math.random()*1000);
            filename="zhongshang"+x+filedata;
            System.out.println(x);
            //将文件的地址和生成的文件名拼在一起
            File file = new File(realPath,filename+"."+type);
            multipartFile.transferTo(file);
            //将图片在项目中的地址和isok状态储存为json格式返回给前台，由于公司项目中没有fastjson只能用这个
           /* JSONObject jsonObject=new JSONObject();
            jsonObject.put("isok",1);
            jsonObject.put("dizhi","/upload/wximg/"+filename+"."+type);
            writer.write(jsonObject.toString());*/
            System.out.println("http://127.0.0.1:8086/upload/wximg/"+filename+"."+type);

            return new RestResponse(0, Constant.SUCCESS,"http://127.0.0.1:8086/upload/wximg/"+filename+"."+type);
        } catch (IOException e) {
            e.printStackTrace();
            return new RestResponse(1,"上传IO异常");
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return new RestResponse(1,"上传状态异常");
        }

    }
}
