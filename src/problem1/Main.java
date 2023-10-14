package problem1;

public class Main {

    public static void main(String[] args) {

        String [] keys = {"Hi", "I", "Am", "Djordje", "nice", "to", "meet", "you", "zz", "cc"};

        QuadraticProbingHashTable<String> qpht = new QuadraticProbingHashTable<>();

        for (String key : keys) {
            qpht.insert(key);
        }

        qpht.insert("meee");
        qpht.insert("1");
        qpht.insert("2");
        qpht.insert("a");
        System.out.println(qpht.contains("1"));

        System.out.println();

    }
}
