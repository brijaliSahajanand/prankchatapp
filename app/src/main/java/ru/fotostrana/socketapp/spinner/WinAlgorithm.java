package ru.fotostrana.socketapp.spinner;

import android.util.SparseIntArray;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mehul on 29/12/17.
 */

public class WinAlgorithm {
    private int[] coin;
    private int wCoin;
    private Random random = new Random();

    public WinAlgorithm(int[] coin) {
        this.coin = coin;
    }

    public SparseIntArray getWinMap(int winCoin, int winMaxAmountCount, boolean willWinSpin) {
        ArrayList<Integer> list = new ArrayList<>();

        if (coin.length > 2)
            for (int i = 0; i < winMaxAmountCount; i++) {
                if (winCoin - coin[coin.length - 2] >= 0) {
                    list.add(coin.length - 2);
                    winCoin -= coin[coin.length - 2];
                } else break;
            }

        if (willWinSpin)
            list.add(coin.length - 1);

        for (int i = 0; i < 10 - list.size(); i++) {
            int rand = random.nextInt(coin.length);
            if (winCoin <= 0) {
                list.add(0);
                winCoin -= coin[0];
            } else {
                if (winCoin - coin[rand] >= 0) {
                    list.add(rand);
                    winCoin -= coin[rand];
                } else {
                    do {
                        rand = random.nextInt(coin.length);
                    } while (winCoin - coin[rand] < 0);
                    list.add(rand);
                    winCoin -= coin[rand];
                }
            }
        }

        SparseIntArray winMap = new SparseIntArray();

        ArrayList<Integer> winSpinValuePos = new ArrayList<>();
        winSpinValuePos.clear();
        for (int i = 0; i < list.size(); i++) {
            int a = random.nextInt(list.size());
            while (winSpinValuePos.contains(a)) {
                a = random.nextInt(list.size());
            }
            winSpinValuePos.add(a);
        }
        for (int i = 0; i < list.size(); i++) {
            winMap.put(i, list.get(winSpinValuePos.get(i)));
        }
        return winMap;
    }
}
