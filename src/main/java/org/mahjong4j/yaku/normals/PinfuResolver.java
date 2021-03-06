package org.mahjong4j.yaku.normals;


import org.mahjong4j.hands.MentsuComp;
import org.mahjong4j.hands.Shuntsu;
import org.mahjong4j.hands.Toitsu;
import org.mahjong4j.tile.MahjongTile;
import org.mahjong4j.tile.MahjongTileType;

import java.util.List;

import static org.mahjong4j.yaku.normals.MahjongYakuEnum.PINFU;

/**
 * 平和判定クラス
 * 面子が全て順子で、雀頭が役牌でなく、待ちが両面待ちになっている場合に成立
 *
 * @author yu1ro
 */
public class PinfuResolver implements NormalYakuResolver {
    private MahjongYakuEnum yakuEnum = PINFU;

    private Toitsu janto;
    private int shuntsuCount;
    private List<Shuntsu> shuntsuList;
    private MahjongTile last;


    public PinfuResolver(MentsuComp comp) {
        janto = comp.getJanto();
        shuntsuCount = comp.getShuntsuCount();
        shuntsuList = comp.getShuntsuList();
        last = comp.getLast();
    }

    public MahjongYakuEnum getNormalYaku() {
        return yakuEnum;
    }

    public boolean isMatch() {
        if (shuntsuCount < 4) {
            return false;
        }
        //雀頭が三元牌の場合はfalse
        // TODO: 自風牌 場風牌の場合もfalse
        if (janto.getTile().getType() == MahjongTileType.SANGEN) {
            return false;
        }

        boolean isRyanmen = false;
        for (Shuntsu shuntsu : shuntsuList) {
            //鳴いていた場合もfalse
            if (shuntsu.getIsOpen()) {
                return false;
            }

            //両面待ちならそれを保存しておく
            if (isRyanmen(shuntsu, last)) {
                isRyanmen = true;
            }
        }

        return isRyanmen;
    }

    /**
     * 両面待ちだったかを判定するため
     * 一つ一つの順子と最後の牌について判定する
     *
     * @param shuntsu 判定したい順子
     * @param last    最後の牌
     * @return 両面待ちだったか
     */
    private boolean isRyanmen(Shuntsu shuntsu, MahjongTile last) {
        //ラスト牌と判定したい順子のtypeが違う場合はfalse
        if (shuntsu.getTile().getType() != last.getType()) {
            return false;
        }

        int shuntsuNum = shuntsu.getTile().getNumber();
        int lastNum = last.getNumber();
        if (shuntsuNum == 2 && lastNum == 1) {
            return true;
        }

        if (shuntsuNum == 8 && lastNum == 9) {
            return true;
        }

        int i = shuntsuNum - lastNum;
        if (i == 1 || i == -1) {
            return true;
        }

        return false;
    }
}
