package ru.tinkoff.utils;

public class TestData {

    RandomUtils randomUtils = new RandomUtils();

    public String randomShortWrongPhone = randomUtils.getShortWrongPhone();
    public String randomLongWrongPhone = randomUtils.getLongWrongPhone();
    public String randomCorrectPhone = randomUtils.getCorrectPhone();
    public String randomWrongSmsCode = randomUtils.getWrongSmsCode();
}
