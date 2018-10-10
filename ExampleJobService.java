package com.example.harshitvaish.restexamplejava;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class ExampleJobService extends JobService {
    public static final String TAg="ExampleJobService";
    public boolean jobCancelled=false;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAg, "Job Started");
        doBAckGroundWork(params);
        return true;
    }
   private void doBAckGroundWork(final JobParameters params)
   {
       new Thread(new Runnable() {
           @Override
           public void run() {
             for(int i=0;i<10;i++){
                 Log.d(TAg, "run: "+i);
                 if (jobCancelled){
                     return;
                 }
                 try {
                     Thread.sleep(3000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
               Log.d(TAg, "Job Finished");
             jobFinished(params,false);
           }
       }).start();
   }
    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAg,"Job Cancelled before Completion");
        jobCancelled=true;
        return true;
    }
}
