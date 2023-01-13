package finalExam;

import java.util.*;

public class E03MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> users = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!"Statistics".equals(command)) {
            String[] elements = command.split("=");
            String commandName = elements[0];

            switch (commandName) {
                case "Add":
                    //1. "Add={username}={sent}={received}
                    // "Add=Berg=9=0"
                    String username = elements[1];
                    int sent = Integer.parseInt(elements[2]);
                    int received = Integer.parseInt(elements[3]);
                    if (!users.containsKey(username)) {
                        users.put(username, new ArrayList<>());
                        users.get(username).add(0, sent);
                        users.get(username).add(1, received);
                    }
                    break;
                case "Message":
                    //2. "Message={sender}={receiver}"
                    // "Message=Berg=Kevin"
                    String sender = elements[1];
                    String receiver = elements[2];
                    if (users.containsKey(sender) && users.containsKey(receiver)) {
                        int senderSent = users.get(sender).get(0);
                        int senderReceived = users.get(sender).get(1);
                        int receiverSent = users.get(receiver).get(0);
                        int receiverReceived = users.get(receiver).get(1);

                        senderSent += 1;
                        receiverReceived += 1;
                        if (senderSent + senderReceived < capacity) {
                            users.get(sender).set(0, senderSent);
                        } else {
                            users.remove(sender);
                            System.out.println(String.format("%s reached the capacity!", sender));
                        }
                        if (receiverSent + receiverReceived < capacity) {
                            users.get(receiver).set(1, receiverReceived);
                        } else {
                            users.remove(receiver);
                            System.out.println(String.format("%s reached the capacity!", receiver));
                        }
                    }
                    break;
                case "Empty":
                    //3. "Empty={usermane}"
                    // Empty=Berry
                    String username1 = elements[1];
                    if (!"All".equals(username1)) {
                        users.remove(username1);
                    } else {
                        users.clear();
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println(String.format("Users count: %d", users.size()));
        users
                .entrySet()
                .stream()
                .forEach(u ->
                        System.out.printf("%s - %d%n", u.getKey (), u.getValue().get(0) + u.getValue().get(1)));
    }
}