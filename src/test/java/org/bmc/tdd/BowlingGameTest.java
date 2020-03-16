package org.bmc.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BowlingGameTest {

    BowlingGame theGame;

    @BeforeEach
    void setUp() {
        theGame = new BowlingGame();
    }

    @Test
    public void shouldScoreOneWhenNoRolls() {
        assertThat(theGame.getScore()).isEqualTo(0);
    }

    @Test
    void shouldScore0WhenNoPinDown20Times() {
        roll1(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(theGame.getScore()).isEqualTo(0);
    }

    @Test
    void shouldScore20WhenOnePinDown20Times() {
        roll1(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertThat(theGame.getScore()).isEqualTo(20);
    }

    @Test
    void shouldScoreSpare() {
        roll1(5, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(theGame.getScore()).isEqualTo(18);
    }

    @Test
    void shouldScoreStrike() {
        roll1(10, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(theGame.getScore()).isEqualTo(26);
    }

    @Test
    void shouldScoreMasterStrike() {
        roll1(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertThat(theGame.getScore()).isEqualTo(300);
    }

    private void roll1(int... pins) {
        for (int pin : pins) {
            theGame.roll(pin);
        }
    }

    //this is obsolete, but I keep it as a historical version some may prefer ;)
    private void roll(int numberOfThrows, int pins) {
        for (int i = 0; i < numberOfThrows; i++) {
            theGame.roll(pins);
        }
    }
}