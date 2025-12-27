package com.examly.springapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "booking_id", nullable = false)
    private String bookingId; 


    @Column(name = "room_id", nullable = false)
    private String roomId; 


    @Column(name = "check_in_date", nullable = false)
    private String checkInDate; 

    @Column(name = "check_out_date", nullable = false)
    private String checkOutDate; 

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getbookingId(){
        return bookingId;
    }

    public void setbookingId(String bookingId){
        this.bookingId = bookingId;
    }

    public String getroomId(){
        return roomId;
    }

    public void setroomId(String roomId){
        this.roomId = roomId;
    }

    public String getcheckInDate(){
        return checkInDate;
    }

    public void setcheckInDate(String checkInDate){
        this.checkInDate = checkInDate;
    }

    public String getcheckOutDate(){
        return checkOutDate;
    }

    public void setcheckOutDate(String checkOutDate){
        this.checkOutDate = checkOutDate;
    }



}