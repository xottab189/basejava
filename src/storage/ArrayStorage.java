package storage;

import model.Resume;

import java.util.Arrays;

public class ArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 3;
    private static final Resume[] STORAGE = new Resume[STORAGE_LIMIT];
    private int size;

    public void clear() {
        Arrays.fill(STORAGE, 0, size, null);
        size = 0;

    }

    public void save(Resume r) {
        if (size == STORAGE.length) {
            System.out.println("ERROR storage is filled");
        } else if (getIndex(r.getUuid()) >= 0) {
            System.out.println("ERROR model.Resume is present in storage");
        } else {
            STORAGE[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return STORAGE[index];
        }
        System.out.println("Sorry uuid not found");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            STORAGE[index] = STORAGE[size - 1];
            STORAGE[size - 1] = null;
            size--;
        } else System.out.println("Sorry uuid not found");

    }

    public Resume[] getAll() {
        return Arrays.copyOf(STORAGE, size);

    }

    public int size() {
        return size;
    }

    public void update(String uuid, String uuid2) {
        int index = getIndex(uuid);
        if (index >= 0) {
            Resume resume = new Resume();
            resume.setUuid(uuid2);
            STORAGE[index] = resume;
        } else System.out.println("Sorry uuid not found");

    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (STORAGE[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
