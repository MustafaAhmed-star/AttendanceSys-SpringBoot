package com.example.attendance.attendance.dto;

import java.util.List;
import java.util.Map;

public class AttendanceRequest {
    private List<Integer> studentIds;
    private Map<String, String> attendanceData; // maps attendance_{studentId} to "present" or "absent"

    // Getters and Setters
    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }

    public Map<String, String> getAttendanceData() {
        return attendanceData;
    }

    public void setAttendanceData(Map<String, String> attendanceData) {
        this.attendanceData = attendanceData;
    }
}