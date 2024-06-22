package com.rubypaper.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rubypaper.dto.BookingDTO;

@Mapper
public interface BookingMapper {

	  @Insert("INSERT INTO Booking (reserved_date, id) VALUES (#{reservedDate}, #{userId})")
	    void insertBooking(BookingDTO bookingDTO);
	  
	  @Select("SELECT reserved_date AS reservedDate, user_id AS userId FROM booking WHERE user_id = #{userId}")
	    List<BookingDTO> getBookingsByUserId(String userId);
	}