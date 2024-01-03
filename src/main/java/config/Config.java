package config;

import java.awt.Color;

public class Config {

    // TODO: Create an engine and read these values from a .propreties file

    // Why static? Idk...
    private final static int SPELL_OVERLAY_COLOR_OPACITY = 178;

    public final static Color SPELL_OVERLAY_COLOR_INVALID_TILE = new Color(255, 99, 71, SPELL_OVERLAY_COLOR_OPACITY);
    public final static Color SPELL_OVERLAY_COLOR_VALID_TILE = new Color(70, 252, 0, SPELL_OVERLAY_COLOR_OPACITY);
    public final static Color SPELL_OVERLAY_COLOR_HOVER_TILE = new Color(30, 144, 255, SPELL_OVERLAY_COLOR_OPACITY);
}
