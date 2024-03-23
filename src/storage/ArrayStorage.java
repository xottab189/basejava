package storage;

import model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[4];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;

    }

    void save(Resume r) {
        if (size == storage.length) {
            System.out.println("ERROR storage is filled");
        } else if (getIndex(r.getUuid()) >= 0) {
            System.out.println("ERROR model.Resume is present in storage");
        } else {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("Sorry uuid not found");
        return null;
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
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
        int index = getIndex(uuid);
        if (index >= 0) {
            Resume resume = new Resume();
            resume.setUuid(uuid2);
            storage[index] = resume;
        } else System.out.println("Sorry uuid not found");

    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
