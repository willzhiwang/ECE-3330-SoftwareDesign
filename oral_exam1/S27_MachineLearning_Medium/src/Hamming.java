public class Hamming
{
    /**
     *Calculation of Euclidean Distance
     * @param str1 first string
     * @param str2 second string
     * @return Hamming Distance
     */
    public static int hammingDistance (String str1, String str2)
    {
        int i = 0, count = 0;
        while (i < str1.length())
        {
            if (str1.charAt(i) != str2.charAt(i))
                count++;
            i++;
        }
        return count;
    }
}



