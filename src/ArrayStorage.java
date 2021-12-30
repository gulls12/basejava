/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        //storage = new Resume[10000];
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        //Resume r = new Resume();
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                return storage[i];
            }
            break;
        }
        //return (Resume) Arrays.stream(storage).filter(s -> Objects.nonNull(s)).filter(s -> s.toString() == uuid);
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size ; i++) {
            if (storage[i].toString() == uuid) {
                for (int j = i; j <= size - 2; j++) {
                    storage[j] = storage[j + 1];

                }
                size--;
                break;
            }
        }
        //storage = Arrays.stream(storage).filter(s -> Objects.nonNull(s)).filter(s -> s.toString() != uuid).toArray(Resume[]::new);

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        //resumes = Arrays.stream(storage).filter(s -> Objects.nonNull(s)).toArray(Resume[]::new);
        return resumes;
    }

    int size() {
        return size;
    }
}
