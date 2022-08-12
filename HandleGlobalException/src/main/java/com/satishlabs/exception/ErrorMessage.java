package com.satishlabs.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

public class ErrorMessage {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD")
	private LocalDateTime timeDateTime;
	private int status;
	private String error;

	public LocalDateTime getTimeDateTime() {
		return timeDateTime;
	}

	public void setTimeDateTime(LocalDateTime timeDateTime) {
		this.timeDateTime = timeDateTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
