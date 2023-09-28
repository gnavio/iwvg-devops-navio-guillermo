package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id)) 
                .flatMap(user -> user.getFractions().stream()) 
                .filter(fraction -> fraction.isProper()) 
                .findFirst() 
                .orElse(null); 
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .filter(fraction -> (fraction.getNumerator() < 0 && fraction.getDenominator() > 0)
                        || (fraction.getNumerator() > 0 && fraction.getDenominator() < 0))
                .map(fraction -> fraction.decimal());
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.isNegative()))
                .map(user -> user.getFamilyName()) 
                .distinct();
    }
}
