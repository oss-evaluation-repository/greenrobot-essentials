package de.greenrobot.common.checksum;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.zip.Adler32;

public class DataChecksumTest {

    @Test
    public void testUpdateInt() throws Exception {
        int input = Integer.MIN_VALUE + 123456789;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DataOutputStream(byteArrayOutputStream).writeInt(input);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        PrimitiveDataChecksum checksum = new PrimitiveDataChecksum(new Adler32());
        checksum.updateInt(input);
        long value1 = checksum.getValue();

        PrimitiveDataChecksum checksum2 = new PrimitiveDataChecksum(new Adler32());
        checksum2.update(bytes, 0, bytes.length);
        long value2 = checksum2.getValue();
        Assert.assertEquals(value2, value1);
    }

    @Test
    public void testUpdateShort() throws Exception {
        short input = Short.MIN_VALUE + 12345;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DataOutputStream(byteArrayOutputStream).writeShort(input);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        PrimitiveDataChecksum checksum = new PrimitiveDataChecksum(new Adler32());
        checksum.updateShort(input);
        long value1 = checksum.getValue();

        PrimitiveDataChecksum checksum2 = new PrimitiveDataChecksum(new Adler32());
        checksum2.update(bytes, 0, bytes.length);
        long value2 = checksum2.getValue();

        Assert.assertEquals(value2, value1);
    }

    @Test
    public void testUpdateLong() throws Exception {
        long input = Long.MIN_VALUE + 123456789;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DataOutputStream(byteArrayOutputStream).writeLong(input);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        PrimitiveDataChecksum checksum = new PrimitiveDataChecksum(new Adler32());
        checksum.updateLong(input);
        long value1 = checksum.getValue();

        PrimitiveDataChecksum checksum2 = new PrimitiveDataChecksum(new Adler32());
        checksum2.update(bytes, 0, bytes.length);
        long value2 = checksum2.getValue();

        Assert.assertEquals(value2, value1);
    }

    @Test
    public void testUpdateFloat() throws Exception {
        float input = (float) -Math.PI;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DataOutputStream(byteArrayOutputStream).writeFloat(input);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        PrimitiveDataChecksum checksum = new PrimitiveDataChecksum(new Adler32());
        checksum.updateFloat(input);
        long value1 = checksum.getValue();

        PrimitiveDataChecksum checksum2 = new PrimitiveDataChecksum(new Adler32());
        checksum2.update(bytes, 0, bytes.length);
        long value2 = checksum2.getValue();

        Assert.assertEquals(value2, value1);
    }

    @Test
    public void testUpdateDouble() throws Exception {
        double input = -Math.PI;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DataOutputStream(byteArrayOutputStream).writeDouble(input);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        PrimitiveDataChecksum checksum = new PrimitiveDataChecksum(new Adler32());
        checksum.updateDouble(input);
        long value1 = checksum.getValue();

        PrimitiveDataChecksum checksum2 = new PrimitiveDataChecksum(new Adler32());
        checksum2.update(bytes, 0, bytes.length);
        long value2 = checksum2.getValue();

        Assert.assertEquals(value2, value1);
    }

    @Test
    public void testNullValues() throws Exception {
        PrimitiveDataChecksum checksum = new PrimitiveDataChecksum(new Adler32());
        long before = checksum.getValue();
        checksum.update((byte[]) null);
        checksum.update((int[]) null);
        checksum.update((short[]) null);
        checksum.update((long[]) null);
        checksum.update((float[]) null);
        checksum.update((double[]) null);
        checksum.updateUtf8((String) null);
        checksum.updateUtf8((String[]) null);
        Assert.assertEquals(before, checksum.getValue());
    }

}