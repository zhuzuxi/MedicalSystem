package com.zzs.aop;

import com.zzs.common.R;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class sentinelAop {
    @Pointcut("@annotation(com.zzs.annotation.JoinSentinel)")
    public void pointcut(){}

    @Around("pointcut()")
    public R<String> advice(ProceedingJoinPoint pjp){
            Object res=null;
        try {
            System.out.println(pjp.getSignature().getName());
            res = pjp.proceed();
            System.out.println(pjp.getSignature().getName()+"done");
            String data=pjp.getSignature().getDeclaringType().toString()+res;
            return R.success("200",data);

        } catch (Throwable e) {
            System.out.println("exception");
            R.err("500");
            throw new RuntimeException(e);
        }finally {
            System.out.println("end");
//            return R.err("500");

        }

    }
}
