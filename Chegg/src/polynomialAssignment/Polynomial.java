package polynomialAssignment;

import java.util.LinkedList;
import java.util.ListIterator;
/**
A class to represent a polynomial.
*/
public class Polynomial
{
	 private final static char PLUS_SYMBOL = '+';

    // Class variables
    private LinkedList<Term> termList;
	/**
	Constructs an empty polynomial
	*/
	public Polynomial()
	{
		this.termList = new LinkedList();
	}
	
	/**
	Constructs a new polynomial with the given term
	@param t the term to initialize the polynomial with
	*/
	public Polynomial(Term t)
	{
		this.termList = new LinkedList();
		termList.add(t);
	}
	/**
     * The term count accessor for this polynomial.
     *
     * @return integer representing  term count in this polynomial.
     */
	public int getNumTerms()
    {
        return this.termList.size();
    }
	
	/**
     * Returns a deep copy of the term at the index given.
     *
     * @param index the location of the term you want to access.
     * @return a new Term from desired index.
     */
    public Term getTerm(int index)
    {
        return new Term(this.termList.get(index));
    }
	
	/**
	Adds the polynomial such that the terms are in sorted order
	from highest power to lowest
	@param p the polynomial to add
	*/
	public void add(Polynomial p)
	{
		for (int i = 0; i < p.getNumTerms(); i++)
        {
            this.addTerm(p.getTerm(i));
        }
	}
	
	/**
	Multiplies the given polynomial with this one and returns the result
	@param p the polynomial to multiply
	@return this * p
	*/
	public Polynomial multiply(Polynomial p)
	{
		return p;
		
	}
	
	/**
	Prints the polynomial "nicely" so that it reads
	from highest term to lowest and doesn't have a
	leading "+" if the first term is positive.
	*/
	public void print()
	{
		String temp;

        if (this.termList == null || this.termList.size() == 0)
        {
            temp = "0";
        }
        else
        {
            temp = "";

            for (Term term : termList)
            {
                temp += term.toString();
            }

            if (temp.charAt(0) == PLUS_SYMBOL)
            {
                temp = temp.substring(1);
            }
        }

        System.out.println(temp);
	}
	
	/**
     * adds the given term to this polynomial in the correct position, going from highest exponent to lowest.
     * if given term's exponent has the same value as local term's exponent, then both terms will be added
     * together then the result would be inserted into the position occupied by local term, unless the coefficient
     * sum = 0 in which case the local term will be removed from the list.
     *
     * @param termToAdd the term you would like to add to this polynomial.
     */
    public void addTerm(Term termToAdd)
    {
        // local variable
        Term localTerm, currentTerm, nextTerm, sum;
        int lastIndex;

        // If list is empty, add term to index 0
        if (this.termList.size() == 0)
        {
            this.termList.add(termToAdd);
        }
        // else if only one element in list
        else if (this.termList.size() == 1)
        {
            localTerm = termList.get(0);
            if (termToAdd.compareTo(localTerm) == 1)
            {
                termList.add(0, termToAdd);
            }
            else if (termToAdd.compareTo(localTerm) == 0)
            {

                sum = termToAdd.plus(localTerm);
                if (sum != null)
                {
                    termList.set(0, sum);
                }
                else
                {
                    termList.remove(0);
                }
            }
            else
            {
                termList.add(termToAdd);
            }

        }
        else  // there is more then 1 element in list
        {
            // loop up too last index
            for (int i = 0; i < this.getNumTerms() - 1; i++)
            {
                currentTerm = this.getTerm(i);
                nextTerm = this.getTerm(i + 1);

                // if term to add exponent bigger then current term's exponent
                if (termToAdd.compareTo(currentTerm) == 1)
                {
                    termList.add(i, termToAdd);
                    return;
                }

                // else if term to Add Exponent matches current term's exponent
                else if (termToAdd.compareTo(currentTerm) == 0)
                {
                    sum = termToAdd.plus(currentTerm);
                    if (sum != null)
                    {
                        termList.set(i, sum);
                    }
                    else
                    {
                        termList.remove(i);
                    }
                    return;
                }

                // if term to add exponent is smaller then current term exponent
                // and larger then the next term exponent
                if (termToAdd.compareTo(currentTerm) == -1
                        && termToAdd.compareTo(nextTerm) == 1)
                {
                    // Insert term in between current and next
                    termList.add(i + 1, termToAdd);
                    return;
                }
            }

            // reached last index
            lastIndex = this.getNumTerms() - 1;
            localTerm = this.getTerm(lastIndex);

            if (termToAdd.compareTo(localTerm) == 0)
            {
                sum = termToAdd.plus(localTerm);
                if (sum != null)
                {
                    termList.set(lastIndex, sum);
                }
                else
                {
                    termList.remove(lastIndex);
                }
            }
            else
            {
                termList.add(termToAdd);
            }
        }
    }

}
