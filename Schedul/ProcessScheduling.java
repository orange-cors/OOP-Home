package Schedul;

import java.util.*;

// Lớp đại diện cho mỗi tiến trình
class Process {
    String pid;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    public Process(String pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

// Lớp so sánh cho FCFS (theo thời gian đến)
class CompareByArrival implements Comparator<Process> {
    public int compare(Process a, Process b) {
        return a.arrivalTime - b.arrivalTime;
    }
}

public class ProcessScheduling {

    public static void main(String[] args) {
        // Dữ liệu đầu vào
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P0", 7, 9));
        processes.add(new Process("P1", 6, 5));
        processes.add(new Process("P2", 2, 8));
        processes.add(new Process("P3", 4, 6));
        processes.add(new Process("P4", 0, 2));
        processes.add(new Process("P5", 3, 1));

        // Cần tạo bản sao cho mỗi thuật toán vì chúng sẽ thay đổi danh sách
        runFCFS(new ArrayList<>(processes));
        runSJF(new ArrayList<>(processes));
    }

    // ----- 1. Thuật toán FCFS -----
    public static void runFCFS(List<Process> processes) {
        System.out.println("--- 🥇 Mô phỏng FCFS ---");
        
        // Sắp xếp các tiến trình theo thời gian đến
        Collections.sort(processes, new CompareByArrival());

        int currentTime = 0;
        double totalWaitingTime = 0;
        StringBuilder ganttChart = new StringBuilder("|");
        StringBuilder ganttTimeline = new StringBuilder("0");

        for (Process p : processes) {
            // Thời gian bắt đầu = max(thời gian hiện tại, thời gian đến của tiến trình)
            int startTime = Math.max(currentTime, p.arrivalTime);
            p.completionTime = startTime + p.burstTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;

            totalWaitingTime += p.waitingTime;
            currentTime = p.completionTime; // Cập nhật thời gian hệ thống

            // Xây dựng giản đồ Gantt
            ganttChart.append(" ").append(p.pid).append(" |");
            ganttTimeline.append(String.format("%" + (p.pid.length() + 3) + "s", p.completionTime));
        }

        // In kết quả
        System.out.println("a. Giản đồ Gantt (FCFS):");
        System.out.println(ganttChart.toString());
        System.out.println(ganttTimeline.toString());
        
        System.out.println("\nb. Bảng thời gian (FCFS):");
        printResultsTable(processes);
        System.out.printf("Thời gian chờ đợi trung bình (FCFS): %.2f\n", totalWaitingTime / processes.size());
        System.out.println("---------------------------\n");
    }

    // ----- 2. Thuật toán SJF (Không ưu tiên) -----
    public static void runSJF(List<Process> processes) {
        System.out.println("--- ⚡ Mô phỏng SJF (Không ưu tiên) ---");

        // Sắp xếp danh sách ban đầu theo thời gian đến
        Collections.sort(processes, new CompareByArrival());
        
        List<Process> completedProcesses = new ArrayList<>();
        // Hàng đợi sẵn sàng (ready queue), sắp xếp theo burst time
        PriorityQueue<Process> readyQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.burstTime));
        
        int currentTime = 0;
        int processIndex = 0; // Chỉ số cho danh sách processes ban đầu
        double totalWaitingTime = 0;
        
        StringBuilder ganttChart = new StringBuilder("|");
        StringBuilder ganttTimeline = new StringBuilder("0");

        while (completedProcesses.size() < processes.size()) {
            // 1. Thêm tất cả các tiến trình đã đến vào readyQueue
            while (processIndex < processes.size() && processes.get(processIndex).arrivalTime <= currentTime) {
                readyQueue.add(processes.get(processIndex));
                processIndex++;
            }

            // 2. Nếu readyQueue rỗng, tua nhanh thời gian đến tiến trình tiếp theo
            if (readyQueue.isEmpty()) {
                if (processIndex < processes.size()) {
                    currentTime = processes.get(processIndex).arrivalTime;
                }
                continue; // Quay lại vòng lặp để thêm tiến trình vào queue
            }

            // 3. Lấy tiến trình ngắn nhất từ readyQueue
            Process currentProcess = readyQueue.poll();

            // 4. Xử lý tiến trình
            int startTime = currentTime; // Thời gian bắt đầu chính là thời gian hiện tại
            currentProcess.completionTime = startTime + currentProcess.burstTime;
            currentProcess.turnaroundTime = currentProcess.completionTime - currentProcess.arrivalTime;
            currentProcess.waitingTime = currentProcess.turnaroundTime - currentProcess.burstTime;

            totalWaitingTime += currentProcess.waitingTime;
            currentTime = currentProcess.completionTime; // Cập nhật thời gian hệ thống

            completedProcesses.add(currentProcess);

            // Xây dựng giản đồ Gantt
            ganttChart.append(" ").append(currentProcess.pid).append(" |");
            ganttTimeline.append(String.format("%" + (currentProcess.pid.length() + 3) + "s", currentProcess.completionTime));
        }

        // In kết quả
        System.out.println("a. Giản đồ Gantt (SJF):");
        System.out.println(ganttChart.toString());
        System.out.println(ganttTimeline.toString());
        
        System.out.println("\nb. Bảng thời gian (SJF):");
        printResultsTable(completedProcesses);
        System.out.printf("Thời gian chờ đợi trung bình (SJF): %.2f\n", totalWaitingTime / processes.size());
        System.out.println("---------------------------\n");
    }

    // Hàm tiện ích để in bảng kết quả
    private static void printResultsTable(List<Process> processes) {
        // Sắp xếp lại theo PID để dễ đọc
        Collections.sort(processes, Comparator.comparing(p -> p.pid));
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for (Process p : processes) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\n",
                p.pid, p.arrivalTime, p.burstTime, 
                p.completionTime, p.turnaroundTime, p.waitingTime);
        }
    }
}