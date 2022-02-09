package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {

	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		byte[] rpcmsg = new byte[payload.length + 1];

		// TODO - START

		// Encapsulate the rpcid and payload in a byte array according to the RPC
		// message syntax

		rpcmsg[0] = rpcid;

		for (int i = 0; i < payload.length; i++) {
			rpcmsg[i + 1] = payload[i];
		}

		// TODO - END

		return rpcmsg;
	}

	public static byte[] decapsulate(byte[] rpcmsg) {

		byte[] payload = new byte[rpcmsg.length - 1];

		// TODO - START

		// Decapsulate the rpcid and payload in a byte array according to the RPC
		// message syntax

		for (int i = 0; i < payload.length; i++) {
			payload[i] = rpcmsg[i + 1];
		}
		// TODO - END

		return payload;

	}

	public static byte[] marshallString(String str) {

		// TODO - START

		byte[] encoded = new byte[str.length()];

		for (int i = 0; i < str.length(); i++) {
			encoded[i] = (byte) str.charAt(i);
		}
		// TODO - END

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = new String(data);

		// TODO - START

		// TODO - END

		return decoded;
	}

	public static byte[] marshallVoid() {

		byte[] encoded = new byte[0];

		// TODO - START

		// TODO - END

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO

	}

	public static byte[] marshallBoolean(boolean b) {

		byte[] encoded = new byte[1];

		if (b) {
			encoded[0] = 1;
		} else {
			encoded[0] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[0] > 0);

	}

	public static byte[] marshallInteger(int x) {

		byte[] encoded = null;

		// TODO - START
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.putInt(x);

		encoded = buffer.array();
		// TODO - END

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded = 0;

		// TODO - START
		ByteBuffer buffer = ByteBuffer.wrap(data);

		decoded = buffer.getInt();
		// TODO - END

		return decoded;

	}
}
