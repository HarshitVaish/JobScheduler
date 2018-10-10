package com.example.harshitvaish.restexamplejava;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
Button start,stop;
private  static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduleJob(v);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelJob(v);
            }
        });
    }
    public void scheduleJob(View v){
        ComponentName componentName=new ComponentName(this,ExampleJobService.class);
        JobInfo info=new JobInfo.Builder(123,componentName).setRequiresCharging(true).setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15*60*1000).build();
        JobScheduler scheduler=(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode= scheduler.schedule(info);
        if (resultCode==JobScheduler.RESULT_SUCCESS){
            Log.d(TAG,"Job Scheduled");
        }
        else{
            Log.d(TAG,"Job Scheduleding failed");
        }
    }
    public void cancelJob(View v){
      JobScheduler scheduler=(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.cancel(123);
        Log.d(TAG,"Job Cancelled");
    }
}
