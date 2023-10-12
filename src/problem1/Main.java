package problem1;

public class Main {

    public static void main(String[] args) {

        String [] keys = {"Hi", "I", "Am", "Djordje", "nice", "to", "meet", "you", "zz", "cc"};

        QuadraticProbingHashTable<String> qpht = new QuadraticProbingHashTable<>(keys.length);

        for (String key : keys) {
            qpht.insert(key);
        }

        qpht.insert("meee");
        qpht.remove("Am");
        System.out.println(qpht.contains("1"));

        System.out.println();

    }
}
