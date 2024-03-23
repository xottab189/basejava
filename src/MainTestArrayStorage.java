import model.Resume;
import storage.ArrayStorage;

/**
 * Test for your storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final ArrayStorage STORAGE = new ArrayStorage();

    public static void main(String[] args) {

        final Resume r1 = new Resume();
        r1.uuid = "uuid1";
        final Resume r2 = new Resume();
        r2.setUuid("uuid2");
        final Resume r3 = new Resume();
        r3.uuid = "uuid3";

        STORAGE.save(r1);
        STORAGE.save(r2);
        STORAGE.save(r3);

        System.out.println("Get r1: " + STORAGE.get(r1.getUuid());
        System.out.println("Size: " + STORAGE.size());

        System.out.println("Get dummy: " + STORAGE.get("dummy"));

        printAll();
        STORAGE.delete(r1.uuid);
        printAll();
        STORAGE.clear();
        printAll();

        System.out.println("Size: " + STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
