import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[4];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;

    }

    void save(Resume r) {
        int index = searchResume(r.uuid);
        if (size == storage.length) {
            System.out.println("ERROR storage is filled");
        } else if (index >= 0) {
            System.out.println("ERROR Resume is present in storage");
        } else {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        int index = searchResume(uuid);
        if (index >= 0) {
            return storage[index];
        }
        return null;
    }

    void delete(String uuid) {
        int index = searchResume(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else System.out.println("Sorry uuid not found");

    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, size);

    }

    int size() {
        return size;
    }

    void update(String uuid, String uuid2) {
        int index = searchResume(uuid);
        if (index >= 0) {
            Resume resume = new Resume();
            resume.uuid = uuid2;
            storage[index] = resume;
        } else System.out.println("Sorry uuid not found");

    }

    private int searchResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
