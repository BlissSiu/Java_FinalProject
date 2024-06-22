package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rubypaper.dto.BookingDTO;
import com.rubypaper.service.BookingService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> book(@RequestBody BookingDTO bookingDTO) {
        try {
            bookingService.saveBooking(bookingDTO);
            return ResponseEntity.ok("Booking successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Booking failed: " + e.getMessage());
        }
    }
    
    @GetMapping("/bookingchecked")
    public String showBookingCheckedPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        
        // 예약 정보 조회
        List<BookingDTO> bookings = bookingService.getBookingsByUserId(userId);
        
        // 모델에 예약 정보 리스트 추가
        model.addAttribute("bookings", bookings);
        
        // bookingchecked.html 페이지로 이동
        return "bookingchecked";
    }
    

    @PostMapping("/cancel")
    public String cancelBooking(@RequestParam("userId") String userId,
            @RequestParam("reservedDate") String reservedDate,
            RedirectAttributes redirectAttributes) {

// 예약 취소 로직 수행
    	boolean cancelled = bookingService.cancelBooking(userId, reservedDate);

    	if (cancelled) {
    		redirectAttributes.addFlashAttribute("message", "예약이 취소되었습니다.");
    	} else {
    		redirectAttributes.addFlashAttribute("error", "예약 취소에 실패했습니다.");
    	}

    	return "redirect:/bookingchecked"; // 취소 후 예약 확인 페이지로 리다이렉트
    }
}
