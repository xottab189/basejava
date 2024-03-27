package storage;

import model.Resume;

public interface Storage {
    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    int size();

    void update(String uuid, String uuid2);

}