package com.thomasbenard.devicefaker.device;

import com.thomasbenard.devicefaker.NoMatchFoundException;

import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thomasbenard on 27/06/2017.
 */
public class Device {

    public String generateResponseTo(String s) throws NoMatchFoundException {
        for (DevicePattern pattern : dictionary.keySet()) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches())
                return dictionary.get(pattern);
        }
        throw new NoMatchFoundException();
    }

    public void addPattern(String regex, String response) {
        dictionary.put(new DevicePattern(regex), response);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Device device = (Device) other;

        return dictionary != null ? dictionary.equals(device.dictionary) : device.dictionary == null;
    }

    @Override
    public int hashCode() {
        return dictionary != null ? dictionary.hashCode() : 0;
    }

    private boolean isPatternFound(Pattern pattern, Map<Pattern, String> otherDictionary) {
        boolean patternFound = false;
        for(Pattern otherPattern : otherDictionary.keySet())
            patternFound = pattern.pattern().equals(otherPattern.pattern());
        return patternFound;
    }

    private final Map<DevicePattern, String> dictionary = new Hashtable<DevicePattern, String>();
}
