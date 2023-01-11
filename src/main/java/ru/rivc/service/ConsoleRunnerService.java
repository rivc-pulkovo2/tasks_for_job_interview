package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The type Console runner service.
 * Used as alternative to Rest Controller to run and see methods result
 */
@Service
public class ConsoleRunnerService {
    private final int BAD_INPUT_TYPE = -1;
    private final int HUMAN_TO_PARTICIPATE_AT_LOTTERY = 5;
    private final HumanListService humanListService;

    private final LotteryService lotteryService;

    private final HumanEntityService humanEntityService;

    /**
     * The Scanner.
     * Read data from console input
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Instantiates a new Console runner service.
     *
     * @param humanListService   the human list service that work with in memory dictionary
     * @param lotteryService     the lottery service to run multi-threading lottery
     * @param humanEntityService the human entity service that use JpaRepository methods
     */
    @Autowired
    public ConsoleRunnerService(HumanListService humanListService, LotteryService lotteryService, HumanEntityService humanEntityService) {
        this.humanListService = humanListService;
        this.lotteryService = lotteryService;
        this.humanEntityService = humanEntityService;
    }

    /**
     * Run.
     */
    public void run() {
        while (true) {
            int userInput;

            System.out.println("***************");
            System.out.println("Insert command type:");
            System.out.println("1 to find by id;");
            System.out.println("2 to group by name;");
            System.out.println("3 to start lottery;");
            System.out.println("4 to run repository method;");
            System.out.println("0 to exit.");
            System.out.println("***************");

            userInput = checkUserInput();

            switch (userInput) {
                case 1 -> {
                    //TODO
                    System.out.println("Insert user id");
                    try {
                        System.out.println();
                    } catch (NoSuchElementException e) {
                        System.out.println("User not found");
                    }
                }
                case 2 -> {
                    //TODO
                    System.out.println("Grouping adult humans");
                    System.out.println();
                }
                case 3 -> {
                    //TODO
                    System.out.println("Starting lottery");
                    lotteryService.runLottery(HUMAN_TO_PARTICIPATE_AT_LOTTERY);
                }
                case 4 -> {
                    //TODO
                    System.out.println("Searching");
                    try {
                        System.out.println(humanEntityService.getHumansBySearchQuery());
                    } catch (Exception e) {
                        System.out.println("Users not found in database");
                    }


                }
                case 0 -> {
                    System.out.println("Shutdown our program");
                    return;
                }

                case BAD_INPUT_TYPE -> System.out.println("Wrong input, it's not are number");

                default -> System.out.println("Command type not found");

            }
        }
    }


    private int checkUserInput() {
        try {
            return Integer.parseInt(scanner.next());
        } catch (Exception e) {
            return BAD_INPUT_TYPE;
        }
    }
}
