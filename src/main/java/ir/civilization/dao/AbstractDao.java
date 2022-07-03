package ir.civilization.dao;

import java.io.File;

/**
 * Abstract dao class
 *
 * @param <E> entity type
 */
public abstract class AbstractDao<E> {

    public static final String BASE_DIR = "/tmp";

    public abstract String getDirName();

    public abstract void save(E e);

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public File getUserFile(String id) {
        File baseDir = new File(BASE_DIR + "/" + this.getDirName());
        if (!baseDir.exists())
            baseDir.mkdir();

        return new File(baseDir, id);
    }

}
