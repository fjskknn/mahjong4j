package org.mahjong4j.yaku.yakuman;

import org.mahjong4j.hands.Kotsu;
import org.mahjong4j.hands.MentsuComp;
import org.mahjong4j.tile.MahjongTileType;

import java.util.List;

import static org.mahjong4j.yaku.yakuman.MahjongYakumanEnum.DAISANGEN;

/**
 * 大三元判定クラス
 * 白・發・中の3種類をすべて刻子または槓子にして和了した場合に成立
 *
 * @author yu1ro
 */
public class DaisangenResolver implements YakumanResolver {
    private MahjongYakumanEnum yakuman = DAISANGEN;

    private List<Kotsu> kotsuList;

    public DaisangenResolver(MentsuComp comp) {
        kotsuList = comp.getKotsuKantsu();
    }

    public MahjongYakumanEnum getYakuman() {
        return yakuman;
    }

    public boolean isMatch() {
        int sangenCount = 0;
        for (Kotsu kotsu : kotsuList) {
            if (kotsu.getTile().getType() == MahjongTileType.SANGEN) {
                sangenCount++;
            }
        }

        return sangenCount == 3;
    }
}
