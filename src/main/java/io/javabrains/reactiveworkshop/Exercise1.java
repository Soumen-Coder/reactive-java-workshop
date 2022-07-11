package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(numbers -> System.out.println(numbers));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(numbers -> numbers < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(number -> number > 5)
                .skip(1)
                .limit(2).
                forEach(number -> System.out.println(number));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer value = StreamSources.intNumbersStream().filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(userName -> System.out.println(userName));

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream().
                filter(u -> StreamSources.intNumbersStream().anyMatch(id -> id == u.getId())).
                forEach(System.out::println);

        StreamSources.intNumbersStream().
                flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id)). //flatMap -> Combines two streams together
                map(user -> user.getFirstName()). // mapper of every object of user to its firstName
                forEach(userName -> System.out.println(userName));
    }

}
