package es.upm.miw.iwvg_devops.code;

public class Searches {

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id)) 
                .flatMap(user -> user.getFractions().stream()) 
                .filter(fraction -> fraction.isProper()) 
                .findFirst() 
                .orElse(null); 
    }
}
