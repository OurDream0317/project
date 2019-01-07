package com.example.demo.shiro;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private StudentService studentService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        // TODO Auto-generated method stub
        System.out.println("认证");

        //shiro判断逻辑
        UsernamePasswordToken user = (UsernamePasswordToken) arg0;
        Student realUser = new Student();
        realUser.setSname(user.getUsername());
        realUser.setSpassword(String.copyValueOf(user.getPassword()));
        Student newUser =studentService.selStudent(realUser.getSname());
        if(newUser == null){
            //用户名错误
            //shiro会抛出UnknownAccountException异常
            return null;
        }
        return new SimpleAuthenticationInfo(newUser,newUser.getSpassword(),"");
    }

}
