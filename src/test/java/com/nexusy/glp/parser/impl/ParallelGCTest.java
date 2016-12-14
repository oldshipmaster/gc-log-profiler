package com.nexusy.glp.parser.impl;

import com.nexusy.glp.data.ParallelGCData;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * @author lanhuidong
 * @since 2016-12-08
 */
public class ParallelGCTest extends GCLogLineParserTest {

    private ParallelGCParser parser = new ParallelGCParser();

    @Test
    public void testMinorGCLogJDK8() {
        String line = "2016-12-08T11:03:32.470+0800: 3.164: [GC (Allocation Failure) "
                + "[PSYoungGen: 3137K->1024K(5120K)] 7868K->7803K(18944K), 0.0020042 secs] "
                + "[Times: user=0.00 sys=0.00, real=0.00 secs] ";
        ParallelGCData data = parser.parse(line);
        assertNotNull(data);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-08T11:03:32.470+0800", formatter);
        assertEquals(dateTime, data.getDateTime());
        assertEquals(3164L, data.getUptime());
        assertEquals("GC", data.getFlag());
        assertEquals("Allocation Failure", data.getCause());
        assertEquals(3137L, data.getYoungGenUsageBfGC());
        assertEquals(1024L, data.getYoungGenUsageAfGC());
        assertEquals(5120L, data.getYongGenSize());
        assertEquals(7868L, data.getHeapUsageBfGC());
        assertEquals(7803L, data.getHeadUsageAfGC());
        assertEquals(18944L, data.getHeapSize());
        assertEquals(0.0020042, data.getTotalDuration(), 0.00000001);
        assertEquals(0.00, data.getUserTime(), 0.001);
        assertEquals(0.00, data.getSysTime(), 0.001);
        assertEquals(0.00, data.getRealTime(), 0.001);
    }

    @Test
    public void testFullGCLogJDK8() {
        String line = "2016-12-08T11:03:32.501+0800: 3.191: [Full GC (Ergonomics) "
                + "[PSYoungGen: 1024K->0K(5120K)] [ParOldGen: 12923K->5755K(13824K)] 13947K->5755K(18944K), "
                + "[Metaspace: 2583K->2583K(1056768K)], 0.0076736 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] ";
        ParallelGCData data = parser.parse(line);
        assertNotNull(data);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-08T11:03:32.501+0800", formatter);
        assertEquals(dateTime, data.getDateTime());
        assertEquals(3191L, data.getUptime());
        assertEquals("Full GC", data.getFlag());
        assertEquals("Ergonomics", data.getCause());
        assertEquals(1024L, data.getYoungGenUsageBfGC());
        assertEquals(0L, data.getYoungGenUsageAfGC());
        assertEquals(5120L, data.getYongGenSize());
        assertEquals(12923L, data.getOldGenUsageBfGC());
        assertEquals(5755L, data.getOldGenUsageAfGC());
        assertEquals(13824L, data.getOldSize());
        assertEquals(13947L, data.getHeapUsageBfGC());
        assertEquals(5755L, data.getHeadUsageAfGC());
        assertEquals(18944L, data.getHeapSize());
        assertEquals(0.0076736, data.getTotalDuration(), 0.00000001);
        assertEquals(0.00, data.getUserTime(), 0.001);
        assertEquals(0.00, data.getSysTime(), 0.001);
        assertEquals(0.00, data.getRealTime(), 0.001);
    }

    @Test
    public void testMinorGCLogJDK7() {
        String line = "2016-12-08T11:08:16.047+0800: 2.136: "
                + "[GC [PSYoungGen: 3074K->1024K(5120K)] 13826K->13824K(18944K), 0.0023574 secs] "
                + "[Times: user=0.00 sys=0.00, real=0.00 secs] ";
        ParallelGCData data = parser.parse(line);
        assertNotNull(data);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-08T11:08:16.047+0800", formatter);
        assertEquals(dateTime, data.getDateTime());
        assertEquals(2136L, data.getUptime());
        assertEquals("GC", data.getFlag());
        assertNull(data.getCause());
        assertEquals(3074L, data.getYoungGenUsageBfGC());
        assertEquals(1024L, data.getYoungGenUsageAfGC());
        assertEquals(5120L, data.getYongGenSize());
        assertEquals(13826L, data.getHeapUsageBfGC());
        assertEquals(13824L, data.getHeadUsageAfGC());
        assertEquals(18944L, data.getHeapSize());
        assertEquals(0.0023574, data.getTotalDuration(), 0.00000001);
        assertEquals(0.00, data.getUserTime(), 0.001);
        assertEquals(0.00, data.getSysTime(), 0.001);
        assertEquals(0.00, data.getRealTime(), 0.001);
    }

    @Test
    public void testFullGCLogJDK7() {
        String line = "2016-12-08T11:08:16.063+0800: 2.139: [Full GC [PSYoungGen: 1024K->0K(5120K)] "
                + "[ParOldGen: 12800K->6656K(13824K)] 13824K->6656K(18944K) "
                + "[PSPermGen: 2523K->2523K(21504K)], 0.0131346 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] ";
        ParallelGCData data = parser.parse(line);
        assertNotNull(data);
        LocalDateTime dateTime = LocalDateTime.parse("2016-12-08T11:08:16.063+0800", formatter);
        assertEquals(dateTime, data.getDateTime());
        assertEquals(2139L, data.getUptime());
        assertEquals("Full GC", data.getFlag());
        assertNull(data.getCause());
        assertEquals(1024L, data.getYoungGenUsageBfGC());
        assertEquals(0L, data.getYoungGenUsageAfGC());
        assertEquals(5120L, data.getYongGenSize());
        assertEquals(12800L, data.getOldGenUsageBfGC());
        assertEquals(6656L, data.getOldGenUsageAfGC());
        assertEquals(13824L, data.getOldSize());
        assertEquals(13824L, data.getHeapUsageBfGC());
        assertEquals(6656L, data.getHeadUsageAfGC());
        assertEquals(18944L, data.getHeapSize());
        assertEquals(2523L, data.getMetaspaceUsageBfGC());
        assertEquals(2523L, data.getMetaspaceUsageAfGC());
        assertEquals(21504L, data.getMetaspaceSize());
        assertEquals(0.0131346, data.getTotalDuration(), 0.00000001);
        assertEquals(0.00, data.getUserTime(), 0.001);
        assertEquals(0.00, data.getSysTime(), 0.001);
        assertEquals(0.00, data.getRealTime(), 0.001);
    }
}
