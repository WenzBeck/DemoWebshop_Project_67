package demowebshop.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    protected ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp() {

        app.init();
    }

    @AfterMethod
    public void tearDown() {

        app.stop();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] p){
        logger.info("Start test {} with data: {}",method.getName(), Arrays.asList(p));
    }
    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()){
            logger.info("PASSED: {}",result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: {}. Screenshot - > {}",result.getMethod().getMethodName(),
                    app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("**************************");
    }
}
