package org.mahjong4j.hands;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mahjong4j.tile.MahjongTile.CHN;

/**
 * @author yu1ro
 */
public class MahjongHandsKokushimusoTest {
    private MahjongHands actual;

    @Before
    public void setUp() throws Exception {
        int[] tiles = {
            1, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 2, 1, 1,
            1, 1, 1,
        };

        actual = new MahjongHands(tiles , CHN);
    }

    @Test
    public void testGetMentsuCompList() throws Exception {
        assertEquals(0, actual.getMentsuCompList().size());
    }

    @Test
    public void testGetCanWin() throws Exception {
        assertTrue(actual.getCanWin());
    }

    @Test
    public void testGetLast() throws Exception {
        assertEquals(CHN, actual.getLast());
    }

    @Test
    public void testGetHandsComp() throws Exception {
        int[] expected = {
            1, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 0, 0, 0, 0, 0, 0, 0, 1,
            1, 2, 1, 1,
            1, 1, 1,
        };

        assertArrayEquals(expected, actual.getHandsComp());
    }
}