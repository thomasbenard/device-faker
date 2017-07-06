package com.thomasbenard.devicefaker.device;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by thomasbenard on 05/07/2017.
 */
public class DevicePatternTest {

    @Test
    public void equals_should_return_true_when_given_equal_values() {
        DevicePattern devicePattern = new DevicePattern("hello");
        DevicePattern otherDevicePattern = new DevicePattern("hello");
        assertEquals(devicePattern, otherDevicePattern);
    }

    @Test
    public void equals_should_return_false_when_given_different_values() {
        DevicePattern devicePattern = new DevicePattern("hello");
        DevicePattern otherDevicePattern = new DevicePattern("helloWorld !");
        assertNotEquals(devicePattern, otherDevicePattern);
    }

}