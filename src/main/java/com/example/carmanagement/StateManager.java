package com.example.carmanagement;


import java.util.HashMap;
import java.util.Map;


public class StateManager {
    // Single static map to store all checkbox states
    private static final Map<String, Boolean> checkboxStates = new HashMap<>();


    public static void saveCheckboxState(String controllerName, String checkboxId, boolean isSelected) {
        String key = controllerName + ":" + checkboxId;
        checkboxStates.put(key, isSelected);
    }


    public static boolean getCheckboxState(String controllerName, String checkboxId) {
        String key = controllerName + ":" + checkboxId;
        return checkboxStates.getOrDefault(key, false);
    }
}