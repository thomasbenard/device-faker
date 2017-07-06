package com.thomasbenard.devicefaker;

import com.thomasbenard.devicefaker.device.Device;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by thomasbenard on 27/06/2017.
 */
public class RulesetParserTest {
    @Test(expected = NoMatchFoundException.class)
    public void should_do_nothing_when_given_empty_ruleset() throws NoMatchFoundException {
        RulesetParser rulesetParser = new RulesetParser();
        Device device = rulesetParser.generateDevice("");
        device.generateResponseTo("");
    }

//    @Test
//    public void should_create_good_device() {
//        RulesetParser rulesetParser = new RulesetParser();
//        Device device = rulesetParser.generateDevice("getValue\\d:1234");
//        Device expectedDevice = new Device();
//        expectedDevice.addPattern("getValue\\d", "1234");
//        assertEquals(expectedDevice, device);
//    }
}
