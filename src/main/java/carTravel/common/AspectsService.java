package carTravel.common;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Slf4j
@Aspect
@Component
public class AspectsService {

    /**
     * Логирование методов сервисов
     */
    @Pointcut("execution(* *..service.*(..))")
    public void logForCreateMethod() {
    }

    /**
     * Логирование методов контроллеров
     */
    @Pointcut("within(carTravel.controller.*Controller)")
    public void loggerForControllers() {
    }

    @Around("logForCreateMethod() && loggerForControllers()")
    public void measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object retval = joinPoint.proceed();
        long end = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        log.error("Выполнение метода " + methodName + " завершено за  " +
                TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");

    }
}


