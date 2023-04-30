package interfacesAndAbstraction.E05BorderControl;

public class Citizen implements Identifiable {
    private String id;
    private String name;
    private int age;

    public Citizen(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
