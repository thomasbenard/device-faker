package com.thomasbenard.devicefaker;

import com.thomasbenard.devicefaker.device.Device;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by thomasbenard on 27/06/2017.
 */
public class DeviceTest {

    private Device device;

    @Before
    public void setUp() throws Exception {
        device = new Device();
    }

    @Test(expected = NoMatchFoundException.class)
    public void should_throw_exception_when_there_is_no_match() throws NoMatchFoundException {
        device.generateResponseTo("fake command");
    }

    @Test
    public void should_generate_response_when_there_is_simple_match() throws NoMatchFoundException {
        device.addPattern("cmd", "response");
        assertEquals("response", device.generateResponseTo("cmd"));
    }

    @Test
    public void should_generate_response_when_there_is_regex_match() throws NoMatchFoundException {
        device.addPattern("getValue\\d", "42");
        assertEquals("42", device.generateResponseTo("getValue0"));
    }

    @Test
    public void equals_should_check_rules_equality() {
        device.addPattern("getValue\\d", "42");
        Device newDevice = new Device();
        newDevice.addPattern("getValue\\d", "42");
        assertEquals(device, newDevice);
    }

    @Ignore
    @Test
    public void equals_should_return_false_when_rules_are_different() {
        device.addPattern("getValue\\d", "42");
        Device deviceDifferentPattern = new Device();
        deviceDifferentPattern.addPattern("setValue", "42");
        assertNotEquals(device, deviceDifferentPattern);
        Device deviceSamePattern = new Device();
        deviceSamePattern.addPattern("getValue\\d", "51");
        assertNotEquals(device, deviceSamePattern);
    }
}
