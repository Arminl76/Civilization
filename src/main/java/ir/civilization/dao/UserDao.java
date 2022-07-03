package ir.civilization.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.civilization.model.user.User;
import lombok.SneakyThrows;

import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;

public class UserDao extends AbstractDao<User> {

    public static final UserDao INSTANCE = new UserDao();

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

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
    }


    @SneakyThrows
    private void writeToFile(String json, File userFile) {
        try (PrintWriter printWriter = new PrintWriter(userFile)) {
            printWriter.println(json);
        }
    }

}
