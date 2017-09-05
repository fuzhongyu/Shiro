package com.fzy.base_tutorial;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.SubjectThreadState;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.LifecycleUtils;
import org.apache.shiro.util.ThreadState;
import org.apache.shiro.util.UnavailableConstructorException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * Abstract test case enabling Shiro in test environments.
 *
 * Subject 是“当前执行”用户的特定安全视图，且该 Subject 实 例绑定到一个线程来确保我们知道在线程执行期间的任何时间是谁在执行逻辑。这意味着三个基本的东西必须始终出现，为了能够支持访问当前正在执行的 Subject:
 *      1. 必须创建一个 Subject 实例
 *      2. Subject实例必须绑定当前执行的线程。
 *      3. 在线程完成执行后(或如果该线程执行抛出异常)，该 Subject 必须解除绑定来确保该线程在任何线程池环境中保持'clean'。
 *
 *  即，创建一个 Subject 实例后，它必须被绑定线程。在该线程完成执行后， 我们必须解除 Subject 的绑定来保持线程的'clean'.
 *
 * Created by fuzhongyu on 2017/9/5.
 */


public class ExampleShiroIntegrationTest extends AbstractShiroTest{

    //0. Build and set the SecurityManager used to build Subject instances used in your tests
    // This typically only needs to be done once per class if your shiro.ini doesn't change,
    // otherwise, you'll need to do this logic in each test that is different
    @Before
    public void beforeClass(){
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        setSecurityManager(factory.getInstance());
    }

    @Test
    public void testSimple(){
        //1. Build the Subject instance for the test to run:
        Subject subjectUnderTest=new Subject.Builder(getSecurityManager()).buildSubject();
        //2. Bind the subject to the current thread:
        setSubject(subjectUnderTest);
        //perform test logic here. Any call to
        // SecurityUtils.getSubject() directly (or nested in the
        // call stack) will work properly.

    }

    @After
    public void tearDownSubject(){
        //3. Unbind the subject from the current thread:
        clearSubject();

    }
}


abstract class AbstractShiroTest {

    private static ThreadState subjectThreadState;

    public AbstractShiroTest(){}

    /**
     * Allows subclasses to set the currently executing {@link Subject} instance. *
     * @param subject the Subject instance
     */
    protected void setSubject(Subject subject){
        clearSubject();
        subjectThreadState=createThreadState(subject);
        subjectThreadState.bind();

    }

    protected Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    protected ThreadState createThreadState(Subject subject){
        return new SubjectThreadState(subject);
    }

    /**
     * Clears Shiro's thread state, ensuring the thread remains clean for future test execution.
     */
    protected void clearSubject(){
        doClearSubject();

    }

    private static void  doClearSubject(){
        if(subjectThreadState!=null){
            subjectThreadState.clear();
            subjectThreadState=null;
        }
    }

    protected static void setSecurityManager(SecurityManager securityManager){
        SecurityUtils.setSecurityManager(securityManager);
    }

    protected  static SecurityManager getSecurityManager(){
        return SecurityUtils.getSecurityManager();
    }

    @AfterClass
    public static void tearDownShiro(){
        doClearSubject();
        try {
            SecurityManager securityManager=getSecurityManager();
            LifecycleUtils.destroy(securityManager);
        }catch (UnavailableConstructorException e){
            //we don't care about this when cleaning up the test environment
            // (for example, maybe the subclass is a unit test and it didn't
            // need a SecurityManager instance because it was using only
            // mock Subject instances)
        }
        setSecurityManager(null);
    }

}

