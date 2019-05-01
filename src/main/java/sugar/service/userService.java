package sugar.service;

import sugar.bean.User;

public interface userService {
    /**
     * 用户登录
     * @param username 用户名
     * @param password  密码
     * @return User
     */
     User login(String email, String password);

    /**
     * 用户注册
     * @param user
     * @return boolean
     */
     boolean regist(User user);

    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
     boolean isUserExist(String email);
}
