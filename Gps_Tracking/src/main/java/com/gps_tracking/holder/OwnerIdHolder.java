package com.gps_tracking.holder;

public class OwnerIdHolder {
	
	private static Long id;

    public static Long getId() {
        return id;
    }

    public static void setId(Long newId) {
        id = newId;
    }

}
