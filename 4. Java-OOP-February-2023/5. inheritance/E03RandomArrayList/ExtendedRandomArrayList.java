package inheritance.E03RandomArrayList;

public class ExtendedRandomArrayList <T> extends RandomArrayList<T> {

    public void method() {
        super.modCount = 5;

//        super.removeRange();
    }
}
