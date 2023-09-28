package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id)) 
                .flatMap(user -> user.getFractions().stream()) 
                .filter(Fraction::isProper) 
                .findFirst() 
                .orElse(null); 
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isNegative)
                .map(Fraction::decimal);
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isNegative))
                .map(User::getFamilyName) 
                .distinct();
                //
                // BUG FIXED
                //
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(user -> user.getFractions().stream()
                        .reduce(new Fraction(0, 1), Fraction::add))
                .orElse(new Fraction(0, 1)); 
    }
}
