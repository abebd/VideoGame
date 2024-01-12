package config;

import java.awt.Color;

public class Config {

    // TODO: Create an engine and read these values from a .propreties file

    // Why static? Idk...
    private final static int SPELL_OVERLAY_COLOR_OPACITY = 178;

    public final static Color SPELL_OVERLAY_COLOR_INVALID_TILE = new Color(255, 99, 71, SPELL_OVERLAY_COLOR_OPACITY);
    public final static Color SPELL_OVERLAY_COLOR_VALID_TILE = new Color(70, 252, 0, SPELL_OVERLAY_COLOR_OPACITY);
    public final static Color SPELL_OVERLAY_COLOR_HOVER_TILE = new Color(30, 144, 255, SPELL_OVERLAY_COLOR_OPACITY);

    // DEBUG OPTIONS
    public final static boolean DEBUG_MODE = true;
    public final static boolean DEBUG_ADD_OPTIONS_ON_CONTEXT_MENU = true;
    public final static boolean DEBUG_PRINT_CAMERA_MOVEMENT = false;
    public final static boolean DEBUG_PRINT_PLAYER_MOVEMENT = false;
    public final static boolean DEBUG_PRINT_ABILITY_STATUS = false;

    public void printSettings() {
        System.out.printf("SETTINGS:\n");
        System.out.printf("\tDEBUG_MODE                         = %s\n", DEBUG_MODE);
        System.out.printf("\tDEBUG_ADD_OPTIONS_ON_CONTEXT_MENU  = %s\n", DEBUG_ADD_OPTIONS_ON_CONTEXT_MENU);
        System.out.printf("\tDEBUG_PRINT_CAMERA_MOVEMENT        = %s\n", DEBUG_PRINT_CAMERA_MOVEMENT);
        System.out.printf("\tDEBUG_PRINT_PLAYER_MOVEMENT        = %s\n", DEBUG_PRINT_PLAYER_MOVEMENT);
        System.out.printf("\tDEBUGG_PRINT_ABILITY_STATUS        = %s\n", DEBUG_PRINT_CAMERA_MOVEMENT);
    }

}
