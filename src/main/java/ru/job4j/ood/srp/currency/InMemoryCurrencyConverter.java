package ru.job4j.ood.srp.currency;

import java.util.Arrays;

public class InMemoryCurrencyConverter implements CurrencyConverter {
    private static final int CURRENCIES_COUNT = Currency.values().length;
    private final double[][] conversationTable = new double[CURRENCIES_COUNT][CURRENCIES_COUNT];

    public InMemoryCurrencyConverter() {
        this.conversationTable[Currency.RUB.ordinal()][Currency.USD.ordinal()] = 0.012;
        this.conversationTable[Currency.RUB.ordinal()][Currency.EUR.ordinal()] = 0.011;
        this.conversationTable[Currency.USD.ordinal()][Currency.EUR.ordinal()] = 0.92;
        this.conversationTable[Currency.USD.ordinal()][Currency.RUB.ordinal()] = 84.97;
        this.conversationTable[Currency.EUR.ordinal()][Currency.USD.ordinal()] = 1.09;
        this.conversationTable[Currency.EUR.ordinal()][Currency.RUB.ordinal()] = 92.76;
    }

    @Override
    public double convert(Currency source, double sourceValue, Currency target) {
        return sourceValue * conversationTable[source.ordinal()][target.ordinal()];
    }
}
