package ru.rivc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.rivc.service.ConsoleRunnerService;



public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.rivc");
        context.refresh();

        ConsoleRunnerService consoleRunnerService = (ConsoleRunnerService)context.getBean("consoleRunnerService");

        consoleRunnerService.run();
    }
}