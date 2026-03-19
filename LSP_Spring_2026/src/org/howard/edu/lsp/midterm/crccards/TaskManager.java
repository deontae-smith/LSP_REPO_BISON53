package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages a collection of Task objects.
 * 
 * Author: Deontae Smith
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Constructs a TaskManager using a HashMap for efficient task storage.
     */
    public TaskManager() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the manager.
     * Throws IllegalArgumentException if duplicate task ID exists.
     * 
     * @param task the task to add
     * @throws IllegalArgumentException if duplicate task ID is detected
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its ID.
     * 
     * @param taskId the ID of the task to find
     * @return the Task if found, otherwise null
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns a list of tasks matching the given status.
     * 
     * @param status the status to filter by
     * @return list of tasks with matching status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }

        return result;
    }
}