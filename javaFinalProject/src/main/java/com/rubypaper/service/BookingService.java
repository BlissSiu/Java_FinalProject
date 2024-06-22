package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubypaper.dto.BookingDTO;
import com.rubypaper.persistance.BookingMapper;

@Service
public class BookingService {

    @Autowired
    private BookingMapper bookingMapper;

    @Transactional
    public void saveBooking(BookingDTO bookingDTO) {
        // BookingDTO를 그대로 사용하여 예약 정보 저장
        bookingMapper.insertBooking(bookingDTO);
    }
    
    public List<BookingDTO> getBookingsByUserId(String userId) {
        return bookingMapper.getBookingsByUserId(userId);
    }
    
    @Transactional
    public boolean cancelBooking(String userId, String reservedDate) {
        try {
            int deletedCount = bookingMapper.deleteBooking(userId, reservedDate);
            return deletedCount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
