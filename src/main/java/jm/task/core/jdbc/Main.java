package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        UserService UserService = new UserServiceImpl();

        try {
            UserService.createUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        UserService.saveUser("Name1", "LastName1", (byte) 20);
        UserService.saveUser("Name2", "LastName2", (byte) 25);
        UserService.saveUser("Name3", "LastName3", (byte) 31);
        UserService.saveUser("Name4", "LastName4", (byte) 38);

        UserService.removeUserById(1);
        UserService.getAllUsers();
        UserService.cleanUsersTable();
        UserService.dropUsersTable();
    }
}
