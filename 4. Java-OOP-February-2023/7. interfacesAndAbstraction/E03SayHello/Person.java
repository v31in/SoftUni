package interfacesAndAbstraction.E03SayHello;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello!";
    }
}
