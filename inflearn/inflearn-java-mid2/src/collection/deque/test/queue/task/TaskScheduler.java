package collection.deque.test.queue.task;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskScheduler {
    private Queue<Task> tasks = new ArrayDeque<>();


    public int getRemainingTasks() {
        return tasks.size();
    }

    public void processNextTask() {
        Task task = tasks.poll();
        if (task != null) {
            task.execute();
        }

    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
