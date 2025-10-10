package dice;

/**
 * Declaring dice as an interface (abstract type).
 * This avoids the compiler creating various instances that are not required.
 * Allowing us at runtime time only, which concrete implementation to apply (instantiate).
 */
public interface DiceShaker {
    int shake();
}
