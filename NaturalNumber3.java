import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumberSecondary;

/**
 * {@code NaturalNumber} represented as a {@code String} with implementations of
 * primary methods.
 *
 * @convention <pre>
 * [all characters of $this.rep are '0' through '9']  and
 * [$this.rep does not start with '0']
 * </pre>
 * @correspondence <pre>
 * this = [if $this.rep = "" then 0
 *         else the decimal number whose ordinary depiction is $this.rep]
 * </pre>
 *
 * @author Sonali Manoharan, Jana Abedeljaber
 *
 */
public class NaturalNumber3 extends NaturalNumberSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private String rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        // TODO - fill in body
        this.rep = "";

    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public NaturalNumber3() {

        // TODO - fill in body
        this.createNewRep();

    }

    /**
     * Constructor from {@code int}.
     *
     * @param i
     *            {@code int} to initialize from
     */
    public NaturalNumber3(int i) {
        assert i >= 0 : "Violation of: i >= 0";

        // TODO - fill in body
        this.createNewRep();
        this.rep = Integer.toString(i);

    }

    /**
     * Constructor from {@code String}.
     *
     * @param s
     *            {@code String} to initialize from
     */
    public NaturalNumber3(String s) {
        assert s != null : "Violation of: s is not null";
        assert s.matches("0|[1-9]\\d*") : ""
                + "Violation of: there exists n: NATURAL (s = TO_STRING(n))";

        // TODO - fill in body
        this.createNewRep();
        if(!this.rep.equals("0"))
        {
            this.rep = s;
        }

    }

    /**
     * Constructor from {@code NaturalNumber}.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     */
    public NaturalNumber3(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";

        // TODO - fill in body
        if (n.isZero()) {
            this.rep = "";
        } else {
            this.rep = n.toString();
        }

    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final NaturalNumber newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(NaturalNumber source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof NaturalNumber3 : ""
                + "Violation of: source is of dynamic type NaturalNumberExample";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        NaturalNumber3 localSource = (NaturalNumber3) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void multiplyBy10(int k) {
        assert 0 <= k : "Violation of: 0 <= k";
        assert k < RADIX : "Violation of: k < 10";

        // TODO - fill in body
         // if this.rep in an empty string it assigns it to zero
        if (this.rep == "") {
            this.rep = "0";
        }

        // Append k to the end.
        else {
            this.rep += Integer.toString(k);
        }

    }

    @Override
    public final int divideBy10() {

        // TODO - fill in body
         // If string is empty or zero it will equal 0
        if (this.rep.equals("") || this.rep.equals("0")) {
            return 0;
        }

        // Get last character of number
        char lastDigit = this.rep.charAt(this.rep.length() - 1);

        // remove the last digit from string representation
        this.rep = this.rep.substring(0, this.rep.length() - 1);

        // if after removing last digit it becomes an empty string we put 0
        if (this.rep.isEmpty()) {
            this.rep = "0";
        }
        // return digit that was the remainder
        return Character.getNumericValue(lastDigit);
    }

    @Override
    public final boolean isZero() {

        // TODO - fill in body
// variable to store result
        boolean isZeroValue;

        // Check if value is "0"
        boolean isExplicitZero = this.rep.equals("0");

        // Check if value is an empty string
        boolean isEmptyRepresentation = this.rep.equals("");

        // If either the value is "0" or an empty string the number is zero
        if (isExplicitZero || isEmptyRepresentation) {
            isZeroValue = true;
        } else {
            isZeroValue = false;
        }

        // Return the result
        return isZeroValue;
    }

}
