/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        //storage = new Resume[10000];
        for (int x = 0; x <= size()-1; x++) {
            storage[x] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        Resume r = new Resume();
        for(int x = 0; x <= size()-1; x++){
            if (storage[x].toString() == uuid) {
                r = storage[x];
            }
            break;
        }
        //return (Resume) Arrays.stream(storage).filter(s -> Objects.nonNull(s)).filter(s -> s.toString() == uuid);
        return r;

    }

    void delete(String uuid) {
        for (int x = 0; x<=size()-1; x++) {
            if(storage[x].toString() == uuid){
                for(int y = x; y <=size()-2; y++){
                    storage[y] = storage[y+1];
                }
                break;
            }
        }
        //storage = Arrays.stream(storage).filter(s -> Objects.nonNull(s)).filter(s -> s.toString() != uuid).toArray(Resume[]::new);
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[size()];
        for (int x = 0; x <= size()-1; x++) {
            newStorage[x] = storage[x];
        }
        //newStorage = Arrays.stream(storage).filter(s -> Objects.nonNull(s)).toArray(Resume[]::new);
        return newStorage;
    }

    int size() {
        return size;
    }
}
