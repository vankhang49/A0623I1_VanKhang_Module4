package com.codegym.feed_back.aspect;

import com.codegym.feed_back.model.Feedback;
import com.codegym.feed_back.service.BadWordFeedbackException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class FeedbackAspect {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackAspect.class);

    private List<String> badWordList = createBadWordList();
    @AfterThrowing(pointcut = "execution(* com.codegym.feed_back.service.IFeedbackService.save(..))", throwing = "ex")
    public void logErrorToFile(JoinPoint joinPoint, Exception ex){
        Object[] args = joinPoint.getArgs();
        Feedback feedback = (Feedback) args[0];
        String author = feedback.getAuthor();
        String comment = feedback.getComment();
        LocalDateTime date = feedback.getDate();
        logger.error("Bad word detected in feedback:");
        logger.error("Author: " + author);
        logger.error("Comment: " + comment);
        logger.error("Date: " + date);
        try {
            File file = new File("H:\\module4\\AOP_sesson9\\feed_back\\src\\main\\java\\com\\codegym\\feed_back\\data\\error.csv");
            if (!file.exists()){
                throw new FileNotFoundException("Error file does not found!");
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(String.format("%s,%s,%s", author, comment, date));
            bw.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
    }
    public void checkBadWord(Feedback feedback) throws BadWordFeedbackException {
        String comment = feedback.getComment();
        for (String word : badWordList) {
            if (comment.contains(word)) {
                throw new BadWordFeedbackException("Feedback contains a bad word: " + word);
            }
        }
    }
    private List<String> createBadWordList() {
        List<String> badWordList = new ArrayList<>();
        try {
            File file = new File("H:\\module4\\AOP_sesson9\\feed_back\\src\\main\\java\\com\\codegym\\feed_back\\data\\badWords.csv");
            if (!file.exists()){
                throw new FileNotFoundException("file does not found!");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                String word = arr[1];
                badWordList.add(word);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
        return badWordList;
    }
}
