package com.lyh.dao;

import com.lyh.bean.User;

public interface UserDao {

    /**
     * 登录验证的方法
     * @param user  uname:用户名   upass:密码
     * @return  int  -1：登录失败  1: 管理员登陆  2：学生登陆
     */
    int login(User user);

    /**
     * 添加学生信息
     * @param user
     * @return TRUE 添加成功  FALSE 添加失败
     */
    boolean insert(User user);

    /**
     * 删除学生信息
     * @param user 要删除的用户名
     * @return TRUE 删除成功  FALSE 删除失败
     */
    boolean delete(User user);

    /**
     * 修改学生信息
     * @param user
     * @return   TRUE 修改成功  FALSE 修改失败
     */
    boolean update(User user);

    /**
     * 查询学生信息
     * @param uname 需要查询的用户名
     * @return  学生的所有信息  没查到返回 null；
     */
    User select(String uname);


}
