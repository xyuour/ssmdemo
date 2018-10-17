package edu.scdx.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.scdx.common.util.JsonUtil;
import edu.scdx.entity.User;
import edu.scdx.service.UserService;
import edu.scdx.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 这个是返回页面
     * @param model
     * @return
     */
    @RequestMapping("/list.do")
    public String getUsers(Model model,HttpSession session){
    	List<User> users = userService.getAll();
        model.addAttribute("list",users);//添加
        return "list";
    }
    
    /**
     * 获取json 的第一种方式
     * 返回json 格式
     * @param model
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/getUserA.json")
    @ResponseBody
    public Object getUserByIdA(Model model,HttpSession session,Integer id ){
    	User user = userService.findUserById(id);
    	return user;
    }
    
    /**
     * 获取第json 的第二种方式
     * @param model
     * @param response
     * @param session
     * @param id
     */
    @RequestMapping("/getUserB.json")
    public void getUserByIdB(Model model,HttpServletResponse response,HttpSession session,Integer id ){
    	User user = userService.findUserById(id);
    	JsonUtil.printByJSON(response, user);
    }
    
    @RequestMapping("/addUser.do")
    public String insertUser(Model model,HttpSession session,Integer id,String userName,Integer age ){
    	User user = new User(userName, age);
//    	UserService userService  = new UserServiceImpl();
    	userService.addUser(user);
    	return "insertOK";
    }
    
    
    
    
}
