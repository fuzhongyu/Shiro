package com.fzy.base_tutorial;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * shiro基础实体类的使用
 * Created by fuzhongyu on 2017/8/8.
 */
public class Tutorial {

    private static final transient Logger log= LoggerFactory.getLogger(Tutorial.class);

    public static void main(String[] args) {

        log.info("My First Apache Shiro Application");

        /**
         *  我们使用 Shiro 的 IniSecurityManager 实现来提取我们的 shiro.ini 文件，它位于 classpath 的根目录。该实现反
         *  映了 Shiro 对工厂设计模式的支持。classpath: 前缀是一个资源定位符，用来告诉 shiro 去哪加载 ini 文件(其
         *  他前缀，如 url:和 file:也同样被支持)
         */

        IniSecurityManagerFactory factory= new IniSecurityManagerFactory("classpath:shiro.ini");

        //factory.getInstance()方法被调用，它来解析 INI 文件并返回反映该配置的 SecurityManager 实例
        SecurityManager securityManager= factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        //get the currently executing user:
        Subject currentUser = SecurityUtils.getSubject();

        /**
         * session
         */
        //Do some stuff with a Session (no need for a web or EJB container!!!)
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("Retrieved the correct vlaue! [" + value + "]");
        }

        /**
         * subject
         */
        //let's login the current user so we can check against roles and permissions:
        //如果没有通过登录验证，则创建账户
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch(IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch(LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked. " + "Please contact your administrator to unlock it.");
            }
                // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition? error?
            }

        }



        System.out.println("----"+currentUser.isAuthenticated()+"    "+currentUser.isRemembered());


        //say who they are:
        //print their identifying principal (in this case, a username):
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //检查是否当前角色，没有回抛出异常
        currentUser.checkRoles(new String[]{"schwartz"});

        //test a typed permission (not instance-level)
        if (currentUser.isPermitted("lightsaber:weild")) {
            log.info("You may use a lightsaber ring. Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5' . Here are the keys - have fun!");
         } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }



        //all done - log out!
        currentUser.logout();

        System.out.println(">>>"+currentUser.isAuthenticated()+"    "+currentUser.isRemembered());

        System.exit(0);
    }

}
