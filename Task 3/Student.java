import java.util.Objects;

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " - " + grade;
    }

    // Pentru eliminare duplicate
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return name.equals(s.name) && grade == s.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }
}