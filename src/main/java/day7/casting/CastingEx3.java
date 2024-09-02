package day7.casting;

public class CastingEx3 {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();

        warrior.age = 20;

    }
}

class ColdWeapon {

}

class LongBow extends ColdWeapon {
    ColdWeapon coldWeapon;

}

class DoranSword extends ColdWeapon{

}

class Warrior {
    int age;
}