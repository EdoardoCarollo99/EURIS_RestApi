package it.euris.restapi.dao;

public interface IDaoCalculator {

    /**
     *Executes the sum of the input values and returns it
     * @param operation
     * @return String sum
     */
    public String sum(String operation);

    /**
     * Performs subtraction between input values and returns it
     * @param operation
     * @return String subtraction
     */
    public String subtraction(String operation);

    /**
     * Performs multiplication between input values and returns it
     * @param operation
     * @return String multiplication
     */
    public String multiplication(String operation);

    /**
     * Performs division between input values and returns it
     * @param dividend
     * @param numberDivider
     * @return String division;
     */
    public String division(String dividend, String numberDivider);
}
