/* Author: Eden Demke
 * Date: 2/23/24
 * 
 * (Encrypt files) Encode the file by adding 5 to every byte in 
 * the file. Write a program that prompts the user to enter an 
 * input file name and an output file name and saves the encrypted 
 * version of the input file to the output file.
 */

import java.io.*;
import java.util.Scanner;

public class EncryptingFiles {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        String fileToEncrypt = "";
        String fileToStoreEncryption = "";

        System.out.print("Enter file name that you want encrypted: ");
        fileToEncrypt = input.next();
        System.out.print("Enter file name that you want to store your encrypted file in: ");
        fileToStoreEncryption = input.next();

        DataInputStream fileToBeEncrypted = new DataInputStream(new BufferedInputStream(new
                FileInputStream(fileToEncrypt)));

        DataOutputStream fileToStoreEncryptedData = new DataOutputStream(new
                BufferedOutputStream(new FileOutputStream(fileToStoreEncryption)));

        int value;
        try {
            while ((value = fileToBeEncrypted.readByte()) != -1) {
                fileToStoreEncryptedData.writeByte(fileToBeEncrypted.readByte() + 5);
            }
        } catch (EOFException ex) {
            System.out.println("End of File");
        }
    }

}

