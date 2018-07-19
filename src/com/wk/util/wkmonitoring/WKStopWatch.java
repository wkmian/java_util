package com.wk.util.wkmonitoring;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * 计时器
 */
public class WKStopWatch {
    //ID
    private final String id;
    //任务列表
    private final List<TaskInfo> taskList = new LinkedList<TaskInfo>();
    //是否运行
    private boolean running;
    //总时间
    private long totalTimeMillis;
    
    private long startTimeMillis;
    
    //最后一个任务信息
    private TaskInfo lastTaskInfo;
    
    //最后一个任务的名字
    private String currentName;
    
    public WKStopWatch(String id) {
        this.id = id;
    }
    
    public WKStopWatch() {
        this("");
    }


    public void start(){
        start("");
    }
    
    public void start(String name) throws IllegalStateException{
        if(running){
            throw new IllegalStateException("error: it's already running");
        }
        startTimeMillis = System.currentTimeMillis();
        currentName = name;
        running = true;
    }
    
    
    public void stop(){
        if(!running){
            throw new IllegalStateException("error: it's not running");
        }
        long lastTime = System.currentTimeMillis()-this.startTimeMillis;
        totalTimeMillis+=lastTime;
        this.lastTaskInfo = new TaskInfo(currentName, lastTime);
        this.taskList.add(lastTaskInfo);
        this.running = false;
        this.currentName=null;
    }
    
    public void stopAndStart(){
        stopAndStart("");
    }
    
    public void stopAndStart(String name){
        stop();
        start(name);
    }
    
    public long getTotalTimeMillis(){
        return this.totalTimeMillis;
    }
    
    public boolean isRunning(){
        return running;
    }
    
    public String printInfo(){
        StringBuilder sb = new StringBuilder(taskList.size()*20);
        sb.append("this StopWatch '").append(this.id).append("' ")
            .append(": totalTimeMillis (ms) = ").append(this.totalTimeMillis)
            .append("\n");
        
        String space = "\t\t";
        if(this.taskList.size()>0){
            sb.append("-------------------------------------------------\n");
            sb.append("ms").append(space).append("%").append(space).append("Task Name\n");            
//            sb.append("ms\t%\tTask Name\n");
            sb.append("-------------------------------------------------\n");
            
            NumberFormat pf = NumberFormat.getPercentInstance();
            pf.setMinimumFractionDigits(2);
            double totalTimeMillis_double = this.getTotalTimeMillis()*1.0;
            for (TaskInfo taskInfo : this.taskList) {
                sb.append(taskInfo.getTimeMillis()).append(space)
                    .append(pf.format(taskInfo.getTimeMillis()/totalTimeMillis_double)).append(space)
                    .append(taskInfo.getTaskName()).append("\n");
            }
        }
        String info = sb.toString();
        System.out.println(info);
        return info;
    }


    /**
     * 时间任务信息
     */
    private final class TaskInfo{
        //任务名字
        private final String taskName;
        //任务时间
        private final long timeMillis;
        public TaskInfo(String taskName, long timeMillis) {
            this.taskName = taskName;
            this.timeMillis = timeMillis;
        }
        /**
         * @return the taskName
         */
        public String getTaskName() {
            return taskName;
        }
        /**
         * @return the timeMillis
         */
        public long getTimeMillis() {
            return timeMillis;
        }
        
        
    }
}
