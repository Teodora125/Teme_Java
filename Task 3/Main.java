import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1.
        List<String> students = new ArrayList<>();
        students.add("Ana");
        students.add("Maria");
        students.add("Ion");
        students.add("George");
        students.add("Elena");

        System.out.println("All names:");
        for (String s : students) {
            System.out.println(s);
        }

        students.remove(2);

        // 2.
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        double avg = (double) sum / numbers.size();

        System.out.println("\nSum: " + sum);
        System.out.println("Average: " + avg);

        // 3.
        List<Integer> reversed = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            reversed.add(numbers.get(i));
        }
        System.out.println("\nReversed list: " + reversed);

        // 4.
        String sentence = "Java is great and Java is powerful";
        String[] words = sentence.split(" ");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("\nUnique words:");
        for (String w : uniqueWords) {
            System.out.println(w);
        }
        System.out.println("Count: " + uniqueWords.size());

        // 5.
        String text = "apple banana apple orange banana apple";
        String[] words2 = text.split(" ");

        Map<String, Integer> freq = new HashMap<>();

        for (String w : words2) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        System.out.println("\nWord frequency:");
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 6.
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Ana", "123");
        phoneBook.put("Ion", "456");
        phoneBook.put("Maria", "789");

        System.out.println("\nSearch Ana: " + phoneBook.get("Ana"));

        System.out.println("All entries:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 7.
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ana", 9));
        studentList.add(new Student("Ion", 7));
        studentList.add(new Student("Maria", 10));

        System.out.println("\nAll students:");
        for (Student s : studentList) {
            System.out.println(s);
        }

        Student best = studentList.get(0);
        for (Student s : studentList) {
            if (s.grade > best.grade) {
                best = s;
            }
        }
        System.out.println("Best student: " + best);

        // 8.
        // by name
        studentList.sort(Comparator.comparing(s -> s.name));
        System.out.println("\nSorted by name:");
        studentList.forEach(System.out::println);

        // by grade desc
        studentList.sort((a, b) -> b.grade - a.grade);
        System.out.println("\nSorted by grade desc:");
        studentList.forEach(System.out::println);

        // 9.
        List<Student> duplicates = new ArrayList<>();
        duplicates.add(new Student("Ana", 9));
        duplicates.add(new Student("Ana", 9));
        duplicates.add(new Student("Ion", 7));

        Set<Student> uniqueStudents = new HashSet<>(duplicates);

        System.out.println("\nWithout duplicates:");
        uniqueStudents.forEach(System.out::println);

        // 10.
        LinkedHashMap<Integer, String> cache = new LinkedHashMap<>(3, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > 3;
            }
        };

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.get(1);
        cache.put(4, "D");

        System.out.println("\nLRU Cache:");
        System.out.println(cache);

        // 11.
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("b", 3);
        map2.put("c", 4);

        Map<String, Integer> merged = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.put(entry.getKey(),
                    merged.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        System.out.println("\nMerged map:");
        System.out.println(merged);
    }
}