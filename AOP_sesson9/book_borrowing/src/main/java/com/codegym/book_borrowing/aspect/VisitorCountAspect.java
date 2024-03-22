package com.codegym.book_borrowing.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VisitorCountAspect {
    private static final Logger logger = LoggerFactory.getLogger(VisitorCountAspect.class);
    private int visitorCount = 0;

    @AfterReturning("execution(* com.codegym.book_borrowing.controller.BookController.*(..))")
    public void countVisitors() {
        visitorCount++;
        logger.info("Visitor count: " + visitorCount);
    }
}
