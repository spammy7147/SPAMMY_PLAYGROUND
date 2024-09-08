package collection.deque.test.queue.task;

public class BackupTask implements Task{
    @Override
    public void execute() {
        System.out.println("자료 백업...");
    }
}
