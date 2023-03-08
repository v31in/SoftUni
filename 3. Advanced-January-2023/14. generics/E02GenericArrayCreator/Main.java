package generics.E02GenericArrayCreator;

public class Main {
    String[] listOne = ArrayCreator.create(10, "abc");
    Integer[] listTwo = ArrayCreator.create(Integer.class, 10, 123);
}
