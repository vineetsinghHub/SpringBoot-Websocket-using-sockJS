package com.notification.dstplNotification.websocketSTOMP;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecificNotification {

	private String text;
	private String to;
	private String from;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
