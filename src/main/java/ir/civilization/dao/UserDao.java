package ir.civilization.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.civilization.holder.UserHolder;
import ir.civilization.model.user.User;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;

public class UserDao extends AbstractDao<User> {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static final UserDao INSTANCE = new UserDao();

    private UserDao() {
    }

    @Override
    public void initialize() {
        this.cacheAllUsers();
    }

    @Override
    public String getDirName() {
        return "users";
    }

    @SneakyThrows
    @Override
    public void save(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        String json = OBJECT_MAPPER.writeValueAsString(user);
        this.writeToFile(json, this.getUserFile(id + ".json"));
        UserHolder.INSTANCE.cache(user);
    }


    @SneakyThrows
    private void writeToFile(String json, File userFile) {
        try (PrintWriter printWriter = new PrintWriter(userFile)) {
            printWriter.println(json);
        }
    }

    @SneakyThrows
    private String readFromFile(File userFile) {
        return FileUtils.readFileToString(userFile, "UTF-8");
    }

    @SneakyThrows
    private void cacheAllUsers() {
        File file = new File(this.getDirPath());
        File[] children = file.listFiles();
        if (children == null)
            return;

        UserHolder userHolder = UserHolder.INSTANCE;
        for (File child : children) {
            userHolder.cache(
                    OBJECT_MAPPER.readValue(child, User.class)
            );
        }
    }

}
