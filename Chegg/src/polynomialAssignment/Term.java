package polynomialAssignment;

public class Term {
	private double coefficient;
	private int power;

	/**
     * Default constructor for Term class, sets both coefficient and exponent to integer value 1.
     */
    public Term()
    {
        this.setAll(1, 1);
    }
    
	/**
	A constructor to initialize a single term with a given coefficient and power
	@param coefficent the coefficient
	@param power the power
	*/
	public Term(double coefficient, int power)
	{
	this.coefficient = coefficient;
	this.power = power;
	}

	/**
     * Copy constructor for Term class, copies coefficient and exponent from other and sets them
     * to local variables.
     *
     * @param other The term you want to copies the values from
     */
    public Term(Term other)
    {
        if (other == null)
        {
            throw new NullPointerException();
        }
        else
        {
            this.setAll(other.getCoefficient(), other.getPower());
        }
    }
    
	public void setAll(double d, int exponent)
    {
		this.coefficient = d;
		this.power = power;
    }
	/**
	@return the coefficient
	*/
	public double getCoefficient()
	{
	return coefficient;
	}

	/**
	@return the power
	*/
	public int getPower()
	{
	return power;
	}

	/**
	Multiplies two coefficient together and returns the result
	@param t the other term
	@return this * t as a term
	*/
	public Term multiply(Term t)
	{
	return new Term(coefficient * t.coefficient, power + t.power);
	}
	
	/**
     * Adds local term with given term if both exponents match, otherwise no sum is calculated and null is returned.
     * @param other The other term to add to local term.
     * @return A new Term with both coefficients added together, if exponents do NOT match then null will be returned.
     */
    public Term plus(Term other)
    {
        return addIfSamePower(other);
    }

	/**
	Adds the term to this term if the powers are the same
	@param t the term to attempt to add
	*/
	public Term addIfSamePower(Term t)
	{
		 Term temp = null;
	     double coefficientSum;
		if (t.power == power)
		{
			coefficientSum = coefficient + t.coefficient;
			if (coefficientSum == 0)
	        {
	            return null;
	        }
	        else
	        {
	            temp = new Term(coefficientSum, t.power);
	        }
		
		}
		return temp;
	}

	/**
	Returns a string representation of the term with a ^ representing the exponent
	@return a string representation of a term
	*/
	public String toString()
	{
	if (power == 0)
	{
	return Math.abs(coefficient) + "";
	}
	else if (power == 1)
	{
	return Math.abs(coefficient) + "x";
	}
	else
	{
	return Math.abs(coefficient) + "x^" + power;
	}
	}
	
	/**
     * Comparable implementation for Term class. Compares the exponent value in this Term with other
     *
     * @param other
     * @return returns -1 if this exponent preceeds other
     * returns 1 if this exponent exceeds other
     * returns 0 if both exponents are equal
     */
    public int compareTo(Object other)
    {
        Term otherTerm = (Term) other;
        if (this.power > otherTerm.getPower())
        {
            return 1;
        }
        else if (this.power < otherTerm.getPower())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
