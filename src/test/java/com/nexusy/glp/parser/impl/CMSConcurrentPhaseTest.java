package com.nexusy.glp.parser.impl;

import com.nexusy.glp.data.CMSConcurrentData;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lanhuidong
 * @since 2016-12-13
 */
public class CMSConcurrentPhaseTest {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    CMSConcurrentParser parser = new CMSConcurrentParser();

    @Test
    public void testConcurrentMarkJDK8() {
        String line = "2016-12-13T15:43:55.509+0800: 4.430: [CMS-concurrent-mark: 0.001/0.001 secs] "
                + "[Times: user=0.00 sys=0.00, real=0.00 secs] ";
        CMSConcurrentData data = parser.parse(line);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-13T15:43:55.509+0800", formatter);
        Assert.assertEquals(dateTime, data.getDateTime());
        Assert.assertEquals(4430, data.getUptime());
        Assert.assertEquals("CMS-concurrent-mark", data.getPhase());
        Assert.assertEquals(0.001, data.getElapsedTime(), 0.0001);
        Assert.assertEquals(0.001, data.getClockTime(), 0.0001);
        Assert.assertEquals(0.00, data.getUserTime(), 0.001);
        Assert.assertEquals(0.00, data.getSysTime(), 0.001);
        Assert.assertEquals(0.00, data.getRealTime(), 0.001);
    }

    @Test
    public void testConcurrentPrecleanJDK8() {
        String line = "2016-12-13T15:43:55.509+0800: 4.430: [CMS-concurrent-preclean: 0.000/0.000 secs] "
                + "[Times: user=0.00 sys=0.00, real=0.00 secs] ";
        CMSConcurrentData data = parser.parse(line);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-13T15:43:55.509+0800", formatter);
        Assert.assertEquals(dateTime, data.getDateTime());
        Assert.assertEquals(4430, data.getUptime());
        Assert.assertEquals("CMS-concurrent-preclean", data.getPhase());
        Assert.assertEquals(0.000, data.getElapsedTime(), 0.0001);
        Assert.assertEquals(0.000, data.getClockTime(), 0.0001);
        Assert.assertEquals(0.00, data.getUserTime(), 0.001);
        Assert.assertEquals(0.00, data.getSysTime(), 0.001);
        Assert.assertEquals(0.00, data.getRealTime(), 0.001);
    }

    @Test
    public void testConcurrentAbortablePrecleanJDK8() {
        String line = "2016-12-13T15:43:51.700+0800: 0.621: [CMS-concurrent-abortable-preclean: 0.000/0.203 secs] "
                + "[Times: user=0.00 sys=0.00, real=0.20 secs] ";
        CMSConcurrentData data = parser.parse(line);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-13T15:43:51.700+0800", formatter);
        Assert.assertEquals(dateTime, data.getDateTime());
        Assert.assertEquals(621, data.getUptime());
        Assert.assertEquals("CMS-concurrent-abortable-preclean", data.getPhase());
        Assert.assertEquals(0.000, data.getElapsedTime(), 0.0001);
        Assert.assertEquals(0.203, data.getClockTime(), 0.0001);
        Assert.assertEquals(0.00, data.getUserTime(), 0.001);
        Assert.assertEquals(0.00, data.getSysTime(), 0.001);
        Assert.assertEquals(0.20, data.getRealTime(), 0.001);
    }

    @Test
    public void testConcurrentSweepJDK8() {
        String line = "2016-12-13T15:43:55.953+0800: 4.874: [CMS-concurrent-sweep: 0.000/0.000 secs] "
                + "[Times: user=0.00 sys=0.00, real=0.00 secs] ";
        CMSConcurrentData data = parser.parse(line);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-13T15:43:55.953+0800", formatter);
        Assert.assertEquals(dateTime, data.getDateTime());
        Assert.assertEquals(4874, data.getUptime());
        Assert.assertEquals("CMS-concurrent-sweep", data.getPhase());
        Assert.assertEquals(0.000, data.getElapsedTime(), 0.0001);
        Assert.assertEquals(0.000, data.getClockTime(), 0.0001);
        Assert.assertEquals(0.00, data.getUserTime(), 0.001);
        Assert.assertEquals(0.00, data.getSysTime(), 0.001);
        Assert.assertEquals(0.00, data.getRealTime(), 0.001);
    }

    @Test
    public void testConcurrentResetJDK8() {
        String line = "2016-12-13T15:43:55.953+0800: 4.875: [CMS-concurrent-reset: 0.002/0.002 secs] "
                + "[Times: user=0.00 sys=0.00, real=0.00 secs] ";
        CMSConcurrentData data = parser.parse(line);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-13T15:43:55.953+0800", formatter);
        Assert.assertEquals(dateTime, data.getDateTime());
        Assert.assertEquals(4875, data.getUptime());
        Assert.assertEquals("CMS-concurrent-reset", data.getPhase());
        Assert.assertEquals(0.002, data.getElapsedTime(), 0.0001);
        Assert.assertEquals(0.002, data.getClockTime(), 0.0001);
        Assert.assertEquals(0.00, data.getUserTime(), 0.001);
        Assert.assertEquals(0.00, data.getSysTime(), 0.001);
        Assert.assertEquals(0.00, data.getRealTime(), 0.001);
    }
}
