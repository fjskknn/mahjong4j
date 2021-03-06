package org.mahjong4j.yaku.normals;

import org.junit.Before;
import org.junit.Test;
import org.mahjong4j.hands.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mahjong4j.tile.MahjongTile.*;
import static org.mahjong4j.yaku.normals.MahjongYakuEnum.SANANKO;

/**
 * @author yu1ro
 */
public class SanankoResolverTest {
    private SanankoResolver resolver;

    @Before
    public void setUp() throws Exception {
        List<MahjongMentsu> list = new ArrayList<>(5);
        list.add(new Toitsu(CHN));
        list.add(new Shuntsu(false, P2));
        list.add(new Kantsu(false, HAT));
        list.add(new Kotsu(false, HAK));
        list.add(new Kotsu(false, SHA));
        MentsuComp comp = new MentsuComp(list, P3);
        resolver = new SanankoResolver(comp);
    }

    @Test
    public void testGetNormalYaku() throws Exception {
        assertEquals(SANANKO, resolver.getNormalYaku());
    }

    @Test
    public void testIsMatch() throws Exception {
        assertTrue(resolver.isMatch());
    }
}