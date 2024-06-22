package com.rubypaper.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rubypaper.dto.BookingDTO;

@Mapper
public interface BookingMapper {

	 @Insert("INSERT INTO booking (reserved_date, id) VALUES (#{reservedDate}, #{userId})")
	    void insertBooking(BookingDTO bookingDTO);
    
    @Select("SELECT reserved_date AS reservedDate, id AS userId FROM booking WHERE id = #{userId}")
    List<BookingDTO> getBookingsByUserId(String userId);
    
    @Delete("DELETE FROM booking WHERE id = #{userId} AND reserved_date = #{reservedDate}")
    int deleteBooking(@Param("userId") String userId, @Param("reservedDate") String reservedDate);
    
}
