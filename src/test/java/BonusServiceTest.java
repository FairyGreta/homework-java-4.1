import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1_000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    // используем метод граничных значений для зарегистрированных пользователей
    // зарегистрированный аккаунт должен получить 499 бонусов
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit499() {
        BonusService service = new BonusService();

        long amount = 16_634;
        boolean registered = true;
        long expected = 499;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    // зарегистрированный аккаунт должен получить 500 бонусов
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit500() {
        BonusService service = new BonusService();

        long amount = 16_667;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    // зарегистрированный аккаунт не может получить 501 бонус
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderOverLimit501() {
        BonusService service = new BonusService();

        long amount = 16_700;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    // зарегистрированный аккаунт не может получить меньше 0 бонусов
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndBelowLimit0() {
        BonusService service = new BonusService();

        long amount = -1;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    // зарегистрированный аккаунт получит 0 бонусов
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndСongruentlyLimit0() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    // зарегистрированный аккаунт получит 1 бонус
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit1() {
        BonusService service = new BonusService();

        long amount = 34;
        boolean registered = true;
        long expected = 1;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    //используем метод граничных значений для незарегистрированных пользователей
    // незарегистрированный аккаунт получит 499 бонус
    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndUnderLimit499() {
        BonusService service = new BonusService();

        long amount = 49_900;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    //незарегистрированный аккаунт получит 500 бонусов
    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndUnderLimit500() {
        BonusService service = new BonusService();

        long amount = 50_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    //незарегистрированный аккаунт не может получить 501 бонус
    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndOverLimit501() {
        BonusService service = new BonusService();

        long amount = 51_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    //незарегистрированный аккаунт не может получить меньше 0 бонусов
    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndBelowLimit0() {
        BonusService service = new BonusService();

        long amount = -1;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    //незарегистрированный аккаунт получит 0 бонусов
    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndСongruentlyLimit0() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    //незарегистрированный аккаунт получит 1 бонус
    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndUnderLimit1() {
        BonusService service = new BonusService();

        long amount = 100;
        boolean registered = false;
        long expected = 1;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}
