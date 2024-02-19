import java.math.BigDecimal;

public class Converter {
    /**
     * Prints 23-bit mantissa (32 bits total = Single precision)
     * [ S = 1 | exp = 8 | frac = 23 ]
     * and 52-bit mantissa (64 bits total = Double precision)
     * [ S = 1 | exp = 11 | frac = 52 ]
     * 
     * @param input any real number in decimal system
     * @return 32 and 64 bitstring representation (23-bit and 52-bit mantissa)
     */
    public static void IEEE754(double input) {
        BigDecimal x = new BigDecimal(input);
        int signBit = (x.compareTo(BigDecimal.ZERO) == 1) ? 0 : 1;
        int intAbsVal = x.abs().intValue();
        BigDecimal answer = new BigDecimal(intAbsVal);
        StringBuilder intPart = new StringBuilder();
        while ((intAbsVal > 0 && signBit == 0) || (answer.compareTo(BigDecimal.ZERO) == 1 && signBit == 1)) {
            intAbsVal = answer.intValue();
            answer = BigDecimal.valueOf(intAbsVal).divide(BigDecimal.valueOf(2));
            int remainder = BigDecimal.valueOf(intAbsVal).remainder(BigDecimal.valueOf(2)).intValue();
            intPart.append(remainder);
        }
        BigDecimal frac = x.remainder(BigDecimal.ONE).abs();
        StringBuilder fracPart = new StringBuilder();
        for (int i = 0; i < 52; i++) {
            frac = frac.multiply(new BigDecimal("2"));
            int bit = frac.compareTo(BigDecimal.ONE) >= 0 ? 1 : 0;
            fracPart.append(bit);
            frac = frac.subtract(BigDecimal.valueOf(bit)).stripTrailingZeros();
            if (frac.compareTo(BigDecimal.ZERO) == 0) {
                break;
            }
        }
        StringBuilder decimal = new StringBuilder();
        decimal.append(intPart.reverse()).append('.').append(fracPart);
        StringBuilder mantissa23 = new StringBuilder(23);
        StringBuilder mantissa52 = new StringBuilder(52);
        int shift = decimal.indexOf(".") - decimal.indexOf("1") - 1;
        decimal.deleteCharAt(decimal.indexOf("."));
        decimal.insert(decimal.indexOf("1") + 1, ".");
        mantissa23.append(decimal.substring(decimal.indexOf("1") + 2, decimal.length()));
        mantissa52.append(decimal.substring(decimal.indexOf("1") + 2, decimal.length()));
        while (mantissa23.length() < 23) {
            mantissa23.append("0");
        }
        if (mantissa23.length() > 23) {
            mantissa23.delete(23, mantissa23.length());
        }
        while (mantissa52.length() < 52) {
            mantissa52.append("0");
        }
        if (mantissa52.length() > 52) {
            mantissa52.delete(52, mantissa52.length());
        }
        BigDecimal floatExp = BigDecimal.valueOf(shift + 127);
        BigDecimal doubleExp = BigDecimal.valueOf(shift + 1023);
        StringBuilder expField32 = new StringBuilder(8);
        StringBuilder expField64 = new StringBuilder(11);
        for (int i = 0; i < 8; i++) {
            expField32.append((int) floatExp.intValue() % 2);
            floatExp = floatExp.divide(BigDecimal.valueOf(2));
        }
        for (int i = 0; i < 11; i++) {
            expField64.append((int) doubleExp.intValue() % 2);
            doubleExp = doubleExp.divide(BigDecimal.valueOf(2));
        }
        StringBuilder bitstr32 = new StringBuilder();
        StringBuilder bitstr64 = new StringBuilder();
        bitstr32.append(signBit).append(" ").append(expField32.reverse()).append(" ").append(mantissa23);
        bitstr64.append(signBit).append(" ").append(expField64.reverse()).append(" ").append(mantissa52);
        System.out.printf("32 Bit representation = %s\n", bitstr32.toString());
        System.out.printf("64 Bit representation = %s\n", bitstr64.toString());
    }
}