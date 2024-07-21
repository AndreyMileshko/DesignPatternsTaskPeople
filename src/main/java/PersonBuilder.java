import java.util.OptionalInt;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) throw new IllegalStateException("Не введен обязательный параметр имени.");
        if (surname == null) throw new IllegalStateException("Не введен обязательный параметр фамилии.");
        if (age.isPresent() && age.orElse(-1) < 0) {
            throw new IllegalStateException("Недопустимое значение возраста.");
        }
        return new Person(this);
    }
}