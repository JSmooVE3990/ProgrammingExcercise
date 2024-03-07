package com.example.programmingexercise.practicequestions;

import java.util.*;

public class Worker {
    private final HashMap<Integer, TaskResource> taskResources = new HashMap<>();
    private final HashMap<TaskResource, Integer> referenceCount = new HashMap<>();

    public Iterable<TaskResource> getTaskResources() {
        return this.taskResources.values();
    }

    public TaskResource acquireTaskResource(int id) {
        TaskResource resource = this.taskResources.getOrDefault(id, null);
        if (resource == null) {
            resource = new TaskResource(id);
            this.taskResources.put(id, resource);
        }
        this.referenceCount.put(resource, this.referenceCount.getOrDefault(resource, 0) + 1); // Increment reference count
        return resource;
    }

    public void releaseTaskResource(int id) {
        TaskResource resource = this.taskResources.getOrDefault(id, null);
        if (resource == null)
            throw new IllegalArgumentException();

        int count = this.referenceCount.getOrDefault(resource, 0);
        if (count <= 0)
            throw new IllegalStateException();

        count--; // Decrement reference count
        this.referenceCount.put(resource, count);

        if (count == 0) {
            resource.close(); // Release the resources only if reference count drops to zero
            this.taskResources.remove(id);
        }
    }

    public class TaskResource {
        private List<String> taskList = new ArrayList<>();
        private int id;

        public int getId() {
            return this.id;
        }

        public List<String> getTasks() {
            return this.taskList;
        }

        public TaskResource(int id) {
            this.id = id;
        }

        public void doTask(String task) {
            if (this.taskList == null)
                throw new IllegalStateException(this.getClass().getName());
            this.taskList.add(task);
        }

        public void close() {
            this.taskList = null; // Release the memory
        }
    }

    public static void main(String[] args) {
        Worker d = new Worker();

        d.acquireTaskResource(1).doTask("Task11");
        d.acquireTaskResource(2).doTask("Task21");
        System.out.println(String.join(", ", d.acquireTaskResource(2).getTasks()));
        d.releaseTaskResource(2);
        d.acquireTaskResource(1).doTask("Task12");
        System.out.println(String.join(", ", d.acquireTaskResource(1).getTasks()));
        d.releaseTaskResource(1);
        System.out.println(String.join(", ", d.acquireTaskResource(1).getTasks()));

    }
}
