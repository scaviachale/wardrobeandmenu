package scaa.wardrobe.task_scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scaa.wardrobe.email.EmailService;
import scaa.wardrobe.model.Cloth;
import scaa.wardrobe.service.WardrobeService;
import scaa.wardrobe.service.WardrobeUserService;

import java.util.List;

/*
* What is cron - Cron is used to scheduled tasks to execute at a specific time.
* <second> <minute> <hour> <day-of-month> <month> <day-of-week> <year>) These are the parameters
* you can pass into the @Scheduled annotation. e.g. @Scheduled(cron = "0 30 * * * *")
* Year is an optional parameter that can be passed into the @Scheduled cron.
* https://cronexpressiondescriptor.azurewebsites.net/
*/
@Service
public class TaskScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private WardrobeService wardrobeService;

    @Autowired
    private WardrobeUserService wardrobeUserService;

    /*
    * Send daily menu
    * Description: At 12:00 AM, every weekday
    */
    @Transactional
    @Scheduled(cron = "0 0 0 * * MON-FRI")
    public void whatToWearToday(){
        List<Cloth> wearCombination = wardrobeService.getWearCombination();
        if(!wearCombination.isEmpty()){
           // emailService.sendEmail();
        }
    }
    /*
    * Send weekly update
    * Description: At 01:30 PM, only on Monday and Friday
    */
    @Transactional
    @Scheduled(cron = "0 30 13 * * MON,FRI")
    public void weeklyStatus(){

    }

    /*
    * Send monthly update
    * Description: At 12:00 AM, on day 1 of the month, every 1 month
    */
    @Transactional
    @Scheduled(cron = "0 0 0 1 */1 *")
    public void monthlyStatus(){

    }
}
