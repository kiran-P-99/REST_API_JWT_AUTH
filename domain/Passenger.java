package com.railApplication.domain;

import java.sql.Date;

public class Passenger {
    String PNR;
    String FirstName;
    String LastName;
    String seat;
    String CurrentStatus;
    int WaitlistedNum;
    Date BookedDate;

    public String getPNR() {
        return PNR;
    }

    public void setPNR(String PNR) {
        this.PNR = PNR;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getCurrentStatus() {
        return CurrentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        CurrentStatus = currentStatus;
    }

    public int getWaitlistedNum() {
        return WaitlistedNum;
    }

    public void setWaitlistedNum(int waitlistedNum) {
        WaitlistedNum = waitlistedNum;
    }

    public Date getBookedDate() {
        return BookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        BookedDate = bookedDate;
    }



    public String toString(){
        return FirstName+" "+LastName+" "+CurrentStatus+" "+seat+" "+PNR+"\n";
    }
}
