public class LousyStringHasher implements StringHasher
{
    public int hash(String wordToHash)
    {
        int hashKeyValue = 0;

        for (int i = 0; i < wordToHash.length(); i++)
        {
            int charCode = wordToHash.charAt(i);

            int hKVTemp = hashKeyValue;

            hashKeyValue = (hashKeyValue * 27 + charCode) % 60389;

//            hashKeyValue += wordToHash.charAt(i);

//            System.out.println("Hash Key Value " + hKVTemp
//                            + " * 27 + Character Code " + charCode + " % 60389 "
//                            + " = " + hashKeyValue);


        }

        return hashKeyValue;
    }
}