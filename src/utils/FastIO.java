package utils;

import java.io.*;
import java.util.StringTokenizer;

public class FastIO extends PrintWriter {
    private final BufferedReader reader;
    private StringTokenizer st;
    private String token;

    public FastIO(InputStream i) {
        super(new BufferedOutputStream(System.out));
        reader = new BufferedReader(new InputStreamReader(i));
    }
    public FastIO(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        reader = new BufferedReader(new InputStreamReader(i));
    }

    public FastIO(String f, OutputStream o) throws FileNotFoundException {
        super(new BufferedOutputStream(o));
        reader = new BufferedReader(new FileReader(f));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public byte nextByte() {
        return Byte.parseByte(nextToken());
    }

    public short nextShort() { return Short.parseShort(nextToken()); }

    public char nextChar() throws IOException { return (char) reader.read(); }

    public String nextWord() { return nextToken(); }

    public String readLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return line;
    }

    public boolean hasNextLine() {
        boolean nextLine = false;
        try {
            nextLine = reader.ready();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return nextLine;
    }

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = reader.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
