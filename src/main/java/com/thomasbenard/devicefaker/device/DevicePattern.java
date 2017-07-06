package com.thomasbenard.devicefaker.device;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thomasbenard on 05/07/2017.
 */
public class DevicePattern {
    public DevicePattern(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        DevicePattern that = (DevicePattern) other;

        return pattern.pattern().equals(that.pattern.pattern());
    }

    @Override
    public int hashCode() {
        return pattern.hashCode();
    }

    public Matcher matcher(String s) {
        return pattern.matcher(s);
    }

    private Pattern pattern;
}
