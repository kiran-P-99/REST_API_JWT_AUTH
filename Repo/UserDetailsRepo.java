package com.railApplication.Repo;

import com.railApplication.Entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDetailsRepo
{
    JdbcTemplate template;

    public User findByUsername(String username) {
        String sql = "select * from users where username=?";

        RowMapper rowMap = new RowMapper() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        };
        List<User> userList = template.query(sql,rowMap,username);
        if(userList.isEmpty())
            return null;
        else
            return userList.get(0);
    }

    public void save(User user){
        String sql = "INSERT INTO users VALUES (?,?)";
        template.update(sql,user.getUserName(), user.getPassword());
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }


}
