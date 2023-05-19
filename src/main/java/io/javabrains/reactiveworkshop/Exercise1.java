package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        StreamSources.intNumbersStream().forEach(e -> System.out.println("a. " + e));
        // StreamSources.intNumbersStream().forEach(System.out::println); // same as above


        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(number -> number < 5)
                .forEach(number -> System.out.println("b. " + number));


        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.println("c. " + number));


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("d. " +
                StreamSources.intNumbersStream().filter(number -> number > 5)
                        .findFirst()
                        .orElse(-1)
        );

        // Print first names of all users in userStream
        // TODO: Write code here
        /*StreamSources.userStream()
                .forEach(user -> System.out.println("e. " + user.getFirstName()));*/ // This is also a way to do this
        StreamSources.userStream()
                .map(user -> user.getFirstName())                               // This will replace user with users firstname
                .forEach(userFirstName -> System.out.println("e. " + userFirstName));   // Now this is having user firstname


        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(n -> n == u.getId()))
                .forEach(u -> System.out.println("f. " + u.getFirstName()));

        // OR
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(n -> n == u.getId()))
                .map(u -> "g. " + u.getFirstName())
                .forEach(System.out::println);


    }

}
