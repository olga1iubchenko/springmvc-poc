package com.poc.springproject.service;

import com.poc.springproject.client.SqlClient;
import com.poc.springproject.dto.UserDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SqlDbService {

    private SqlClient sqlClient = new SqlClient();

    @SneakyThrows
    public List<Map<String, Object>> getResultFromSql(final String targetName, final List<String> fields) {
        ResultSet resultSet = sqlClient.getAllUsers(targetName);
        List<Map<String, Object>> rowList = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> rowData = new HashMap<>();
            fields.forEach(field -> {
                try {
                    rowData.put(field, resultSet.getObject(field));
                } catch (SQLException e) {
                    throw new IllegalArgumentException("There is no data in target db for the field: " + targetName + e.getMessage());
                }
            });
            rowList.add(rowData);
        }
        resultSet.close();
        return rowList;
    }

    @SneakyThrows
    public Map<Integer, Object> getUserById( int userId) {
        ResultSet resultSet = sqlClient.getUserById( userId);
        Map<Integer, Object> rowData = new HashMap<>();
        while (resultSet.next()) {
            try {
                rowData.put(userId, resultSet.first());
            } catch (SQLException e) {
                throw new IllegalArgumentException("There is no data in target db for the thid user id: " + e.getMessage());
            }
        }
        resultSet.close();
        return rowData;
    }

    @SneakyThrows
    public void createUser(UserDto user) {
        sqlClient.saveNewUserToUserDb(user);
    }

    public UserDto getUserFromDbResult( int userId) {
        return  getUserById(userId).values().stream().map(user -> (UserDto)user).collect(Collectors.toList()).get(0);
    }

    }
