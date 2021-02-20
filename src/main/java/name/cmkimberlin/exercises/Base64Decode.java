package name.cmkimberlin.exercises;

import org.apache.commons.codec.binary.Base64;

import java.util.Scanner;

/**
 * Caleb Kimberlin
 * This program takes in either a String input and converts it into Base64, or a Base64 input and converts it into a String
*/
public class Base64Decode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String newCode;

        System.out.println("Please enter a message you would like encoded: ");
        newCode = input.nextLine();

        System.out.print("The encoded sentence: ");
        System.out.println(encode((newCode.getBytes())));

        String trueCode;
        trueCode = encode(newCode.getBytes());

        System.out.print("This is the encoded sentence decoded back: ");
        System.out.println(new String(decode(trueCode)));
        System.out.println("This is the encoded secret message: VGhpcyBpcyBhIHNlY3JldCBtZXNzYWdlLiBEb24ndCB0ZWxsIGFueWJvZHkh");
        System.out.print("The secret message will now be revealed: ");
        System.out.println(new String(decode("VGhpcyBpcyBhIHNlY3JldCBtZXNzYWdlLiBEb24ndCB0ZWxsIGFueWJvZHkh")));
    }

    //Takes String input and encodes into base64
    public static String encode(byte[] encodedText) {
        Base64 base64 = new Base64();
        return new String(base64.encode(encodedText));
    }

    //Takes Base64 input and decodes into String
    public static byte[] decode(String decodedText) {
        Base64 base64 = new Base64();
        return base64.decode(decodedText.getBytes());
    }
}

