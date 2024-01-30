package com.avidew.learn.student.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class StudentAOP {

    @Before(value = "execution(* com.avidew.learn.student.StudentController.*(..))")
    public void beforeAdviceStudentController(JoinPoint joinPoint){
        System.out.println("Request to "+joinPoint.getSignature()+" started at " + new Date());
    }

    @After(value = "execution(* com.avidew.learn.student.StudentController.*(..))")
    public void AfterAdviceStudentController(JoinPoint joinPoint){
        System.out.println("Request to "+joinPoint.getSignature()+" ended at " + new Date());
    }

}
