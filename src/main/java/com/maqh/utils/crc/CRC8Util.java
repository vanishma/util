package com.maqh.utils.crc;

/**
 * <p>
 * CRC8 校验类
 * 多项式: x8+x2+x+1
 * </p>
 *
 * @author maqh
 * @version 1.0
 * @since 2021-06-16
 */
public class CRC8Util {
    public void CRC8Util() {
        //Do nothing
    }

    private final static byte[] CHECKSUM_TABLE = {(byte) 0x00, (byte) 0x07, (byte) 0x0e, (byte) 0x09, (byte) 0x1c, (byte) 0x1b,
            (byte) 0x12, (byte) 0x15, (byte) 0x38, (byte) 0x3f, (byte) 0x36, (byte) 0x31, (byte) 0x24, (byte) 0x23, (byte) 0x2a,
            (byte) 0x2d, (byte) 0x70, (byte) 0x77, (byte) 0x7e, (byte) 0x79, (byte) 0x6c, (byte) 0x6b, (byte) 0x62, (byte) 0x65,
            (byte) 0x48, (byte) 0x4f, (byte) 0x46, (byte) 0x41, (byte) 0x54, (byte) 0x53, (byte) 0x5a, (byte) 0x5d, (byte) 0xe0,
            (byte) 0xe7, (byte) 0xee, (byte) 0xe9, (byte) 0xfc, (byte) 0xfb, (byte) 0xf2, (byte) 0xf5, (byte) 0xd8, (byte) 0xdf,
            (byte) 0xd6, (byte) 0xd1, (byte) 0xc4, (byte) 0xc3, (byte) 0xca, (byte) 0xcd, (byte) 0x90, (byte) 0x97, (byte) 0x9e,
            (byte) 0x99, (byte) 0x8c, (byte) 0x8b, (byte) 0x82, (byte) 0x85, (byte) 0xa8, (byte) 0xaf, (byte) 0xa6, (byte) 0xa1,
            (byte) 0xb4, (byte) 0xb3, (byte) 0xba, (byte) 0xbd, (byte) 0xc7, (byte) 0xc0, (byte) 0xc9, (byte) 0xce, (byte) 0xdb,
            (byte) 0xdc, (byte) 0xd5, (byte) 0xd2, (byte) 0xff, (byte) 0xf8, (byte) 0xf1, (byte) 0xf6, (byte) 0xe3, (byte) 0xe4,
            (byte) 0xed, (byte) 0xea, (byte) 0xb7, (byte) 0xb0, (byte) 0xb9, (byte) 0xbe, (byte) 0xab, (byte) 0xac, (byte) 0xa5,
            (byte) 0xa2, (byte) 0x8f, (byte) 0x88, (byte) 0x81, (byte) 0x86, (byte) 0x93, (byte) 0x94, (byte) 0x9d, (byte) 0x9a,
            (byte) 0x27, (byte) 0x20, (byte) 0x29, (byte) 0x2e, (byte) 0x3b, (byte) 0x3c, (byte) 0x35, (byte) 0x32, (byte) 0x1f,
            (byte) 0x18, (byte) 0x11, (byte) 0x16, (byte) 0x03, (byte) 0x04, (byte) 0x0d, (byte) 0x0a, (byte) 0x57, (byte) 0x50,
            (byte) 0x59, (byte) 0x5e, (byte) 0x4b, (byte) 0x4c, (byte) 0x45, (byte) 0x42, (byte) 0x6f, (byte) 0x68, (byte) 0x61,
            (byte) 0x66, (byte) 0x73, (byte) 0x74, (byte) 0x7d, (byte) 0x7a, (byte) 0x89, (byte) 0x8e, (byte) 0x87, (byte) 0x80,
            (byte) 0x95, (byte) 0x92, (byte) 0x9b, (byte) 0x9c, (byte) 0xb1, (byte) 0xb6, (byte) 0xbf, (byte) 0xb8, (byte) 0xad,
            (byte) 0xaa, (byte) 0xa3, (byte) 0xa4, (byte) 0xf9, (byte) 0xfe, (byte) 0xf7, (byte) 0xf0, (byte) 0xe5, (byte) 0xe2,
            (byte) 0xeb, (byte) 0xec, (byte) 0xc1, (byte) 0xc6, (byte) 0xcf, (byte) 0xc8, (byte) 0xdd, (byte) 0xda, (byte) 0xd3,
            (byte) 0xd4, (byte) 0x69, (byte) 0x6e, (byte) 0x67, (byte) 0x60, (byte) 0x75, (byte) 0x72, (byte) 0x7b, (byte) 0x7c,
            (byte) 0x51, (byte) 0x56, (byte) 0x5f, (byte) 0x58, (byte) 0x4d, (byte) 0x4a, (byte) 0x43, (byte) 0x44, (byte) 0x19,
            (byte) 0x1e, (byte) 0x17, (byte) 0x10, (byte) 0x05, (byte) 0x02, (byte) 0x0b, (byte) 0x0c, (byte) 0x21, (byte) 0x26,
            (byte) 0x2f, (byte) 0x28, (byte) 0x3d, (byte) 0x3a, (byte) 0x33, (byte) 0x34, (byte) 0x4e, (byte) 0x49, (byte) 0x40,
            (byte) 0x47, (byte) 0x52, (byte) 0x55, (byte) 0x5c, (byte) 0x5b, (byte) 0x76, (byte) 0x71, (byte) 0x78, (byte) 0x7f,
            (byte) 0x6a, (byte) 0x6d, (byte) 0x64, (byte) 0x63, (byte) 0x3e, (byte) 0x39, (byte) 0x30, (byte) 0x37, (byte) 0x22,
            (byte) 0x25, (byte) 0x2c, (byte) 0x2b, (byte) 0x06, (byte) 0x01, (byte) 0x08, (byte) 0x0f, (byte) 0x1a, (byte) 0x1d,
            (byte) 0x14, (byte) 0x13, (byte) 0xae, (byte) 0xa9, (byte) 0xa0, (byte) 0xa7, (byte) 0xb2, (byte) 0xb5, (byte) 0xbc,
            (byte) 0xbb, (byte) 0x96, (byte) 0x91, (byte) 0x98, (byte) 0x9f, (byte) 0x8a, (byte) 0x8d, (byte) 0x84, (byte) 0x83,
            (byte) 0xde, (byte) 0xd9, (byte) 0xd0, (byte) 0xd7, (byte) 0xc2, (byte) 0xc5, (byte) 0xcc, (byte) 0xcb, (byte) 0xe6,
            (byte) 0xe1, (byte) 0xe8, (byte) 0xef, (byte) 0xfa, (byte) 0xfd, (byte) 0xf4, (byte) 0xf3};

    /**
     * CRC8 校验 多项式 x8+x2+x+1
     *
     * @param b   需要检验的byte数组
     * @param off 开始校验位
     * @param len 长度
     * @return 校验结果
     */
    public static byte cRC8Check(final byte[] b, final int off, final int len) {
        byte result = 0x00;
        for (int i = 0; i < len; i++) {
            result = CHECKSUM_TABLE[(result ^ (b[i + off] & 0xFF)) & 0Xff];
        }
        return (byte) (result & 0xFFL);
    }

    /**
     * 接收byte数组 进行校验
     *
     * @param b byte[]
     * @return 校验结果
     */
    public static byte chChe(final byte[] b) {
        return cRC8Check(b, 0, b.length);
    }

    /**
     * 获取字符位置
     *
     * @param c 字符
     * @return 位置
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * crc 验证方法
     * @param data 需要验证的字符串
     * @return crc
     */
    public static String hexCrc(String data) {
        byte by = chChe(hexStringToBytes(data));
        return bytesToHexString(by);
    }

    /**
     * crc验证后长度转一字节
     * @param src crc
     * @return crc 一字节
     */
    public static String bytesToHexString(byte src) {
        StringBuilder stringBuilder = new StringBuilder("");
        int v = src & 0xFF;
        String hv = Integer.toHexString(v);
        if (hv.length() < 2) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hv);
        return stringBuilder.toString();
    }

    /**
     * 字符串转直接数组
     * @param hexString  16进制字符串
     * @return 字节数组
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || "".equals(hexString)) {
            return new byte[1];
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1])) ;
        }
        return d;
    }
}
