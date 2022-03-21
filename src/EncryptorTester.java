import java.util.Arrays;
import java.util.ArrayList;
public class EncryptorTester {
    public static void main(String[] args) {
        Encryptor e1 = new Encryptor(3,4);
        //System.out.println(e1.decryptMessage("J  haapovnynadtA"));
        Encryptor e2= new Encryptor(9,8);
        //System.out.println(e2.decryptMessage("Io ihscnongeoesofn rnn  do.cac poir rprirfnmTyhyso gahpyp ce tit,tteniis  siea o,pc gpttr rotirihmkonhneoeancveasn toee le iiwsro nononstrrtffn atttencxlseoe oitl x rfwp.yptanonh ,l,nar eI a  tmardoiiai stennnlvk ealyit real  zid rcaaaeeeatkinudsc e ndt  icxtt hpcpitoeaoaahp  xcrrnehbptceo tc t  sriird pisinoyoirn gfnpetettio.tssvehnr i eereamEonlnf lannoftert eetoite tl  unondhlctltrceeioode.en gn -r  iiitabcFbenbe eeoustlnw pr annn  patlsc uusne ,rsssedcr ycueuoheaphasdmnantel o is imla-ecoeoey rnc eyoIsotrkr rts  yeaai idtpytntibeht e hslceigdam er oe l.p ymnnbg otpests  r-dtshstb d iaoehuaeeoguset snnets ,wic   ik egrswpneflnyciogyolephesearsi dmi te lr.edcisale ,eooonsqA rmnud uncapar ai obulcsrranlt ekeeut naceehrhrtsr  eooe iymw vrcclpeikiiiaytstedzpn  shyeei dta  ddeeehgtp brribthuAyi puoosA gtit reAtioe uirAhn nnnzsAeartoae.A testudAAooc  t AA"));
        Encryptor e3 = new Encryptor(1,1);
        String[][] original = {{"a","b","c"},{"d","e","f"},{"g","h","i"}};
        e3.encryptRightDecryptLeft(original,2);
        for (String[] s:original){
            for (int i=0;i<s.length;i++){
                System.out.print(s[i]);
            }
            System.out.println();
        }
        e3.encryptLeftDecryptRight(original,2);
        for (String[] s:original){
            for (int i=0;i<s.length;i++){
                System.out.print(s[i]);
            }
            System.out.println();
        }
    }
    public static void print2DArray(String[][] arr)
    {
        for (String[] row : arr)
        {
            for (String val : row)
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
