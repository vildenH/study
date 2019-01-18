package tools.quatz;

import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author wh
 * @date 2019/1/18
 */
@Slf4j
public class QuartzTest {

  public static void main(String[] args) throws SchedulerException {

    try {
      // Grab the Scheduler instance from the Factory
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

      // and start it off
      scheduler.start();

      Thread.sleep(10000);
      scheduler.shutdown();

    } catch (SchedulerException se) {
      se.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


}

class HelloQuartz implements Job {

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    JobDetail detail = context.getJobDetail();
    String name = detail.getJobDataMap().getString("name");
    System.out.println("say hello to " + name + " at " + LocalDate.now());
  }
}