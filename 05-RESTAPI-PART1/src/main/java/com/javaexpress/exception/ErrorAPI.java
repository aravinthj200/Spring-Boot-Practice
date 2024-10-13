package com.javaexpress.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ErrorAPI {
	Integer statuCode;
	String status;
	String details;
	String title;
	LocalDateTime localDateTime;

}
