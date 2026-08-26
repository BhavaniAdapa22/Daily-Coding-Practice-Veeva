import java.util.*;

class DocumentLockManager {
    static class Lock {
        String userId;
        long timestamp;
        Lock(String userId, long timestamp) {
            this.userId = userId;
            this.timestamp = timestamp;
        }
    }
  
    static HashMap<String, Lock> locks = new HashMap<>();
    static long convertToMillis(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 60L * 60 * 1000 + m * 60L * 1000 + s * 1000L;
    }

    static boolean requestLock(String docId, String userId, long time) {
        if (locks.containsKey(docId)) {
            return false;
        }
        locks.put(docId, new Lock(userId, time));
        return true;
    }

    static boolean releaseLock(String docId, String userId) {
        if (!locks.containsKey(docId)) {
            return false;
        }
        Lock l = locks.get(docId);
        if (!l.userId.equals(userId)) {
            return false;
        }
        locks.remove(docId);
        return true;
    }

    static void clearExpiredLocks(long currentTime, long duration) {
        Iterator<String> it = locks.keySet().iterator();
        while (it.hasNext()) {
            String docId = it.next();
            Lock l = locks.get(docId);
            if (currentTime - l.timestamp >= duration) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Request Lock");
            System.out.println("2. Release Lock");
            System.out.println("3. Clear Expired Locks");
            System.out.println("-1. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter document id: ");
                    String docId = sc.next();
                    System.out.print("Enter user id: ");
                    String userId = sc.next();
                    System.out.print("Enter timestamp (HH:mm:ss): ");
                    String time = sc.next();
                    long timestamp = convertToMillis(time);
                    System.out.println( requestLock(docId, userId, timestamp) );

                    break;
                case 2:
                    System.out.print("Enter document id: ");
                    docId = sc.next();
                    System.out.print("Enter user id: ");
                    userId = sc.next();
                    System.out.println(
                        releaseLock(docId, userId)
                    );
                    break;
                case 3:
                    System.out.print("Enter current time (HH:mm:ss): ");
                    time = sc.next();
                    System.out.print("Enter duration in seconds: ");
                    long duration = sc.nextLong();
                    long currentTime = convertToMillis(time);
                    clearExpiredLocks( currentTime,duration * 1000L );
                    System.out.println("Expired locks cleared.");
                    break;
                case -1:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
