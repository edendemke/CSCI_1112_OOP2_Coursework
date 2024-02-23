import java.io.*;
import java.util.Scanner;

public class DecryptingFiles {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

        String fileToDecrypt = "";
        String fileToStoreDecryption = "";

        System.out.print("Enter file name that you want decrypted: ");
        fileToDecrypt = input.next();
        System.out.print("Enter file name that you want to store your decrypted file in: ");
        fileToStoreDecryption = input.next();

        DataInputStream fileToBeDecrypted = new DataInputStream(new BufferedInputStream(new
                FileInputStream(fileToDecrypt)));

        DataOutputStream fileToStoreDecryptedData = new DataOutputStream(new
                BufferedOutputStream(new FileOutputStream(fileToStoreDecryption)));

        int value;
        try {
            while ((value = fileToBeDecrypted.readByte()) != -1) {
                fileToStoreDecryptedData.writeByte(fileToBeDecrypted.readByte() - 5);
            }
        } catch (EOFException ex) {
            System.out.println("End of File");
        }
	}

}
