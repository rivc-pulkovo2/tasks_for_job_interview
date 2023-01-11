package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rivc.pojo.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * The type Lottery service.
 * Used to run multi-thread lottery
 * ApplicantFinder class to run in thread for add random human to applicantsList for participate in lottery
 * CheckWinner class to choose winner from applicantsList when ApplicantFinder threads is up to needed threshold
 * Lottery used CyclicBarrier pattern
 */
@Service
public class
LotteryService {

    private final HumanListService humanListService;

    /**
     * The Applicants list.
     */
    List<Human> applicantsList = Collections.synchronizedList(new ArrayList<>());

    /**
     * The Cyclic barrier.
     */
    CyclicBarrier cyclicBarrier;


    /**
     * Instantiates a new Lottery service.
     *
     * @param humanListService the human list service
     */
    @Autowired
    public LotteryService(HumanListService humanListService) {
        this.humanListService = humanListService;
    }

    /**
     * Run lottery.
     *
     * @param numberOfApplicant the number of applicant
     */
    public void runLottery(int numberOfApplicant) {

        //TODO
        
    }


    /**
     * The type Applicant finder.
     */
    class ApplicantFinder implements Runnable {

        @Override
        public void run() {

            Human applicant = null; //TODO = humanListService.getRandomHumanForLottery();

            applicantsList.add(applicant);

            System.out.println("applicant name is " + applicant.getName() + " with id " + applicant.getId());

            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Closing ApplicantFinder thread");
        }
    }


    /**
     * The type Check winner.
     */
    class CheckWinner implements Runnable {

        @Override
        public void run() {

            Random random = new Random();

            Human winner = applicantsList.get(random.nextInt(applicantsList.size()));

            System.out.println("Lottery is complete");

            System.out.println("Winner is - " + winner.getName() + " with ID " + winner.getId());

            applicantsList.clear();
        }
    }
}
