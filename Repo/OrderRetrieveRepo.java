package com.railApplication.Repo;

import com.railApplication.domain.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderRetrieveRepo {
    JdbcTemplate template;

    public List<Passenger> retrieveOrderDetails(String PNR){

        String sql="select * from passenger where PNR=?";

        RowMapper rowMap = new RowMapper() {
            @Override
            public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {
                Passenger passenger = new Passenger();
                passenger.setPNR(PNR);
                passenger.setFirstName(rs.getString("FirstName"));
                passenger.setWaitlistedNum(rs.getByte("WaitListedNum"));
                passenger.setSeat(rs.getString("Seat"));
                passenger.setBookedDate(rs.getDate("BookedDate"));
                passenger.setCurrentStatus(rs.getString("CurrentStatus"));
                passenger.setLastName(rs.getString("LastName"));
                return passenger;
            }
        };

        return template.query(sql,rowMap,PNR);


    }
    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
