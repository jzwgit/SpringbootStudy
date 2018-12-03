package com.jzw.ch02_aop.conf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration//声明这是spring管理的配置Bean
@Aspect//声明这是一个切面类
public class AOPConfig {
    /**声明了一个表达式，
     * @within表示目标类型带有注解
     * 意味着spring Controller方法再被调用的时候，都会执行@Around注解的方法
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable{
        try {
            Object[] args = pjp.getArgs();
            System.out.println("args:" + Arrays.asList(args));
            //调用原有的方法
            Object o = pjp.proceed();
            System.out.println("return:" +o);
            return o;
        }catch (Throwable e){
            throw e;
        }
    }
}
