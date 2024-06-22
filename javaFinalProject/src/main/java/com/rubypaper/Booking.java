package com.rubypaper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue
	private int bookingid;
	private String reserved_date;
	private String id;
}
