import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;

    }

    void save(Resume r) {
        if (size > 0) {
            storage[size] = r;
        } else {
            storage[size] = r;
        }
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage, size);

    }

    int size() {
        return size;
    }

    void update(Resume resume) {

    }
}
