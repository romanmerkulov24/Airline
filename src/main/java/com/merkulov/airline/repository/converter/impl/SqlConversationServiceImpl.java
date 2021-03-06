package com.merkulov.airline.repository.converter.impl;

import com.merkulov.airline.entity.Flight;
import com.merkulov.airline.entity.User;
import com.merkulov.airline.repository.converter.SqlConversationService;
import com.merkulov.airline.repository.converter.SqlConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlConversationServiceImpl implements SqlConversationService {
    private Map<Class, SqlConverter> converters;

    public SqlConversationServiceImpl() {
        converters = new HashMap<>();
        converters.put(User.class, new UserSqlConverter());
//        converters.put(Plane.class, new PlaneSqlConverter());
//        converters.put(Airport.class, new AirportSqlConverter());
        converters.put(Flight.class, new FlightSqlConverter());
    }

    @Override
    public <T> T convert(ResultSet resultSet, Class<T> clazz) throws SQLException {
        return (T) converters.get(clazz).convert(resultSet);
    }

    @Override
    public <T> List<T> convertToList(ResultSet resultSet, Class<T> clazz) throws SQLException {
        List<T> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(convert(resultSet, clazz));
        }
        return list;
    }
}
