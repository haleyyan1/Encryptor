import java.util.ArrayList;
public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        letterBlock = new String[numRows][numCols];
        int in=0;
        for (int i = 0;i<numRows;i++){
            int ind = in;
            for (int j = 0;j<numCols;j++){
                if (ind<str.length()){
                    letterBlock[i][j]=str.substring(ind,ind+1);
                    ind++;
                }
                else {
                    letterBlock[i][j]="A";
                }
            }
            in+=numCols;
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String s="";
        for (int i =0;i<numCols;i++){
            for (int j =0;j<numRows;j++){
                s+=letterBlock[j][i];
            }
        }
        return s;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        int n = 0;
        int d = numRows*numCols;
        if (message.length()%d==0){
            n=message.length()/d;
        }
        else {
            n=message.length()/d+1;
        }
        String s ="";
        int st = 0;
        for (int i =0; i<n;i++){
            if (st+d<message.length()){
                fillBlock(message.substring(st,st+d));
            }
            else {
                fillBlock(message.substring(st));
            }
            s+=encryptBlock();
            st+=d;
        }
        return s;
    }

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        String[][] e = new String[numRows][numCols];
        String s = "";
        String[] en = encryptedMessage.split("");
        int ind = 0;
        int in = 0;
        while (in<encryptedMessage.length()){
            for (int i =0;i<numCols;i++){
                for (int j = 0;j<numRows;j++){
                    e[j][i]=en[ind];
                    ind++;
                }
            }
            for (int k=0;k<e.length;k++){
                for (int m = 0;m<e[0].length;m++){
                    s+=e[k][m];
                }
            }
            in+=numRows*numCols;
        }
        while (s.endsWith("A")){
            s=s.substring(0,s.length()-1);
        }
        return s;
    }
    public void encryptRightDecryptLeft(String[][] list, int shiftNum)
    {
        for (int j = 0; j<list.length;j++){
        String[] n = new String[list[j].length];
        for (int i = 0; i<list[j].length; i++) {
            n[i] = list[j][i];
        }
        for (int i = 0; i<list[j].length;i++) {
            int d = i-shiftNum;
            if (d<0) {
                d+=list[j].length;
            }
            list[j][i] = n[d];
        }
    } }
    public void encryptLeftDecryptRight(String[][] list, int shiftNum)
    {
        for (int j = 0; j<list.length;j++){
            String[] n = new String[list[j].length];
            for (int i = 0; i<list[j].length; i++) {
                n[i] = list[j][i];
            }
            for (int i = 0; i<list[j].length;i++) {
                if (i+shiftNum>list[j].length-1) {
                    list[j][i] = n[shiftNum-(n.length-i)];
                }
                else {
                    list[j][i] = n[i+shiftNum];
                }
            }
    } }
}
