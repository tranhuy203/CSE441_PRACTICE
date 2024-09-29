package com.example.prac02;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StaffViewModel extends ViewModel {
    private MutableLiveData<List<Staff>> staffs;

    public StaffViewModel() {
        staffs = new MutableLiveData<>(new ArrayList<>());
    }

    public MutableLiveData<List<Staff>> getStaffs() {
        return staffs;
    }
    public void addStaff(Staff staff){
        List<Staff> currentList = staffs.getValue();
        if(currentList!=null){
            currentList.add(staff);
            staffs.setValue(currentList);
        }
    }
}
