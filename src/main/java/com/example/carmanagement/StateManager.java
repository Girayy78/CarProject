package com.example.carmanagement;


import java.util.HashMap;
import java.util.Map;

/**
 * A simple static class to store and retrieve checkbox states across scene changes
 */
public class StateManager {
    // Single static map to store all checkbox states
    private static final Map<String, Boolean> checkboxStates = new HashMap<>();

    /**
     * Save a checkbox state
     * @param controllerName The name of the controller class
     * @param checkboxId The ID of the checkbox
     * @param isSelected Whether the checkbox is selected
     */
    public static void saveCheckboxState(String controllerName, String checkboxId, boolean isSelected) {
        String key = controllerName + ":" + checkboxId;
        checkboxStates.put(key, isSelected);
    }

    /**
     * Get a saved checkbox state
     * @param controllerName The name of the controller class
     * @param checkboxId The ID of the checkbox
     * @return The saved state, or false if no state was saved
     */
    public static boolean getCheckboxState(String controllerName, String checkboxId) {
        String key = controllerName + ":" + checkboxId;
        return checkboxStates.getOrDefault(key, false);
    }
}